import sbt.{CrossVersion, compilerPlugin, _}

object dependencies {

  import versions._

  val Monix =
    List(
      "io.monix" %% "monix" % MonixVersion
    )

  val SttpCore =
    List(
      "com.softwaremill.sttp.client3" %% "core"  % SttpVersion,
      "com.softwaremill.sttp.client3" %% "circe" % SttpVersion
    )

  val Tapir = List(
    "com.softwaremill.sttp.tapir" %% "tapir-core"       % TapirVersion,
    "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % TapirVersion
  )

  val TapirHttp4s = List(
    "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % TapirVersion
  )

  val Circe: List[ModuleID] =
    List(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser",
      "io.circe" %% "circe-refined"
    ).map(_ % CirceVersion)

  val Cats: List[ModuleID] = List(
    "org.typelevel" %% "cats-core"           % CatsVersion,
    "org.typelevel" %% "cats-effect"         % CatsEffectVersion,
    "org.typelevel" %% "cats-tagless-macros" % CatsTaglessVersion,
    "org.typelevel" %% "cats-tagless-core"   % CatsTaglessVersion,
    "org.typelevel" %% "mouse"               % MouseVersion
  )

  val Fs2: List[ModuleID] = List("co.fs2" %% "fs2-core" % Fs2Version)

  val Tofu: List[ModuleID] = List(
    "tf.tofu" %% "tofu-core"         % TofuVersion,
    "tf.tofu" %% "tofu-concurrent"   % TofuVersion,
    "tf.tofu" %% "tofu-optics-core"  % TofuVersion,
    "tf.tofu" %% "tofu-optics-macro" % TofuVersion,
    "tf.tofu" %% "tofu-derivation"   % TofuVersion,
    "tf.tofu" %% "tofu-logging"      % TofuVersion,
    "tf.tofu" %% "tofu-doobie"       % TofuVersion,
    "tf.tofu" %% "tofu-streams"      % TofuVersion,
    "tf.tofu" %% "tofu-fs2-interop"  % TofuVersion,
    "tf.tofu" %% "tofu-zio-interop"  % TofuVersion
  )

  val Derevo: List[ModuleID] = List(
    "tf.tofu" %% "derevo-cats"              % DerevoVersion,
    "tf.tofu" %% "derevo-cats-tagless"      % DerevoVersion,
    "tf.tofu" %% "derevo-circe"             % DerevoVersion,
    "tf.tofu" %% "derevo-pureconfig-legacy" % DerevoVersion
  )

  val Db: List[ModuleID] = List(
    "org.tpolecat" %% "doobie-core"      % DoobieVersion,
    "org.tpolecat" %% "doobie-postgres"  % DoobieVersion,
    "org.tpolecat" %% "doobie-scalatest" % DoobieVersion,
    "org.tpolecat" %% "doobie-hikari"    % DoobieVersion,
    "org.tpolecat" %% "doobie-refined"   % DoobieVersion,
    "org.flywaydb"  % "flyway-core"      % FlywayVersion
  )

  val Typing: List[ModuleID] = List(
    "io.estatico" %% "newtype"      % NewtypeVersion,
    "eu.timepit"  %% "refined"      % RefinedVersion,
    "eu.timepit"  %% "refined-cats" % RefinedVersion
  )

  val Enums: List[ModuleID] = List(
    "com.beachape" %% "enumeratum"       % EnumeratumVersion,
    "com.beachape" %% "enumeratum-circe" % EnumeratumCirceVersion
  )

  val Config: List[ModuleID] = List(
    "com.github.pureconfig" %% "pureconfig"             % PureConfigVersion,
    "com.github.pureconfig" %% "pureconfig-cats-effect" % PureConfigVersion
  )

  val Simulacrum: List[ModuleID] = List(
    "com.github.mpilquist" %% "simulacrum" % SimulacrumVersion
  )

  val CompilerPlugins: List[ModuleID] =
    List(
      compilerPlugin(
        "org.typelevel" %% "kind-projector" % KindProjectorVersion cross CrossVersion.full
      ),
      compilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
    )
}
