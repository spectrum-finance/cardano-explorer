package org.ergoLabs.cardanoExplorer.config

import cats.effect.{Blocker, ContextShift, Sync}
import derevo.derive
import derevo.pureconfig.pureconfigReader
import pureconfig.ConfigSource
import pureconfig.module.catseffect.syntax.CatsEffectConfigSource
import tofu.optics.macros.{promote, ClassyOptics}

@derive(pureconfigReader)
@ClassyOptics
final case class AppConfig(@promote httpConfig: HttpConfig)

object AppConfig {

  def load[F[_]: Sync: ContextShift](
    pathOpt: Option[String],
    blocker: Blocker
  ): F[AppConfig] =
    for {
      rawConf <- pathOpt
                   .fold(ConfigSource.default)(path => ConfigSource.file(path).withFallback(ConfigSource.default))
                   .loadF[F, AppConfig](blocker)
    } yield rawConf
}
