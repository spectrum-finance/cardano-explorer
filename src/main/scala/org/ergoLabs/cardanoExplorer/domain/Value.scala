package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.customizableEncoder
import derevo.derive

@derive(customizableEncoder)
final case class Value(getValue: List[(CurrencySymbol, List[(TokenName, Long)])])
