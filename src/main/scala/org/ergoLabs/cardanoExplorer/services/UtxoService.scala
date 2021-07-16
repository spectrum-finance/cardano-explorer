package org.ergoLabs.cardanoExplorer.services

import cats.Applicative
import cats.syntax.option._
import org.ergoLabs.cardanoExplorer.domain.Credential.PubKeyCredential
import org.ergoLabs.cardanoExplorer.domain.datum.ErgoDexPool
import org.ergoLabs.cardanoExplorer.domain.plutus.AssetClass
import org.ergoLabs.cardanoExplorer.domain.{
  Address,
  CurrencySymbol,
  FullTxOut,
  Id,
  RefIdx,
  TokenName,
  TxId,
  TxOut,
  Value
}
import tofu.syntax.monadic._

trait UtxoService[F[_]] {

  def getFullTxOutById(id: Id): F[Option[FullTxOut]]

  def getTxOutById(id: Id): F[Option[TxOut]]
}

object UtxoService {

  //todo: add logging
  def make[I[+_]: Applicative, F[_]: Applicative]: I[UtxoService[F]] = new Live[F].pure[I]

  final private class Live[F[_]: Applicative] extends UtxoService[F] {

    override def getFullTxOutById(id: Id): F[Option[FullTxOut]] =
      FullTxOut(
        TxId("txId"),
        RefIdx(1),
        Address(
          PubKeyCredential("abc"),
          none
        ),
        Value(List.empty),
        ErgoDexPool(
          10,
          AssetClass(CurrencySymbol("xToken")  -> TokenName("xTokenName")),
          AssetClass(CurrencySymbol("yToken")  -> TokenName("yTokenName")),
          AssetClass(CurrencySymbol("lpToken") -> TokenName("lpTokenName"))
        )
      ).some.pure[F]

    override def getTxOutById(id: Id): F[Option[TxOut]] =
      none[TxOut].pure[F]
  }
}
