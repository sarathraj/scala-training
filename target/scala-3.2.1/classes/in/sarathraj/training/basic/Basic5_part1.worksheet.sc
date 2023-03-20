// Scala Essentials Recap 

val aBoolean:Boolean =true

//expressions 

val a = if (2>3) "bigger" else "smaller"

//instructions ( side effect return unit)
val theUnit = println("Hello , scala")
print(theUnit)
//OOP 

class Animal
class Cat extends Animal
trait Carnivore{
    def eat(animal:Animal):Unit 
}

// inheritence model extends <= 1 , but inherits from >=0 traits

class Crocodile extends Animal with Carnivore{
    override def eat(animal: Animal): Unit = println("Crunch")
}

//singleton

object MySingleton{

}

//comapnion
object Carnivore {
    val weightInKg = 300;
}

print(Carnivore.weightInKg)


//Generics

class MyList[A]

//method notation

val three = 1+ 2

val anotherThree = 1.+(2)

// functional programming 
val increment:Int => Int  = x => x+1
val k = increment(1)

// Higher order function oftern use -> map , flatmap, filter

val processedList = List(1,2,3).map(increment)
val aLongerList =List(1,2,3).flatMap( x => List(x,x+1))

//options and try 

val anOption:Option[Int] =Option(/*something i know */ 2)
val adouble:Option[Int] = anOption.map(_*2)

import  scala.util.Try
val anAttempt = Try (42);
val aModifiedAttempt = anAttempt.map(_ * 10)

//pattern matching 

val anUnknow  = 45 

val ordibnal = anUnknow match {
    case 1: Int =>  "first"
    case 9:Int =>  "nine"
    case _: Int =>  "unknown"
}

val ret:String = anOption match {
    case Some(value) => s"the value is $value"
    case None =>  "Its a none"
}


// futures in scala 
//Future
// implicit val ec:ExecutionContext.fromExcutorService(Executors.newFixedThreadPool(8))
// val aFuture = Future{
//     42
// }

// aFuture.onComplete {
  //  case Success(value) => println("")
   // case Failure(exception) => println("Meaning of value")
// }

 //aFuture.map(_+1)


// by name parameter  chapter 9 lazy evalaution 

//for-comprehensions

val checkerboard = List(1,2,3).flatMap(n => List('a','b','c').map(c => (n,c)))

val another = for {
    n <- List(1,2,3)
    c <- List('a','b','c')
} yield (n,c)


