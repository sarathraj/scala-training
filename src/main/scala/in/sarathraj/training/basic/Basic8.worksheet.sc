// for . map , flatmap
// covarience // contravarience 
// generics 
// by name parameter lazy evaluution
// combinators zip ,zipWith
// transformators 
// given and clousers in scala 3
// https://www.udemy.com/course/advanced-scala/learn/lecture/28604920#overview
//Lazy evaluation
//call by name -- https://www.udemy.com/course/rock-the-jvm-scala-for-beginners/learn/lecture/7660632#overview



object Given {
    
}

 val aList = List(2,3,1,4,7,2)
 aList.sorted
 // are equlla t o implicit vals
 given decendingOrder:Ordering[Int] = Ordering.fromLessThan( _ > _)

 println(aList.sorted)

// lazy delay the evaltion of values 
// error  val x :Int = throw new RuntimeException
lazy val x :Int = throw new RuntimeException
// println(x)
lazy val y:Int = {
    println("Hello")
    32
}


println(y)
println(y)  // y will not evaluate again , once evaluate and use again 


// Implications 
def sideEffectCondition:Boolean = {
 println("Boo")
 true
}

def simpleCondition:Boolean ={
    false
}

lazy val lazyCondition = sideEffectCondition
// very carefull below condition having side effect
// if simpleCondition is false lazyCondition is not executed
println ( if (simpleCondition && lazyCondition ) "yes" else "no")  
println ( if (lazyCondition && simpleCondition ) "yes" else "no")

//in conjuction with call by name 
def byNameMethod(n: =>Int ) = n+ n+ n + 1
def ReteriveMagicValue = {
    println("waiting")
    Thread.sleep(1000)
    4
}
// Here three time calling in the case of call by Name , n is called n time 
// to avoid this use below method with lazy val
println(byNameMethod(ReteriveMagicValue))
def byNameMethod1(n: =>Int ):Int = {
   lazy val k =  n
   k+ k+ k + 1
}

// to avoid this use below method with lazy val
println(byNameMethod1(ReteriveMagicValue))

// filter 
// withfilter use lazy


//for -comprehension use with filter with guard 
// withFilter use filter monadic
val kp= for{
    a <- List(1,2,3,4) if(a%2==0)  // if guard use lazy vals 
} yield(a+1)

val kp1 = List(1,2,3,4).withFilter(_%2==0).map(_+1)

// call by name  - expression itself is passing


def add(a: => Long):Long = {
    println(s"value $a")
     println(s"value $a")
    a
}

val k =add(System.nanoTime())
