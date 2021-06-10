package ergo.labs.dex

import cats.effect.ExitCode
import cats.syntax.functor._
import monix.eval.{Task, TaskApp}
import org.http4s.implicits.http4sKleisliResponseSyntaxOptionT
import org.http4s.server.blaze.BlazeServerBuilder

import scala.concurrent.ExecutionContext.global

object Main extends TaskApp {

  val http = new HttpServer

  override def run(args: List[String]): Task[ExitCode] =
    BlazeServerBuilder[Task](global).bindHttp(8081, "0.0.0.0").withHttpApp(http.routes.orNotFound)
      .serve.compile.drain as ExitCode.Success
}
