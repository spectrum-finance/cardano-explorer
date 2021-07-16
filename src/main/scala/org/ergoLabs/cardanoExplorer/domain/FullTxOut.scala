package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive
import sttp.tapir.Schema

@derive(customizableEncoder, customizableDecoder)
final case class FullTxOut(
  refId: TxId,
  refIdx: RefIdx,
  txOutAddress: Address,
  txOutValue: Value,
  fullTxOutDatum: Datum
)

object FullTxOut {

  implicit val schema: Schema[FullTxOut] = Schema.derived[FullTxOut]
}
