// Recursion
val x = List(1,2,3)

def rev(xs: List[Int]): List[Int] = xs match {
  case Nil => List()
  case  x :: next => rev(next) :+ x
}
println( rev(x))

def rev1(xs: List[Int]): List[Int] = xs match {
  case Nil => List()
  case  x :: next =>  x +: rev(next)
}

def reverse[A](l:List[A]):List[A] = {

  def _reverse[A](r:List[A], l:List[A]):List[A] = l match {
    case Nil => r
    case head::tail => _reverse(head::r, tail)
  }
  _reverse(List(), l)
}

