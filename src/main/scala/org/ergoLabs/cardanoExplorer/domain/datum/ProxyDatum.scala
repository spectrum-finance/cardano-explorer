package org.ergoLabs.cardanoExplorer.domain.datum

import enumeratum.values.{StringEnum, StringEnumEntry}
import org.ergoLabs.cardanoExplorer.domain.{PoolId, PubKeyHash}
import org.ergoLabs.cardanoExplorer.domain.datum.ProxyDatum.ProxyAction
import org.ergoLabs.cardanoExplorer.domain.plutus.AssetClass

final case class ProxyDatum(
  action: ProxyAction,
  slippageTolerance: Int,
  rate: Int,
  dexFeeDatum: Int,
  userPubKeyHash: PubKeyHash,
  xProxyToken: AssetClass,
  yProxyToken: AssetClass,
  targetPoolId: PoolId,
  lpProxyToken: AssetClass
) extends Datum

object ProxyDatum {

  sealed abstract class ProxyAction(val value: String) extends StringEnumEntry

  object ProxyAction extends StringEnum[ProxyAction] {

    case object Swap extends ProxyAction("Swap")
    case object Deposit extends ProxyAction("Deposit")
    case object Redeem extends ProxyAction("Redeem")

    val values = findValues
  }
}
