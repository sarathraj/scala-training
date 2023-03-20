// Generics in scala 
// https://blog.knoldus.com/lets-know-about-generics-and-variance-in-scala/
// https://www.baeldung.com/java-clean-code#2-dry-amp-kiss
// https://www.baeldung.com/scala/generics-basics

//1. Generics Declaration Syntax:


case class Rabbit(i:Int)

//This method takes a Seq containing items of a chosen type and returns the item from the middle of the Seq:
 def middle[A](input:Seq[A]):A = input(input.length/2)
 
 val rabbits = List[Rabbit](Rabbit(2), Rabbit(3), Rabbit(7),Rabbit(10))
 middle(rabbits)


 //Let’s now take a look at an example with more than one type parameter:

def itemsAt[A, B](index: Int, seq1: Seq[A], seq2: Seq[B]): (A, B) = (seq1(index), seq2(index))
val rabbits1 = List[Rabbit](Rabbit(2), Rabbit(10), Rabbit(7),Rabbit(10))
itemsAt(1,rabbits,rabbits1)

// 2. Using Generics Classes in Non-Generics Method
// We don’t always write generic methods when using generic classes
def totalSize(list1: List[_], list2: List[_]): Int = list1.length + list2.length

val list1 = List[String]("sarath","prayan","amitha")
val rabbitsA = List[Rabbit](Rabbit(2), Rabbit(3), Rabbit(7))

val totalSizeA = totalSize(list1,rabbitsA)

//Upper Type Bounds
// the >=  function is not defined on the generic type T.herefore, the findMax function won’t compile at all.
val list11 = 1 :: 2 :: 3 :: Nil
val list112 = List[Nothing]()
//def findMax[T](xs: List[T]): Option[T] = xs.reduceOption((x1, x2) => if(x1 >= x2) x1 else x2)


//We know that the Ordered[T] is the home for such comparison functions. So, we should somehow tell the compiler that T is a subtype of Ordered[T] in this example.
// s it turns out, the upper bound type in Scala generics will do this for us:
// With the “T <: Ordered[T]” syntax we indicate that Ordered[T] is the supertype of type parameter T. T    
def findMax[T <: Ordered[T]](xs: List[T]): Option[T] = xs.reduceOption((x1, x2) => if (x1 >= x2) x1 else x2)
findMax(list112)

//Need to check 
//findMax(encountered)

//Lower Type Bounds
// Here, we’re defining a new type parameter U. Also, the “U >: T” syntax means that U should be a supertype of T. Now, we can use the enqueue method:
class Queue[+T](private val leading: List[T], trailing: List[T]) {
  def head(): T = leading.head
  def tail(): List[T] = trailing
  //def enqueue(x: T): Queue[T] = new Queue(leading, x :: trailing)
  def enqueue[U >: T](x: U): Queue[U] = new Queue(leading, x :: trailing)
}

//covariant type T occurs in contravariant position in type T of value x

//def enqueue(x: T): Queue[T] = new Queue(leading, x :: trailing)

val empty = new Queue[String](Nil, Nil)
val stringQ: Queue[String] = empty.enqueue("The answer")
val intQ: Queue[Any] = stringQ.enqueue(42)

