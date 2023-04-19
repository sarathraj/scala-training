package in.sarathraj.project.timeapi

import cats.effect.IO
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

import java.time.format.DateTimeFormatter

//  you should reply with a 200 - Ok status code and a body con- training the current date and time in format RFC 1123
//  Otherwise, you should return a response with the status code 404 – Not Found and a body containing a human-readable error message.
class TimePrinterRoutes extends Http4sDsl[IO]{

  private val printer =
    new TimePrinter(DateTimeFormatter.RFC_1123_DATE_TIME)

  val service = HttpRoutes.of[IO]{
    case GET -> Root / "datetime" / country => try {
        Ok(printer.now(country))
    } catch {
      case ex:IllegalStateException => NotFound(ex.getMessage)
    }
    case GET -> Root / "ping" => Ok("pong.")
    case GET -> Root / "ping" / name => Ok("pong" + name)
  }

}
