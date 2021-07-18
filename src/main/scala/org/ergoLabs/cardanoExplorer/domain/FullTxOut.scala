package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive
import org.ergoLabs.cardanoExplorer.domain.Datum.Datum1
import sttp.tapir.Schema

@derive(customizableEncoder, customizableDecoder)
final case class FullTxOut(
  outGId: Gid,
  refId: TxId,
  refIdx: RefIdx,
  txOutAddress: Address,
  txOutValue: Value,
  fullTxOutDatum: Datum1
)

object FullTxOut {

  implicit val schema: Schema[FullTxOut] = Schema.derived[FullTxOut]
}
