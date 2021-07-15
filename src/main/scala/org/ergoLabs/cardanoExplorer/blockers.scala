package org.ergoLabs.cardanoExplorer

import cats.effect.{Blocker, Resource, Sync}

import java.util.concurrent.{ExecutorService, Executors}
import scala.concurrent.ExecutionContext

import mouse.any._

object blockers {

  /** Resource yielding a `Blocker` backed by an unbounded thread pool prefixed with a given `name`.
   */
  def namedBlocker[F[_]](namePrefix: String)(implicit F: Sync[F]): Resource[F, Blocker] = {
    def name(id: Long) = s"$namePrefix-$id"
    val alloc = F.delay(
      Executors.newCachedThreadPool(
        r => new Thread(r) <| (t => t.setName(name(t.getId)))
      )
    )
    def release(es: ExecutorService) = F.delay(es.shutdown())
    def liftToBlocker(es: ExecutorService) =
      Blocker.liftExecutionContext(ExecutionContext.fromExecutor(es))
    Resource.make(alloc)(release).map(liftToBlocker)
  }
}
