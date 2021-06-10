name := "CardanoExplorer"

version := "0.1"

scalaVersion := "2.13.5"

idePackagePrefix := Some("ergo.labs.dex")

scalacOptions ++= List(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-language:higherKinds",
  "-language:postfixOps",
  "-language:implicitConversions",
  "-feature",
  "-unchecked",
  "-Xfuture",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Ymacro-annotations"
)

libraryDependencies ++= Seq(
  "org.typelevel" %% "log4cats-slf4j" % "1.2.0",
  "io.monix" %% "monix" % "3.0.0",
  "org.http4s" %% "http4s-blaze-server" % "0.21.6",
  "org.http4s" %% "http4s-circe" % "0.21.6",
  "org.http4s" %% "http4s-dsl" % "0.21.6",
  "io.circe" %% "circe-generic" % "0.13.0",
  "co.fs2" %% "fs2-core" % "2.3.0",
  compilerPlugin("org.typelevel" %% "kind-projector" % "0.11.3" cross CrossVersion.patch),
  compilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
)
