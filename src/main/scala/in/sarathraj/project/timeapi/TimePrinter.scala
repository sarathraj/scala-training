package in.sarathraj.project.timeapi

import java.time.{ZoneId, ZonedDateTime}
import java.time.format.DateTimeFormatter

class TimePrinter(formatter:DateTimeFormatter) {

  def now(country:String): String ={
      val timeZone = countryToTimeZone(country)
      val dateTime  = currentDateTime(timeZone)
      dateTimeToString(dateTime)
  }

  def countryToTimeZone(country:String): String = country.toLowerCase() match {
    case "italy" => "Europe/Rome"
    case "uk" => "Europe/London"
    case "germany" => "Europe/Berlin"
    case "japan" => "Asia/Tokyo"
    case _ =>
      val msg = s"Unknown timezone for country $country"
      throw new IllegalArgumentException(msg)
  }

  def currentDateTime(timeZone:String):ZonedDateTime = {
    val zoneId =   ZoneId.of(timeZone)
    ZonedDateTime.now(zoneId)
  }

  def dateTimeToString(dateTime:ZonedDateTime):String = {
    formatter.format(dateTime)
  }

}
