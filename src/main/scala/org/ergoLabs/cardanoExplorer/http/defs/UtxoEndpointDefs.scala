package org.ergoLabs.cardanoExplorer.http.defs

import org.ergoLabs.cardanoExplorer.domain.{FullTxOut, Id}
import org.ergoLabs.cardanoExplorer.http.ApiErr
import sttp.tapir._
import org.ergoLabs.cardanoExplorer.http.defs._
import sttp.tapir.json.circe.jsonBody

object UtxoEndpointDefs {

  private val prefix = "utxo"

  def getUtxoById: Endpoint[Id, ApiErr, FullTxOut, Any] =
    baseEndpointDef
      .in(prefix / path[Id] )
      .out(jsonBody[FullTxOut])

}
