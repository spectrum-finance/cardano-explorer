package org.ergoLabs.cardanoExplorer.http

import cats.effect.{Concurrent, ConcurrentEffect, ContextShift, Resource, Timer}
import org.ergoLabs.cardanoExplorer.config.HttpConfig
import org.ergoLabs.cardanoExplorer.http.routes.UtxoRoutes
import org.ergoLabs.cardanoExplorer.services.UtxoService
import org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.server.{Router, Server}
import org.http4s.syntax.kleisli._
import tofu.lift.Unlift

import scala.concurrent.ExecutionContext

object HttpServer {

  def make[I[_]: ConcurrentEffect: Timer, F[_]: Concurrent: ContextShift: Timer: Unlift[*[_], I]](
    http: HttpConfig
  )(implicit utxoService: UtxoService[F]): Resource[I, Server[I]] = {
    val utxoRoutes = UtxoRoutes.make[F]
    val httpApi    = Router("/" -> unliftRoutes[F, I](utxoRoutes)).orNotFound
    BlazeServerBuilder[I](ExecutionContext.global)
      .bindHttp(http.port, http.host)
      .withHttpApp(httpApi)
      .resource
  }
}
