package in.sarathraj.getprogrammingscala

object UnitOne extends App{

  def exam(d1:Double,d2:Double,d3:Double):Double ={
     Math.max(Math.max(d1,d2),d3)
  }

  val result = exam(1,4,0.1)
  println(result)

  def evenOrOdd(n: Int):String =
    if (n%2 ==0) "even"
    else "odd"

  println(evenOrOdd(10))
  println(evenOrOdd(11))

  def countP() = {
    var i = 0
    while(i<10) {
      println(i)
      i+=1
    }
  }

  def echo5(n:Int): Unit ={
    for(i <- 1 to n ) println(i)
  }

  echo5(10)

  countP()



  def discountD(price:Double):Double = {
    if(price >50 && price <100) 10.0
    else if(price >=100) 15.0
    else 0.0
  }

  val resultD = discountD(66.0)
  println(resultD)

  //In scala can have return type or thow exception
  def myFunc(n: Int): Boolean = {
    if (n < 0) throw new RuntimeException("Error!")
    n % 2 == 0
  }

  //myFunc(-1)

  def testing:Int = ???


 // testing

  println(new Person(name = "sarath"))
  println(new Person(name = "BOb",age = 11))

}

class Person(name:String,age:Int=0){
  def presentYourself = name + " " +  age
}
