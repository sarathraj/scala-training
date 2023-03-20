package in.sarathraj.training.zio

import zio.*

import scala.util.Try
// ZIO Error handling
object Basic_zio_3 extends  ZIOAppDefault {


  //if you are unsure weather your code might throw
  val anAttempt:ZIO[Any,Throwable,Int] = ZIO.attempt{
    val z:String = null
    z.length
  }

  //effectfully catch error
  val catchError = anAttempt.catchAll(e => ZIO.succeed(s"Returning a different value because of e "))
  val catchSelectiveError = anAttempt.catchSome{
    case e: RuntimeException => ZIO.succeed(s"Ignoring runtime exception")
    case _  => ZIO.succeed("Ignoring all")
  }

  //chain effect
  val anotherAttempt= anAttempt.orElse(ZIO.succeed(42))

  //fold , handle success and failure
  val att:ZIO[Any,Nothing,String] = anAttempt.fold(ex => s"Something bad happend $ex", value => "Length of the string was $value")
 // effectful fold
 val att1:ZIO[Any,Nothing,String] = anAttempt.foldZIO(

   ex => ZIO.succeed(s"Something bad happend $ex"),
   value => ZIO.succeed(s"Length of the strig was $value"))

  //conversion from option/try/Either  to zio

  val aZioTry = ZIO.fromTry(Try(42/0)) // can fail with Throweable

  //Either
  val anEither:Either[Int,String] = Right("Success")
  val aZioEither = ZIO.fromEither(anEither)

  //ZIo with either as value chanel
  val eitherZIO = anAttempt.either

  //reverse
  val anAttemptVw = eitherZIO.absolve

  //OPtion in ZIO
  val zioOption = ZIO.fromOption(Some(42))
  val zioOption1 = ZIO.fromOption(None)

  //Errors   -> failures present in ZIO , like checked exceptions
  // vs Defects -> failtures are unrecoverable ,unforseen , not present in the ZIO typew signatire





  override def run: ZIO[Any, Any, Any] = ???
}
