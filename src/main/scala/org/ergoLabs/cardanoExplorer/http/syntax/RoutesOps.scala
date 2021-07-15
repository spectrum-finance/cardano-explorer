package org.ergoLabs.cardanoExplorer.http.syntax

import cats.Monad
import cats.syntax.either._
import org.ergoLabs.cardanoExplorer.http.ApiErr
import org.ergoLabs.cardanoExplorer.http.ApiErr.NotFound
import tofu.syntax.monadic._

final class RoutesOps[F[_], A](val fa: F[Option[A]]) extends AnyVal {

  def orNotFound(what: String)(implicit M: Monad[F]): F[Either[ApiErr, A]] =
    fa.flatMap(opt => opt.fold((NotFound(204, what): ApiErr).asLeft[A].pure[F])(el => el.asRight[ApiErr].pure[F]))
}
