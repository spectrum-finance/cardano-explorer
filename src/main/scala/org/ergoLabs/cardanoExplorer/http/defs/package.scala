package org.ergoLabs.cardanoExplorer.http

import sttp.tapir._

package object defs {

  private val V0Prefix: EndpointInput[Unit] = "api" / "v0"

  val baseEndpointDef: Endpoint[Unit, ApiErr, Unit, Any] =
    definitions.baseEndpointDef(V0Prefix)
}
