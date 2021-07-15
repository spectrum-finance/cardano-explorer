package org.ergoLabs.cardanoExplorer

import io.estatico.newtype.macros.newtype

package object domain {

  @newtype case class Id(value: String)

  @newtype case class TxId(value: String)

  @newtype case class RefIdx(value: Int)
}
