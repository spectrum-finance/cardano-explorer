package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive

@derive(customizableEncoder, customizableDecoder)
trait Credential

object Credential {

  final case class PubKeyCredential(pubkeyHash: String) extends Credential
  final case class ScriptCredential(validatorHash: String) extends Credential
}
