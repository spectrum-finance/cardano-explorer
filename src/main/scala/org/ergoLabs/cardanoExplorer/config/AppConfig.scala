package org.ergoLabs.cardanoExplorer.config

import derevo.derive
import derevo.pureconfig.pureconfigReader
import tofu.optics.macros.{ClassyOptics, promote}

@derive(pureconfigReader)
@ClassyOptics
final case class AppConfig(@promote httpConfig: HttpConfig)
