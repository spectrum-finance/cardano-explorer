package org.ergoLabs.cardanoExplorer.domain.plutus

import org.ergoLabs.cardanoExplorer.domain.{CurrencySymbol, TokenName}

final case class AssetClass(unAssetClass: (CurrencySymbol, TokenName))
