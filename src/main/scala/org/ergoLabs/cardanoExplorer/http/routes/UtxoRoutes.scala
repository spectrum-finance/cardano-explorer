package org.ergoLabs.cardanoExplorer.http.routes

import cats.Monad
import cats.data.EitherT
import cats.effect.{Concurrent, ContextShift, Timer}
import org.ergoLabs.cardanoExplorer.http.ApiErr
import org.ergoLabs.cardanoExplorer.http.ApiErr.NotFound
import org.ergoLabs.cardanoExplorer.services.UtxoService
import org.http4s.HttpRoutes
import sttp.tapir.server.http4s.{Http4sServerInterpreter, Http4sServerOptions}
import org.ergoLabs.cardanoExplorer.http.syntax.routes._

final class UtxoRoutes[F[_]: Concurrent: ContextShift: Timer](utxoService: UtxoService[F])(implicit
  opts: Http4sServerOptions[F, F]
) {

  import org.ergoLabs.cardanoExplorer.http.defs.UtxoEndpointDefs._

  val routes: HttpRoutes[F] = getFullTxOutR

  def getFullTxOutR = Http4sServerInterpreter.toRoutes(getUtxoById) { id =>
    utxoService.getFullTxOutById(id).orNotFound("Not found")
  }
}

object UtxoRoutes {

  def make[F[_]: Concurrent: ContextShift: Timer](implicit utxoService: UtxoService[F]): HttpRoutes[F] =
    new UtxoRoutes[F](utxoService).routes
}
