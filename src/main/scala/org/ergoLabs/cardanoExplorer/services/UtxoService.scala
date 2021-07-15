package org.ergoLabs.cardanoExplorer.services

import org.ergoLabs.cardanoExplorer.domain.{FullTxOut, Id, TxOut}

trait UtxoService[F[_]] {

  def getFullTxOutById(id: Id): F[Option[FullTxOut]]

  def getTxOutById(id: Id): F[Option[TxOut]]
}
