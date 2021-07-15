package org.ergoLabs.cardanoExplorer.http.routes

import cats.Monad
import cats.data.EitherT
import cats.effect.{Concurrent, ContextShift, Timer}
import org.ergoLabs.cardanoExplorer.http.ApiErr
import org.ergoLabs.cardanoExplorer.http.ApiErr.NotFound
import org.ergoLabs.cardanoExplorer.services.UtxoService
import org.http4s.HttpRoutes
import sttp.tapir.server.http4s.{Http4sServerInterpreter, Http4sServerOptions}
import tofu.syntax.monadic._

final class UtxoRoutes[F[_]: Concurrent: ContextShift: Timer](utxoService: UtxoService[F])(implicit
  opts: Http4sServerOptions[F, F]
) {

  import org.ergoLabs.cardanoExplorer.http.defs.UtxoEndpointDefs._

  val routes: HttpRoutes[F] = getFullTxOutR

  //todo: add syntax to work with F[Option]
  def getFullTxOutR = Http4sServerInterpreter.toRoutes(getUtxoById) { id =>
    EitherT.fromOptionF(utxoService.getFullTxOutById(id), (NotFound(404, "FullTxOut doesn't exist"): ApiErr)).value
  }
}

object UtxoRoutes {

  def make[F[_]: Concurrent: ContextShift: Timer](implicit utxoService: UtxoService[F]): HttpRoutes[F] =
    new UtxoRoutes[F](utxoService).routes
}
