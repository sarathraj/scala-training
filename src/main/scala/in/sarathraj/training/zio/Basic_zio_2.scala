package in.sarathraj.training.zio


// ZIO application creation

import zio._
object Basic_zio_2 extends ZIOAppDefault {  //ZIOAppDefault provide runtime and tracde

  override def run: ZIO[Any, Any, Any] = Basic_zio_1.meaningOfLife.flatMap(item => ZIO.succeed(println(item)))

}

//object Basic_zio_21 extends ZIOApp {  //99.99 not needed }
