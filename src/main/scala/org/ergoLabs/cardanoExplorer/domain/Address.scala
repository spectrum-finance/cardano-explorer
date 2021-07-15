package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive

@derive(customizableEncoder, customizableDecoder)
final case class Address(addressCredential: Credential, addressStakingCredential: Option[StakingCredential])
