package in.sarathraj.getprogrammingscala

import scala.io.Source.fromFile
import java.sql.{Date as  SqlDate}

object UnitTwo extends  App{
   import scala.io.Source
  def readFile(fileName:String) = Source.fromFile(fileName).getLines().mkString("\n")
  def readFile1(fileName:String) = fromFile(fileName).getLines().mkString("\n")

  
}
