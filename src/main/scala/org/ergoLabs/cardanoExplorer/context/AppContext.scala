package org.ergoLabs.cardanoExplorer.context

import org.ergoLabs.cardanoExplorer.config.AppConfig
import tofu.Context
import tofu.optics.macros.{promote, ClassyOptics}

@ClassyOptics
final case class AppContext(@promote config: AppConfig)

object AppContext extends Context.Companion[AppContext]
