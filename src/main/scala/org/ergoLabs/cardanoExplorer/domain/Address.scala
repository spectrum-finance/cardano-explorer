package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive
import sttp.tapir.Schema

@derive(customizableEncoder, customizableDecoder)
final case class Address(addressCredential: Credential, addressStakingCredential: Option[StakingCredential])

object Address {
  implicit val schema: Schema[Address] = Schema.derived[Address]
}
