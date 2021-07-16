package org.ergoLabs.cardanoExplorer

import io.circe.{Decoder, Encoder}
import io.circe.generic.JsonCodec
import io.circe.magnolia.configured.Configuration
import io.estatico.newtype.macros.newtype
import org.ergoLabs.cardanoExplorer.domain.{CurrencySymbol, Id, RefIdx, TxId}
import cats.syntax.option._
import org.ergoLabs.cardanoExplorer.domain.Datum.ErgoDexPool
import sttp.tapir.Codec.PlainCodec
import sttp.tapir.CodecFormat.TextPlain
import sttp.tapir.{Codec, Schema}

package object domain {





  implicit val config: Configuration = Configuration.default

  @newtype case class Id(value: String)

  object Id {
    implicit val encoder: Encoder[Id]  = deriving
    implicit val decoder: Decoder[Id]  = deriving
    implicit val schema: Schema[Id]    = Schema.schemaForString.map(Id(_).some)(_.value)
    implicit val codec: PlainCodec[Id] = Codec.string.map(Id(_))(_.value)
  }


  @JsonCodec
  case class TxId(getTxId: String)

  object TxId {
    implicit val schema: Schema[TxId]   = Schema.schemaForString.map(TxId(_).some)(_.getTxId)
  }

  @newtype case class RefIdx(value: Int)

  object RefIdx {
    implicit val encoder: Encoder[RefIdx] = deriving
    implicit val decoder: Decoder[RefIdx] = deriving
    implicit val schema: Schema[RefIdx]   = Schema.schemaForInt.map(RefIdx(_).some)(_.value)
  }

  @newtype case class CurrencySymbol(unCurrencySymbol: String)

  object CurrencySymbol {
    implicit val encoder: Encoder[CurrencySymbol] = deriving
    implicit val decoder: Decoder[CurrencySymbol] = deriving
    implicit val schema: Schema[CurrencySymbol]   = Schema.schemaForString.map(CurrencySymbol(_).some)(_.unCurrencySymbol)
  }

  @newtype case class TokenName(unTokenName: String)

  object TokenName {
    implicit val encoder: Encoder[TokenName] = deriving
    implicit val decoder: Decoder[TokenName] = deriving
    implicit val schema: Schema[TokenName]   = Schema.schemaForString.map(TokenName(_).some)(_.unTokenName)
  }
}
