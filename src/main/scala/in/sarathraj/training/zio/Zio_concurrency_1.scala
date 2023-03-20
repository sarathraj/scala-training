package in.sarathraj.training.zio
import zio._

object Zio_concurrency_1 extends ZIOAppDefault {

   val effect1 = ZIO.succeed(42)
   val effect2 =ZIO.succeed(72)

   val effect3 = for{
     a <- ZIO.succeed(42).fork
     b <- ZIO.succeed(72).fork
     c  = a.zip(b)
     message <- c.join
   } yield(c.map(i => println(i)))

   effect3.map(m => println(m) )



  override def run: ZIO[Any, Any, Any] = effect3

}
