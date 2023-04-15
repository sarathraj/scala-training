package in.sarathraj.getproscala

object UnitFive extends  App {
// List and sum using recursion

  val items = List(1,2,3)

  def sum(items:List[Int]):Int = items match {
    case Nil => 0
    case head  :: tail => head + sum(tail)
  }


  println(sum(items))

}
