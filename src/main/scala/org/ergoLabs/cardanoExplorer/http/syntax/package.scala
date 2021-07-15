package org.ergoLabs.cardanoExplorer.http

import cats.Monad
import tofu.Handle

package object syntax {

  object handle {

    implicit def toHandleOps[
      F[_]: Handle[*[_], Throwable]: Monad,
      A
    ](fa: F[A]): HandleOps[F, A] =
      new HandleOps(fa)
  }

  object routes {

    implicit def toRoutesOps[F[_], A](fa: F[Option[A]]): RoutesOps[F, A] =
      new RoutesOps(fa)
  }
}
