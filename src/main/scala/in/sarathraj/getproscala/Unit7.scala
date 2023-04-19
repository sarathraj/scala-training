package in.sarathraj.getproscala


object Unit7 extends App {

  //Implicits

  def operatingTwoNumbers(a:Int,b:Int) : Double = {
    given  tolerance:Double= 0.8
    val finalDetails = sum(a,b)
    finalDetails
  }

  def sum(a:Int,b:Int)(using t:Double):Double ={
    a+b+t
  }

  println(operatingTwoNumbers(9,1))

  given  tolerance:Int= 99

  def plusOne(using n: Int): Int = n + 1

  println(plusOne(using 3)) // compiler doesn't search for implicit ,ecause you provided a value for it explicitly.

  println(plusOne) // this will take 99

  

}
