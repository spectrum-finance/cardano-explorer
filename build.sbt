import dependencies._

lazy val commonSettings = Seq(
  scalacOptions ++= commonScalacOptions,
  scalaVersion := "2.13.5",
  organization := "org.ergolabs",
  version := "0.4.0",
  resolvers += Resolver.sonatypeRepo("public"),
  resolvers += Resolver.sonatypeRepo("snapshots"),
//  test in assembly := {},
//  assemblyMergeStrategy in assembly := {
//    case "logback.xml"                                => MergeStrategy.first
//    case "module-info.class"                          => MergeStrategy.discard
//    case "META-INF/intellij-compat.json"              => MergeStrategy.last
//    case other if other.contains("io.netty.versions") => MergeStrategy.first
//    case other if other.contains("scala")             => MergeStrategy.first
//    case other if other.contains("derevo")            => MergeStrategy.last
//    case other                                        => (assemblyMergeStrategy in assembly).value(other)
//  },
  libraryDependencies ++= dependencies.CompilerPlugins
)

lazy val commonScalacOptions = List(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-language:higherKinds",
  "-language:postfixOps",
  "-language:implicitConversions",
  "-feature",
  "-unchecked",
  "-Xfuture",
  "-Ymacro-annotations",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Ypartial-unification"
)

lazy val cardanoExplorer = project
  .in(file("."))
  .withId("cardano-explorer")
  .settings(commonSettings)
  .settings(
    moduleName := "cardano-explorer",
    name := "CardanoExplorer",
    libraryDependencies ++=
      Monix ++
        SttpCore ++
        Tapir ++
        TapirHttp4s ++
        Circe ++
        Cats ++
        Fs2 ++
        Tofu ++
        Derevo ++
        Db ++
        Typing ++
        Enums ++
        Config ++
        Simulacrum ++
        CompilerPlugins
  )
