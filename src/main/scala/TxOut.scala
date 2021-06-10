package ergo.labs.dex

import io.circe.generic.JsonCodec

@JsonCodec
final case class TxOut(txOutAddress: Address, txOutValue: Value, txOutDatumHash: Option[String])

@JsonCodec
final case class Address(addressStakingCredential: Option[String], tag: String = "ScriptAddress", contents: Contents)

@JsonCodec
final case class Contents(getPubKeyHash: String)

@JsonCodec
final case class Value(getValue: List[(CurrencySymbol, List[(TokenName, Long)])])

@JsonCodec
final case class CurrencySymbol(unCurrencySymbol: String)

@JsonCodec
final case class TokenName(unTokenName: String)