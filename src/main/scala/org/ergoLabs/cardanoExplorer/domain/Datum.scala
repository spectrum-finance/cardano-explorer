package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive
import sttp.tapir.Schema

@derive(customizableEncoder, customizableDecoder)
sealed trait Datum

object Datum {
  final case class ErgoDexPool(data: String) extends Datum

  implicit val schema: Schema[Datum] = Schema.derived[Datum]
}
