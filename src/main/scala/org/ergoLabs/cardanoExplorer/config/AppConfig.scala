package org.ergoLabs.cardanoExplorer.config

import cats.effect.{Blocker, ContextShift, Sync}
import derevo.derive
import derevo.pureconfig.pureconfigReader
import pureconfig.ConfigSource
import pureconfig.module.catseffect.syntax.CatsEffectConfigSource
import tofu.Context
import tofu.optics.macros.{promote, ClassyOptics}
import tofu.syntax.monadic._

@ClassyOptics
@derive(pureconfigReader)
final case class AppConfig(@promote httpConfig: HttpConfig)

object AppConfig extends Context.Companion[AppConfig] {

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
