package in.sarathraj.getproscala

import java.time.{LocalDate, Period}
import io.circe._

case class PersonJ(fullName: String, dateOfBirth: LocalDate)
class Unit8_Json {





  def asJson[A](a:A)(using encoder:Encoder[A]) : Json = encoder.apply(a)
}

object Unit8 extends App {
  given personEncoder:Encoder[PersonJ] with {
    def apply(person: PersonJ):Json =   {
      val age = Period.between(person.dateOfBirth, LocalDate.now()).getYears
      Json.obj(
        "fullName" -> Json.fromString(person.fullName),
        "age" -> Json.fromInt(age)
      )
    }
  }
  val person = PersonJ("sarath",LocalDate.of(1986,5,25))
  println(new Unit8_Json().asJson(person))

}
