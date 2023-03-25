package in.sarathraj.getprogrammingscala

object UnitThree extends App{

  sealed trait Currency
  object USD extends Currency
  object INR extends  Currency
  object QAR extends  Currency
  object  CAN extends  Currency

  def checking(currency: Currency):Double = currency match {
    case USD => 1.11
    case INR => 0.75
    case QAR => 22
    case CAN => 77
  }

  println(checking(USD))

  def sum(a:Int ,b:Int):Int = a+ b
  //Anonymous function
  val sum = {(a:Int,b:Int) => a+b}

  val sumConcise :(Int,Int) => Int = (a,b) => a+b

  val sumConcise1 :(Int,Int) => Int = { _ + _ }

  // omitting single parameter

  val negate = { (a:Int) => a * -1 }

  val negateConcise:(Int) => Int = (a) => a+1

  val negateConcise1:(Int) => Int = _+1


  val negateUpdate = { (a:Int) => a * (-1) }

  println(negateUpdate(10))

  def hello(n: String): String = s"Hello, $n!"

  val ahello = {(n: String)  => s"Hello, $n!" }

  println(sumConcise(1,2))
  println(sumConcise1(1,2))

//Rewrite each of the following functions as anonymous functions; use your concise notation at your discretion.
  def multiply(s:String,n:Int):Int = s.length*n
  def toDouble(n:Int):Double=n.toDouble
  def concat(s1:String,s2:String):String=s1+s2
  def inverseConcat(s1:String,s2:String):String=s2+s1
  def myLongFunc(s:String):String={
    val length = s.length
    s.reverse * length }

// Answer

   val multiply1:(String,Int) => Int = _.length * _
  val toDouble:(Int) => Double = _.toDouble
  val concat1:(String,String)=>String =  _+_
  val inverseConcat:(String,String) => String = { (a,b) => b+a}
  val myLongFunc1:(String) => String = {(a) => a.reverse * a.length}

   println(myLongFunc("sarath"))


   // partial function




}
