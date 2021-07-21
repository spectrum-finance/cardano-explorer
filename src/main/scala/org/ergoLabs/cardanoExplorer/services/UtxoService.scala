package org.ergoLabs.cardanoExplorer.services

import cats.Applicative
import org.ergoLabs.cardanoExplorer.domain.{Address, Credential, CurrencySymbol, Datum, FullTxOut, Gid, Id, ProxyDatum, RefIdx, TokenName, TxId, TxOut, Value}
import tofu.syntax.monadic._
import cats.syntax.option._
import org.ergoLabs.cardanoExplorer.domain.Address.{AddressCredential, Contents}
import org.ergoLabs.cardanoExplorer.domain.Credential.PubKeyCredential
import org.ergoLabs.cardanoExplorer.domain.Datum.{Datum1, ErgoDexPool}

trait UtxoService[F[_]] {

  def getFullTxOuts: F[List[FullTxOut]]

  def getFullTxOutById(id: Id): F[Option[FullTxOut]]

  def getTxOutById(id: Id): F[Option[TxOut]]
}

object UtxoService {

  //todo: add logging
  def make[I[+_]: Applicative, F[_]: Applicative]: I[UtxoService[F]] = new Live[F].pure[I]

  final private class Live[F[_]: Applicative] extends UtxoService[F] {

    import io.circe.syntax._

    val test = ProxyDatum(
      "Deposit",
      1,
      1,
      1,
      "21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9",
      "21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9",
      "21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9",
      "21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9",
      "21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9"
    )

    def getFullTxOuts: F[List[FullTxOut]] =
      List(
        // operation out
        FullTxOut(
          Gid(1),
          TxId("21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9"),
          RefIdx(1),
          Address(
            None,
            addressCredential =
              AddressCredential(Contents("21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9"))
          ),
          Value(List(CurrencySymbol("78436f696e53796d626f6c") -> List(TokenName("xCoinToken") -> 10L))),
          Datum1("d87988d879800a0a40d879824b78436f696e53796d626f6c4a78436f696e546f6b656ed879824b79436f696e53796d626f6c4a79436f696e546f6b656e58203294abd948144967d0faf264ff344ea9553baf610e02ced42eaac2453b56eb9cd879824c6c70436f696e53796d626f6c4b6c70436f696e546f6b656e")
        ),
        // pool out
        FullTxOut(
          Gid(2),
          TxId("21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9"),
          RefIdx(2),
          Address(
            None,
            addressCredential =
              AddressCredential(Contents("21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9"))
          ),
          Value(
            List(
              CurrencySymbol("78436f696e53796d626f6c") -> List(TokenName("xCoinToken") -> 1000L),
              CurrencySymbol("79436f696e53796d626f6c") -> List(TokenName("yCoinToken") -> 1000L),
            )
          ),
          Datum1("d879840ad879824b78436f696e53796d626f6c4a78436f696e546f6b656ed879824b79436f696e53796d626f6c4a79436f696e546f6b656ed879824c6c70436f696e53796d626f6c4b6c70436f696e546f6b656e")
        )
      ).pure

    override def getFullTxOutById(id: Id): F[Option[FullTxOut]] =
      FullTxOut(
        Gid(1),
        TxId("txId"),
        RefIdx(1),
        Address(
          None,
          addressCredential =
            AddressCredential(Contents("21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9"))
        ),
        Value(List.empty),
        Datum1("21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9")
      ).some.pure[F]

    override def getTxOutById(id: Id): F[Option[TxOut]] =
      none[TxOut].pure[F]
  }
}
