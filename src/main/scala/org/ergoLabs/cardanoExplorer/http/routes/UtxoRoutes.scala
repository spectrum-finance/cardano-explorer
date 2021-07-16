package org.ergoLabs.cardanoExplorer.http.routes

import cats.Monad
import cats.data.EitherT
import cats.syntax.functor._
import cats.syntax.applicative._
import cats.syntax.either._
import cats.effect.{Concurrent, ContextShift, Timer}
import cats.implicits.toSemigroupKOps
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

  var height = 1

  val routes: HttpRoutes[F] = getFullTxOutR <+> getHeightR

  def getFullTxOutR = Http4sServerInterpreter.toRoutes(getUtxos) { _ =>
    utxoService.getFullTxOuts.map(_.asRight[ApiErr])
  }

  def getHeightR = Http4sServerInterpreter.toRoutes(getHeight) { _ =>
    val currentHeight = height
    height += 1
    currentHeight.asRight[ApiErr].pure
  }
}

object UtxoRoutes {

  def make[F[_]: Concurrent: ContextShift: Timer](implicit utxoService: UtxoService[F]): HttpRoutes[F] =
    new UtxoRoutes[F](utxoService).routes
}
