package org.ergoLabs.cardanoExplorer.config

import cats.syntax.option._
import scopt.OParser

final case class Args(
  configFilePathOpt: Option[String]
)

object Args {

  def read(args: List[String]): Args =
    OParser.parse(parser, args, empty).getOrElse(empty)

  def empty: Args = Args(none)

  private val builder = OParser.builder[Args]

  private val parser = {
    import builder._
    OParser.sequence(
      programName("cardanoExplorer"),
      head("valService", "1.x"),
      opt[String]('c', "config-path")
        .action((x, c) => c.copy(configFilePathOpt = x.some))
        .text("config-path is a string")
    )
  }
}
