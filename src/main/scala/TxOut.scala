package ergo.labs.dex

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

object A {
//"[{"txOutAddress":{"addressStakingCredential":null,"addressCredential":{"contents":{"getPubKeyHash":"21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9"},"tag":"ScriptCredential"}},"txOutValue":{"getValue":[[{"unCurrencySymbol":""},[[{"unTokenName":""},10]]]]},"txOutDatumHash":"2dd5de9ebceca1088e0bb133caf2f2ae853efe3a09bb3a3f8826bff84838979f"}]"
//"{\"txOutValue\":{\"getValue\":[[{\"unCurrencySymbol\":\"\"},[[{\"unTokenName\":\"\"},10]]]]},\"txOutAddress\":{\"addressStakingCredential\":null,\"addressCredential\":{\"contents\":{\"getPubKeyHash\":\"21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9\"},\"tag\":\"PubKeyCredential\"}},\"txOutDatumHash\":\"2dd5de9ebceca1088e0bb133caf2f2ae853efe3a09bb3a3f8826bff84838979f\"}"
  """
    |{
    |    "txOutValue":{
    |        "getValue":[
    |            [
    |                {"unCurrencySymbol":""},
    |                [
    |                    [
    |                        {"unTokenName":""},
    |                        10
    |                    ]
    |                ]
    |            ]
    |        ]
    |    },
    |    "txOutAddress":{
    |        "addressStakingCredential":null,
    |        "addressCredential":{
    |            "contents":{
    |                "getPubKeyHash":"21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9"
    |            },
    |            "tag":"PubKeyCredential"
    |        }
    |    },
    |    "txOutDatumHash":"2dd5de9ebceca1088e0bb133caf2f2ae853efe3a09bb3a3f8826bff84838979f"
    |}
    |""".stripMargin
}