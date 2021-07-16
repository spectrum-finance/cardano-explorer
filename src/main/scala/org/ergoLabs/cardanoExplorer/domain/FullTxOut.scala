package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive
import org.ergoLabs.cardanoExplorer.domain.datum.Datum
import sttp.tapir.Schema

@derive(customizableEncoder, customizableDecoder)
final case class FullTxOut(
  txId: TxId,
  refIdx: RefIdx,
  txOutAddress: Address,
  txOutValue: Value,
  fullTxOutDatum: Datum
)

object FullTxOut {

  implicit val schema: Schema[FullTxOut] = Schema.derived[FullTxOut]
}
