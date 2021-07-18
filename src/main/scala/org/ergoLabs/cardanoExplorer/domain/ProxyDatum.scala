package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive

@derive(customizableEncoder, customizableDecoder)
final case class ProxyDatum(
  action: String,
  slippageTolerance: Int,
  rate: Int,
  dexFeeDatum: Int,
  userPubKeyHash: String,
  xProxyToken: String,
  yProxyToken: String,
  targetPoolId: String,
  lpProxyToken: String
)
