package org.ergoLabs.cardanoExplorer

import io.circe.generic.JsonCodec

@JsonCodec
final case class TxOut(txOutAddress: Address, txOutValue: Value, txOutDatumHash: Option[String])

@JsonCodec
final case class Address(addressStakingCredential: Option[String], addressCredential: AddressCredential)

@JsonCodec
final case class AddressCredential(contents: Contents, tag: String = "PubKeyCredential")

@JsonCodec
final case class Contents(getPubKeyHash: String)

@JsonCodec
final case class Value(getValue: List[(CurrencySymbol, List[(TokenName, Long)])])

@JsonCodec
final case class CurrencySymbol(unCurrencySymbol: String)

@JsonCodec
final case class TokenName(unTokenName: String)
