package org.ergoLabs.cardanoExplorer.context

import org.ergoLabs.cardanoExplorer.config.AppConfig
import tofu.optics.macros.{ClassyOptics, promote}

@ClassyOptics
final case class AppContext(@promote config: AppConfig)
