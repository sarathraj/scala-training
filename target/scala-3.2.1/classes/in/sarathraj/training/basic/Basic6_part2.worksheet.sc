// Variance part 1
// https://www.baeldung.com/scala/variances 
// Variance tells us if a type constructor (equivalent to a generic type in Java) is a subtype of another type constructor.
// https://www.youtube.com/watch?v=fpDCUvNZI9E
// https://code.likeagirl.io/scala-variances-covariance-contravariance-and-invariance-67cc0c4fdc84

sealed trait Test 
class UnitTest extends Test 
class IntegrationTest extends UnitTest 
class FunctionalTest extends IntegrationTest

// we want to model the result of a test on an object of type generic type T. We can use a type constructor to model such a situation:
class TestResult[T] (id:String,target:T){

}


//Variance defines the subtyping relationship among type constructors,

sealed trait Polygon
case object Parallelogram extends Polygon
case object Rectangle extends Parallelogram
case object Square extends Rectangle

//generic type 
// For List[T], if we use List[Int], List[AnyVal], etc.
// then these List[Int] and List[AnyVal] are known
// as Parameterized Types.




//Types of Variance
//    Covariance (Preserved) [+T]
//    Contravariance (Reversed) [-T ]
//    Invariance (Ignored)

class Shape[+T](polygon: T)
val shape:Shape[Polygon] = new Shape[Parallelogram](List(Parallelogram))
val shape1:Shape[Polygon] = new Shape[Parallelogram](List(Parallelogram))

class ShapeA[T](polygon: T)
val shape2:ShapeA[Polygon] = new Shape[Parallelogram](List(Parallelogram))

// Contravariance [-T]
// If S is subtype of T then List[T] is a subtype of List[S].
class ShapeB[-T](polygon: T)
case object RectangleA
case object SquareA extends RectangleA
// Shape as contravariant, which means that the type Shape[Rectangle] is a subtype of Shape[Square]. The contravariance property allows us to declare a variable like:
val shape: ShapeB[Square] = new ShapeB[Rectangle](List(new Rectangle))


// Invariance

// If S is subtype of T then List[S] and List[T] don’t have inheritance relationship or sub-typing. That means both are unrelated.
// Generic classes in Scala are invariant by default. This means that they are neither covariant nor contravariant.
// We say that a type constructor F[_] is invariant if any subtype relationship between types A and B is not preserved in any order between types F[A] and F[B].
// This kind of relationship between two parameterized types is known as Invariance or Non-Variance.

class ShapeO[T](polygon: T)
case object ParallelogramO
case object RectangleO extends ParallelogramO

// The Shape[Parallelogram] accepts only Parallelogram type. Any super type or sub type is not accepted.
val suite: ShapeO[Parallelogram] = new ShapeO[Parallelogram](List(new Parallelogram)
  

//Variance is related to the Liskov Substitution Principle (LSP) telling that “functions that use pointers to base classes must be able to use objects of derived classes without knowing it”.

// This means that if S is a subtype of T, then the objects of type T maybe replaced with objects of type S without changing the behavior of T.