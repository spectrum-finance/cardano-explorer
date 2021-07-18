package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive
import org.ergoLabs.cardanoExplorer.domain.Address.AddressCredential
import sttp.tapir.Schema

@derive(customizableEncoder, customizableDecoder)
final case class Address(addressStakingCredential: Option[String], addressCredential: AddressCredential)

object Address {
  implicit val schema: Schema[Address] = Schema.derived[Address]

  @derive(customizableEncoder, customizableDecoder)
  final case class AddressCredential(contents: Contents, tag: String = "PubKeyCredential")

  object AddressCredential {
    implicit val schema: Schema[AddressCredential] = Schema.derived[AddressCredential]

  }

  @derive(customizableEncoder, customizableDecoder)
  final case class Contents(getPubKeyHash: String)

  object Contents {
    implicit val schema: Schema[Contents] = Schema.derived[Contents]

  }

}
