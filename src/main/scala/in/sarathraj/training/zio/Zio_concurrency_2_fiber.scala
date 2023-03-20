package in.sarathraj.training.zio

import zio.{ZIO, *}

object Zio_concurrency_2_fiber extends ZIOAppDefault {

  //Exercise 1
  // zip two fibers without using zip combinators
  // create a fiber that wait for both
  def zipFibers[E,A,B](fiber1:Fiber[E,A],fiber2: Fiber[E,B]):ZIO[Any,Nothing,Fiber[E,(A,B)]] =
   val result =  for{
      a <- fiber1.join
      b <- fiber2.join
    }yield (a,b)
    result.fork

  val effect3 = for{
    a <- ZIO.succeed("Result from fiber 1 ").debug.fork
    b <- ZIO.succeed("Result from fiber 2 ").debug.fork
    c  <- zipFibers(a,b)
    tuple <- c.join
  } yield(tuple)

  def zipFibersTwoError[E,E1 <: E,E2 <:E,A,B](fiber1:Fiber[E1,A],fiber2: Fiber[E2,B]):ZIO[Any,Nothing,Fiber[E,(A,B)]] =
    //same impl
    val result =  for{
      a <- fiber1.join
      b <- fiber2.join
    }yield (a,b)
    result.fork





  //Exercise 2
  // same thing with or Else
  def zipFibersOrElse[E,A](fiber1:Fiber[E,A],fiber2: Fiber[E,A]):ZIO[Any,Nothing,Fiber[E,A]] =
    fiber1.join.orElse(fiber2.join).fork


  val result11 =   ZIO.succeed("first Action") *> ZIO.sleep(10.seconds) *> ZIO.succeed("second Action")


  override def run: ZIO[Any, Any, Any] = effect3
}
