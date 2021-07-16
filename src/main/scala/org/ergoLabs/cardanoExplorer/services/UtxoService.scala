package org.ergoLabs.cardanoExplorer.services

import cats.Applicative
import org.ergoLabs.cardanoExplorer.domain.{Address, Credential, Datum, FullTxOut, Id, ProxyDatum, RefIdx, TxId, TxOut, Value}
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
  def make[I[+_] : Applicative, F[_] : Applicative]: I[UtxoService[F]] = new Live[F].pure[I]

  final private class Live[F[_] : Applicative] extends UtxoService[F] {

    import io.circe.syntax._

    val test = ProxyDatum(
      "Deposit",
      1,1,1,
      "21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9",
      "21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9",
      "21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9",
      "21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9",
      "21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9"
    )

    def getFullTxOuts: F[List[FullTxOut]] =
      List(
        FullTxOut(
          TxId("21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9"),
          RefIdx(1),
          Address(None, addressCredential = AddressCredential(Contents("21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9"))),
          Value(List.empty),
          Datum1("d87989d879800a0a0a40d879824040d87982404040d879824040")
        )
      ).pure

    override def getFullTxOutById(id: Id): F[Option[FullTxOut]] =
      FullTxOut(
        TxId("txId"),
        RefIdx(1),
        Address(None, addressCredential = AddressCredential(Contents("21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9"))),
        Value(List.empty),
        Datum1("21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9")
      ).some.pure[F]

    override def getTxOutById(id: Id): F[Option[TxOut]] =
      none[TxOut].pure[F]
  }
}
