package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive

@derive(customizableEncoder, customizableDecoder)
trait StakingCredential

object StakingCredential {

  final case class StakingHash(value: Credential) extends StakingCredential
  //todo: naming
  final case class StakingPtr(a: Int, b: Int, c: Int) extends StakingCredential
}
