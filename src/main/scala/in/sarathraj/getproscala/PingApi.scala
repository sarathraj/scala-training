package in.sarathraj.getproscala

import cats.effect.IO
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

class PingApi extends Http4sDsl[IO] {
  val routes = HttpRoutes.of[IO] {
    case GET -> Root / "ping" => Ok("pong")
    case GET -> Root / "ping" / name => Ok("pong" + name)

  }
}
