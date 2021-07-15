package org.ergoLabs.cardanoExplorer.http.syntax

import cats.Monad
import cats.syntax.either._
import org.ergoLabs.cardanoExplorer.http.ApiErr
import org.ergoLabs.cardanoExplorer.http.ApiErr.UnknownErr
import tofu.Handle
import tofu.syntax.handle._
import tofu.syntax.monadic._

final class HandleOps[
  F[_]: Handle[*[_], Throwable]: Monad,
  A
](fa: F[A]) {

  def eject: F[Either[ApiErr, A]] =
    fa.map(Either.right[ApiErr, A])
      .handleWith[ApiErr] { e: ApiErr =>
        Either
          .left[ApiErr, A](UnknownErr(404, "Unknown error"))
          .pure[F]
      }
}
