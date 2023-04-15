package in.sarathraj.getproscala

// imporvement
// ERROR HANDLING If a user enters an invalid time zone, your application crashes with a nasty and difficult-to-understand exception
//TIME ZONE REPRESENTATION Your application is entirely dependent on the java.time package and its definition of time zone. For example, it considers UTC a valid time zone, while utc is invalid. The time zone Asia/Tokyo is also not equiv- alent to ASIA/TOKYO. Being dependent on the java.time package has two sig- nificant implications:
// A change in the java.time package drastically affects your application, and it can potentially break it without you realizing it.
// In the future, if you wish to migrate to a different time library, it will be excru- ciating and painful because your definition of valid time zone lives inside the package java.time.
//In future units, you’ll see how to overcome them thanks to data structures such as Map; they will allow you to have a clear separation between how you represent your data and how you manipulate it.



import java.time.format.DateTimeFormatter
import java.time.{ZoneId, ZonedDateTime}
class TimePrinter(formatter: DateTimeFormatter)  {
  def now(timezone: String): String = {
    val dateTime = currentDateTime(timezone)
    dateTimeToString(dateTime)
  }
  private def currentDateTime(timezone: String): ZonedDateTime = {
    val zoneId = ZoneId.of(timezone)
    ZonedDateTime.now(zoneId)
  }

  private def dateTimeToString(dateTime: ZonedDateTime): String = formatter.format(dateTime)

}

import scala.io.StdIn
object TimeApp extends App{

  val timezone = StdIn.readLine("Give me a timezone:  ")
  val timePrinter = new TimePrinter(DateTimeFormatter.RFC_1123_DATE_TIME) // it creates an instance of TimePrinter
  println(timePrinter.now(timezone)) // It computes and prints the current time in the time zone

}
