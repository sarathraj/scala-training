package in.sarathraj.training.zio

import zio.*

import scala.io.StdIn
//ZIO effects
object Basic_zio_1 {

   val  meaningOfLife:ZIO[Any,Nothing,Int] =ZIO.succeed(42)
   val failure:ZIO[Any,String,Nothing] = ZIO.fail("Something went wrong")
   val suspendZIO:ZIO[Any,Throwable,Int] =  ZIO.suspend(meaningOfLife)

    //map + flatmap
    val improvedLife = meaningOfLife.map(_*2)
    val printMOL = meaningOfLife.flatMap( mol => ZIO.succeed(println(mol)))

    //for comprehension
    val smallProgram = for {
      _  <- ZIO.succeed(println("Enter your name "))
      name <- ZIO.succeed(StdIn.readLine())
      _ <- ZIO.succeed(s"Welcome to ZIO ${name}")

    } yield ()

  //A LOT of combinators
   //zip ,zipwith
   val c = ZIO.succeed(11)
   val newMol = meaningOfLife.zip(c)
   val newMol1 = meaningOfLife.zipWith(c)(_ * _)


   //Type aliasing
   // UIO[A] =ZIO[Any,Nothing,A]   -- no requirement , cannot fail , produces A
     val a:UIO[Int]  = ZIO.succeed(1)

  //URIO[R,A] =ZIO[R,Nothing,A] - -- have requirement , cannot fail , produces A
    val aap:URIO[Int,Int] = ZIO.succeed(1)

  //RIO[R,A] =ZIO[R,Throwable,A] - -- have requirement , can fail and throwable , produces A
  val aap1:RIO[Int,Int] = ZIO.succeed(1)

  // Task[A] = ZIO[Any,Throwable,A]   -- no requirement , can fail with a throwable, produces A
   val aa:Task[Int]  = ZIO.succeed(1)
  val ab:Task[Int]  = ZIO.fail(RuntimeException("Something went wrong"))

  //IO[E] = ZIO[Any,E,A]  -- no requirement
  val i:IO[String,Int] = ZIO.succeed(34)
  val ip:IO[String,Int] = ZIO.fail("error")


  def main(args: Array[String]): Unit = {
    for {
      _  <- ZIO.succeed(println("Enter your name ..  "))
      name <- ZIO.succeed(StdIn.readLine())
      _ <- ZIO.succeed(s"Welcome to ZIO .. ${name}")

    } yield ()

  }
  

}
