package org.ergoLabs.cardanoExplorer.domain

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive
import enumeratum.values.{StringEnum, StringEnumEntry}
import sttp.tapir.Schema

@derive(customizableEncoder, customizableDecoder)
sealed trait Datum

object Datum {

  @derive(customizableEncoder, customizableDecoder)
  final case class Datum1(getDatum: String)

  object Datum1 {
    implicit val schema: Schema[Datum1] = Schema.derived[Datum1]

  }

  @derive(customizableEncoder, customizableDecoder)
  final case class ErgoDexPool(data: String) extends Datum

  object ErgoDexPool {
    implicit val schema: Schema[ErgoDexPool] = Schema.derived[ErgoDexPool]
  }

  implicit val schema: Schema[Datum] = Schema.derived[Datum]

}
