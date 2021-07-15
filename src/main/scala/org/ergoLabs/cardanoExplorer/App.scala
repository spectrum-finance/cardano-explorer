package org.ergoLabs.cardanoExplorer

import cats.effect.{Concurrent, ConcurrentEffect, ContextShift, ExitCode, Resource, Timer}
import monix.eval.{Task, TaskApp}
import org.ergoLabs.cardanoExplorer.config.{AppConfig, Args}
import org.ergoLabs.cardanoExplorer.context.AppContext
import org.ergoLabs.cardanoExplorer.http.HttpServer
import org.ergoLabs.cardanoExplorer.services.UtxoService
import org.http4s.server.Server
import tofu.WithRun
import tofu.env.Env
import tofu.lift.Unlift
import tofu.logging.Logs
import tofu.syntax.context.runContext
import tofu.syntax.monadic._

object App extends TaskApp {

  type InitF[+A] = Task[A]
  type AppF[+A]  = Env[AppContext, A]

  implicit private def logs: Logs[Task, AppF] = Logs.sync[Task, AppF]

  override def run(args: List[String]): Task[ExitCode] =
    init[InitF, AppF](Args.read(args))
      .use(_ => Task.never as ExitCode.Success)

  def init[I[+_]: ConcurrentEffect: Timer: ContextShift, F[+_]: Concurrent: ContextShift: Timer](
    args: Args
  )(implicit WR: WithRun[F, I, AppContext], logs: Logs[I, F]): Resource[I, Server[I]] =
    for {
      blocker <- blockers.namedBlocker[I]("vag")
      appCfg  <- Resource.eval[I, AppConfig](AppConfig.load[I](args.configFilePathOpt, blocker))
      context = AppContext(appCfg)
      implicit0(ul: Unlift[F, I]) <-
        Resource.eval(runContext(WR.subIso.map(isoK => Unlift.byIso(isoK.inverse)))(context))
      implicit0(utxoService: UtxoService[F]) <- Resource.eval[I, UtxoService[F]](UtxoService.make[I, F])
      httpServer                             <- HttpServer.make[I, F](appCfg.httpConfig)
    } yield httpServer
}
