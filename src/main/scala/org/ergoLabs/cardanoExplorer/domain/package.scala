package org.ergoLabs.cardanoExplorer

import io.circe.generic.JsonCodec
import io.circe.magnolia.configured.Configuration
import io.estatico.newtype.macros.newtype

package object domain {

  implicit val config: Configuration = Configuration.default

  @newtype case class Id(value: String)

  @newtype case class TxId(value: String)

  @newtype case class RefIdx(value: Int)

  @newtype case class CurrencySymbol(unCurrencySymbol: String)

  @newtype case class TokenName(unTokenName: String)
}
