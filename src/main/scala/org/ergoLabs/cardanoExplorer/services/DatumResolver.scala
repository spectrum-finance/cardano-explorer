package org.ergoLabs.cardanoExplorer.services

import org.ergoLabs.cardanoExplorer.domain.Datum

trait DatumResolver[F[_]] {

  def resolve(datumHash: Array[Byte]): F[Option[Datum]]
}
