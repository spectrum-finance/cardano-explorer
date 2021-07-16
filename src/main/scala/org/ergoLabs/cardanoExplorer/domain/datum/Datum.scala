package org.ergoLabs.cardanoExplorer.domain.datum

import io.circe.{Decoder, Encoder}
import sttp.tapir.Schema

abstract class Datum

object Datum {

  implicit val encoder: Encoder[Datum] = ???
  implicit val decoder: Decoder[Datum] = ???
  implicit val schema: Schema[Datum]   = ???
}
