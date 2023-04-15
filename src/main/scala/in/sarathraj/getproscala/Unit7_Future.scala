package in.sarathraj.getproscala
import scala.concurrent.Future

//Adding the implicit global execution context to your scope. It contains information about the resources available to your program.
import scala.concurrent.ExecutionContext.Implicits.global
// This expression is equivalent to defining the following implicit value:
// import scala.concurrent.ExecutionContext
// using val ec = ExecutionContext.global
object Unit7_Future extends  App {

//  object Future {
//    The parameter is not evaluated until needed.
//      The ExecutionContext defines the available set of threads to use.
//    def apply[T](r: => T)
//                (using ec: ExecutionContext): Future[T] = {
//      ??? }

  def isProductAvailable(productId: Int,
                         quantity: Double): Future[Boolean] = Future {
    requestAvailability(productId, quantity)
  }

  private def requestAvailability(productId: Int,
                                  quantity: Double): Boolean = true

  //ExecutionContext as an implicit parameter rather than an import
  //When developing a large application, you should prefer passing your
  // Execution- Context as an implicit parameter to your classes and functions
  // rather than directly using the global execution context. You could then select
  // which execution context to use in one place of your codebase, usually its entry point.
  // This approach gives you more control over which execution context your pro- gram uses and
  // is easier to customize if needed.

  //The function onComplete returns a value of type Unit.

  val k =  Future(10/2).onComplete { value =>
     if (value.isFailure) "bad"
    else "good"
  }

  println(k) //onComplete returns a value of type Unit. this can be overcome in map


}
