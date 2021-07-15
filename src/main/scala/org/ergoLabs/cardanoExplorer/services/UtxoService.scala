package org.ergoLabs.cardanoExplorer.services

import cats.Applicative
import org.ergoLabs.cardanoExplorer.domain.{FullTxOut, Id, TxOut}
import tofu.syntax.monadic._

trait UtxoService[F[_]] {

  def getFullTxOutById(id: Id): F[Option[FullTxOut]]

  def getTxOutById(id: Id): F[Option[TxOut]]
}

object UtxoService {

  //todo: add logging
  def make[I[+_]: Applicative, F[_]]: I[UtxoService[F]] = new Live[F].pure[I]

  private final class Live[F[_]] extends UtxoService[F] {

    override def getFullTxOutById(id: Id): F[Option[FullTxOut]] = ???

    override def getTxOutById(id: Id): F[Option[TxOut]] = ???
  }
}
