package org.ergoLabs.cardanoExplorer.domain.datum

import org.ergoLabs.cardanoExplorer.domain.plutus.AssetClass

final case class ErgoDexPool(
  feeNum: Int,
  xCoin: AssetClass,
  yCoin: AssetClass,
  lpCoin: AssetClass
) extends Datum
