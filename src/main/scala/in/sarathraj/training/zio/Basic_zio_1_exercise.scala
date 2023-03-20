package in.sarathraj.training.zio
import zio.*
object Basic_zio_1_exercise extends App{


  val  meaningOfLife:ZIO[Any,Nothing,Int] =ZIO.succeed(42)
  val runtime = Runtime.default
  implicit  val trace :Trace = Trace.empty
  Unsafe.unsafe{ implicit  u =>
    val mol = runtime.unsafe.run(meaningOfLife)
    println(mol)
  }

  //1. sequence 2 ZIOs and take the last one
  def sequenceTaskLast[R,E,A,B](z1:ZIO[R,E,A],z2:ZIO[R,E,B]):ZIO[R,E,B] =  {
        for {
         a <- z1
         b <- z2
    } yield (b)
  }

  def sequenceTaskLast1[R,E,A,B](z1:ZIO[R,E,A],z2:ZIO[R,E,B]):ZIO[R,E,B] =  {
     z1.flatMap(a=> z2.map(b=>b))
  }

  def sequenceTaskLast2[R,E,A,B](z1:ZIO[R,E,A],z2:ZIO[R,E,B]):ZIO[R,E,B] =  {
   z1 *> z2
  }

  //Testing
  Unsafe.unsafe{ implicit  u =>
    val firstEffect = ZIO.succeed{
      println("First effect")
      Thread.sleep(1000)
      1
    }
    val secondEffect = ZIO.succeed{
      println("Second effect")
      Thread.sleep(1000)
      2
    }

    val mol = runtime.unsafe.run(sequenceTaskLast(firstEffect,secondEffect))
    println(mol)

  }

  //2. sequence 2 ZIOs and take the first one
  def sequenceTaskFirst[R,E,A,B](z1:ZIO[R,E,A],z2:ZIO[R,E,B]):ZIO[R,E,A] = {
    for{
      a <- z1
      b <- z2
    } yield (a)
  }

  def sequenceTaskFirst2[R,E,A,B](z1:ZIO[R,E,A],z2:ZIO[R,E,B]):ZIO[R,E,A] =  {
    z1 <* z2
  }

  //3. Zio run for ever
  def runForEver[R,E,A](z1:ZIO[R,E,A]):ZIO[R,E,A] = z1.flatMap(_=> runForEver(z1))

  def runForEver2[R,E,A](z1:ZIO[R,E,A]):ZIO[R,E,A] = z1 *> runForEver(z1)

//  val endlessloop = runForEver{
//    ZIO.succeed {
//        println("endless loop")
//        Thread.sleep(1000)
//
//    }
//  }

//  Unsafe.unsafe{ implicit  u =>
//    val firstEffect = ZIO.succeed{
//      println("Run Forever loop")
//      Thread.sleep(1000)
//      1
//    }
//
//
//    val mol = runtime.unsafe.run(runForEver(firstEffect))
//    println(mol)
//
//  }

  //4. Zconvert the value of zio to some thing else
  def convertZIO[R,E,A,B](z1:ZIO[R,E,A],value:B):ZIO[R,E,B] = {
   z1.map(_ => value)
  }

  def convertZIO1[R,E,A,B](z1:ZIO[R,E,A],value:B):ZIO[R,E,B] = {
    z1.as(value)
  }

  Unsafe.unsafe{ implicit  u =>
    val firstEffect = ZIO.succeed{
      println("Run Forever loop")
      Thread.sleep(1000)
      1
    }


    val mol = runtime.unsafe.run(convertZIO(firstEffect,10))
    println(mol)

  }

  //5. convert the value of zio to unit
  def convertZIOUnit[R,E,A,B](z1:ZIO[R,E,A]):ZIO[R,E,Unit] = {
    convertZIO(z1,())
  }

  def convertZIOUnit1[R,E,A,B](z1:ZIO[R,E,A]):ZIO[R,E,Unit] = {
    z1.unit
  }

  //6 . Recursion
   def sum(n:Int): Int = {
     if(n==0) 0
     else n + sum(n-1) // this will crash at sum( 20000)
   }

   def sumZIO(n:Int):UIO[Int] = {
     if(n==0) ZIO.succeed(0)
     else  for{
      current <- ZIO.succeed(n)
      prevSum <- sumZIO(n-1)
     } yield (current+prevSum)
   }

  Unsafe.unsafe{ implicit  u =>
    println("Sum =")
    val mol1 = sum(164) // will fail stackoverflow for 20000
     println(mol1)
    val mol = runtime.unsafe.run(sumZIO(11)) // 20000 evalutioned on the heap and use tail recursion
    println(mol)
  }

   //7. fibonacci

   def fibo(n:Int):BigInt =
     if (n<=2) 1
     else fibo(n-1) + fibo(n-2)  // This will fail for 20000 , stackoverflow


   //use ZIO.suspend or ZIO.suspendSucceed
   def fibZIO(n:Int):UIO[BigInt] = {
     if (n<=2) ZIO.succeed(1)
     for {
       last <- ZIO.suspendSucceed(fibZIO(n-1)) // evalaute the statement upton requirment
       prev <- fibZIO(n-2)
     } yield (last+prev)
   }
}
