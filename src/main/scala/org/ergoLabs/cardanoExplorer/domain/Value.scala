package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive
import sttp.tapir.Schema
import sttp.tapir.generic.auto._

@derive(customizableEncoder, customizableDecoder)
final case class Value(getValue: List[(CurrencySymbol, List[(TokenName, Long)])])

object Value {
  implicit val schema: Schema[Value] = Schema.derived
}
