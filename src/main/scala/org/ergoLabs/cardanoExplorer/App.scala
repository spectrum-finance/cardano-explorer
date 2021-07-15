package org.ergoLabs.cardanoExplorer

import cats.effect.{Concurrent, ConcurrentEffect, ExitCode, Resource}
import monix.eval.{Task, TaskApp}
import org.ergoLabs.cardanoExplorer.context.AppContext
import org.http4s.server.Server
import tofu.env.Env
import tofu.logging.Logs

object App extends TaskApp {

  type InitF[+A] = Task[A]
  type AppF[+A] = Env[AppContext, A]

  implicit private def logs: Logs[Task, AppF] = Logs.sync[Task, AppF]

  override def run(args: List[String]): Task[ExitCode] = ???

  def init[I[+_]: ConcurrentEffect, F[+_]: Concurrent](implicit logs: Logs[I, F]): Resource[I, Server[I]] = ???
}
