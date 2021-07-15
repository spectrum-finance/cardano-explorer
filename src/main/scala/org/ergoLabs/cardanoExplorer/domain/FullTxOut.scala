package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive

@derive(customizableEncoder, customizableDecoder)
final case class FullTxOut(
  txId: TxId,
  refIdx: RefIdx,
  txOutAddress: Address,
  txOutValue: Value,
  fullTxOutDatum: Datum
)
