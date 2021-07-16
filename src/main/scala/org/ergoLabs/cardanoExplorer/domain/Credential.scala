package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive
import sttp.tapir.Schema

@derive(customizableEncoder, customizableDecoder)
sealed trait Credential

object Credential {

  final case class PubKeyCredential(pubkeyHash: String, tag: String = "PubKeyCredential") extends Credential
  final case class ScriptCredential(validatorHash: String, tag: String = "PubKeyCredential") extends Credential

  implicit val schema: Schema[Credential] = Schema.derived[Credential]
}
