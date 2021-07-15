import sbt.{compilerPlugin, _}

object dependencies {

  val Cats = List(
    "org.typelevel"    %% "cats-core"           % versions.Cats,
    "org.typelevel"    %% "cats-effect"         % versions.CatsEffect,
    "org.typelevel"    %% "cats-mtl-core"       % versions.CatsMtl,
    "com.github.cb372" %% "cats-retry"          % versions.CatsRetryVersion
  )

  val Tofu = List(
    "tf.tofu" %% "tofu-core"           % versions.Tofu,
    "tf.tofu" %% "tofu-concurrent"     % versions.Tofu,
    "tf.tofu" %% "tofu-env"            % versions.Tofu,
    "tf.tofu" %% "tofu-optics-core"    % versions.Tofu,
    "tf.tofu" %% "tofu-optics-macro"   % versions.Tofu,
    "tf.tofu" %% "tofu-derivation"     % versions.Tofu,
    "tf.tofu" %% "tofu-logging"        % versions.Tofu,
    "tf.tofu" %% "tofu-logging-layout" % versions.Tofu,
    "tf.tofu" %% "tofu-doobie"         % versions.Tofu
  )

  val Monix = List("io.monix" %% "monix" % versions.Monix)

  val Newtype = List(
    "io.estatico" %% "newtype" % versions.Newtype
  )

  val Logging = List(
    "ch.qos.logback" % "logback-classic" % versions.Logback,
    "org.slf4j"      % "slf4j-api"       % versions.Slf4j
  )

  val Enumeratum = List(
    "com.beachape" %% "enumeratum"       % versions.Enumeratum,
    "com.beachape" %% "enumeratum-circe" % versions.EnumeratumCirce
  )

  val Config = List(
    "com.github.scopt"      %% "scopt"                  % versions.Scopt,
    "com.github.pureconfig" %% "pureconfig"             % versions.PureConfig,
    "com.github.pureconfig" %% "pureconfig-yaml"        % versions.PureConfig,
    "com.github.pureconfig" %% "pureconfig-cats-effect" % versions.PureConfig
  )

  val Derevo = List(
    "tf.tofu" %% "derevo-circe-magnolia" % versions.Derevo,
    "tf.tofu" %% "derevo-pureconfig"     % versions.Derevo,
    "tf.tofu" %% "derevo-cats-tagless"   % versions.Derevo,
    "tf.tofu" %% "derevo-cats"           % versions.Derevo
  )

  val Circe = List(
    "io.circe" %% "circe-core"       % versions.Circe,
    "io.circe" %% "circe-generic"    % versions.Circe,
    "io.circe" %% "circe-parser"     % versions.Circe,
    "io.circe" %% "circe-refined"    % versions.Circe,
    "io.circe" %% "circe-derivation" % versions.CirceDerivation,
    "io.circe" %% "circe-yaml"       % versions.CirceYaml
  )

  val Tapir = List(
    "com.softwaremill.sttp.tapir" %% "tapir-core"          % versions.Tapir,
    "com.softwaremill.sttp.tapir" %% "tapir-json-circe"    % versions.Tapir,
    "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % versions.Tapir
  )

  val Http4s = List(
    "org.http4s" %% "http4s-dsl"          % versions.http4s,
    "org.http4s" %% "http4s-blaze-server" % versions.http4s,
    "org.http4s" %% "http4s-circe"        % versions.http4s
  )

  val Sttp = List(
    "com.softwaremill.sttp.client3" %% "core"                           % versions.Sttp,
    "com.softwaremill.sttp.client3" %% "async-http-client-backend-cats" % versions.Sttp,
    "com.softwaremill.sttp.client3" %% "circe"                          % versions.Sttp
  )

  val Doobie = List(
    "org.tpolecat" %% "doobie-core"      % versions.Doobie,
    "org.tpolecat" %% "doobie-postgres"  % versions.Doobie,
    "org.tpolecat" %% "doobie-scalatest" % versions.Doobie,
    "org.tpolecat" %% "doobie-hikari"    % versions.Doobie,
    "org.tpolecat" %% "doobie-refined"   % versions.Doobie
  )

  val Google = List(
    "com.googlecode.libphonenumber" % "libphonenumber" % versions.LibPhoneNumber
  )

  val Monocle = List(
    "dev.optics" %% "monocle-core"  % versions.Monocle,
    "dev.optics" %% "monocle-macro" % versions.Monocle
  )

  val Test = List(
    "org.specs2"                 %% "specs2-core"               % versions.Specs2,
    "com.github.alexarchambault" %% "scalacheck-shapeless_1.14" % versions.ScalacheckShapeless
  )

  lazy val CompilerPlugins: List[ModuleID] =
    List(
      compilerPlugin(
        "org.typelevel"           %% "kind-projector"     % versions.KindProjector cross CrossVersion.full
      ),
      compilerPlugin("com.olegpy" %% "better-monadic-for" % versions.BetterMonadic4)
    )

  lazy val core =
    Cats ++
      Tofu ++
      Monix ++
      Newtype ++
      Config ++
      Logging ++
      Derevo ++
      Doobie ++
      Monocle ++
      CompilerPlugins ++
      Circe ++
      Tapir ++
      Http4s ++
      Sttp ++
      Google ++
      Enumeratum ++
      Test
}