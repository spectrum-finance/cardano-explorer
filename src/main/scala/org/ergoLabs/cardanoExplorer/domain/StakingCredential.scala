package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive
import sttp.tapir.Schema

@derive(customizableEncoder, customizableDecoder)
sealed trait StakingCredential

object StakingCredential {

  final case class StakingHash(value: Credential) extends StakingCredential
  //todo: naming
  final case class StakingPtr(a: Int, b: Int, c: Int) extends StakingCredential

  implicit val schema: Schema[StakingCredential] = Schema.derived[StakingCredential]
}
