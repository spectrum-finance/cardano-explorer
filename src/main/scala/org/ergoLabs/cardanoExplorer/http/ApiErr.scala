package org.ergoLabs.cardanoExplorer.http

import derevo.circe.magnolia.{customizableDecoder, customizableEncoder}
import derevo.derive
import sttp.tapir.{Schema, Validator}

import scala.util.control.NoStackTrace

abstract class ApiErr extends Exception with NoStackTrace {
  val status: Int
  val reason: String
}

object ApiErr {

  @derive(customizableEncoder, customizableDecoder)
  final case class NotFound(status: Int, reason: String) extends ApiErr

  @derive(customizableEncoder, customizableDecoder)
  final case class BadRequest(status: Int, reason: String) extends ApiErr

  @derive(customizableEncoder, customizableDecoder)
  final case class UnknownErr(status: Int, reason: String) extends ApiErr

  def notFound(what: String): NotFound = NotFound(404, s"Not found $what")

  def badRequest(details: String): BadRequest = BadRequest(400, s"Bad request: $details")

  def unknownErr(message: String): UnknownErr = UnknownErr(500, s"Unknown error: $message")

  implicit val unknownErrorS: Schema[UnknownErr] = Schema.derived[UnknownErr]
  implicit val notFoundS: Schema[NotFound] = Schema.derived[NotFound]
  implicit val badInputS: Schema[BadRequest] = Schema.derived[BadRequest]

  implicit val unknownErrorV: Validator[UnknownErr] = unknownErrorS.validator
  implicit val notFoundV: Validator[NotFound] = notFoundS.validator
  implicit val badInputV: Validator[BadRequest] = badInputS.validator

  implicit val schema: Schema[ApiErr] =
    Schema.oneOfUsingField[ApiErr, String](_.getMessage, _.toString)(
      "unknownError" -> unknownErrorS,
      "notFound" -> notFoundS,
      "badInput" -> badInputS
    )
}
