package org.ergoLabs.cardanoExplorer.config

import derevo.derive
import derevo.pureconfig.pureconfigReader

@derive(pureconfigReader)
final case class HttpConfig(host: String, port: Int)
