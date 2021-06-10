package ergo.labs.dex

import io.circe.syntax._
import monix.eval.Task
import org.http4s.HttpRoutes
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl
import org.http4s.server.middleware.Logger

class HttpServer extends Http4sDsl[Task] {

  val routes: HttpRoutes[Task] = Logger.httpRoutes(
    logHeaders = true,
    logBody = true,
    logAction = Some((str: String) => Task.pure(print(str)))
  )(
    HttpRoutes.of[Task] {
      case _@GET -> Root / "api" / "v0" / "tx" / "outs" / "unspent" =>
        Ok(
            TxOut(
              Address(None, contents = Contents("21fe31dfa154a261626bf854046fd2271b7bed4b6abe45aa58877ef47f9721b9")),
              Value(List(
                CurrencySymbol("") -> List(TokenName("") -> 10)
              )),
              Some("2dd5de9ebceca1088e0bb133caf2f2ae853efe3a09bb3a3f8826bff84838979f")
            ).asJson
        )
    }
  )
}

