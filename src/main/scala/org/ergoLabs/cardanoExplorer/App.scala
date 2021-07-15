package org.ergoLabs.cardanoExplorer

import cats.effect.ExitCode
import monix.eval.{Task, TaskApp}

object App extends TaskApp {
  override def run(args: List[String]): Task[ExitCode] = ???
}
