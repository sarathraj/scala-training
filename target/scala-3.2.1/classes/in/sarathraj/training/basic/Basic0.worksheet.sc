
//Functions 
object Operations{
    def add(a:Int = 100,b:Int=88) = a +b 
    def square(a:Int) = a*a
    def sub(a:Int ,b:Int=88) = a -b 
    def mul(a:Int=10 ,b:Int) = a *b 
}

object OperationsSymbol{
    def +(a:Int = 100,b:Int=88) = a +b 
    def **(a:Int) = a*a
    def -(a:Int ,b:Int=88) = a -b 
    def *(a:Int=10 ,b:Int) = a *b 
}

Operations.add(1,2)

Operations.add(2)

Operations.add()

Operations.mul(b=22)

OperationsSymbol.+(1,8)


// Anonymous functions

val adding = (x:Int,y:Int) =>  x+y


adding(100,200)


val addingComplex = (x:Int,y:Int,z:Double) =>  (x+y,x-y)


addingComplex(100,200,11.11)


// Higher order functions  (  take functions as argument and return functions as result) 

// function as an argument , arguments is taken by the function
def math(x:Double,y:Double,f : (Double,Double) => Double) :Double =
    f(x,y) 

val result = math(1.0,2.0,(x,y)=> x+y)

def fn(a:Double,b:Double):Double  = a+b

def mi(a:Double,b:Double):Double  = a min b

def mx(a:Double,b:Double):Double  = a max b

val result1 =  math (20, 30, fn)

val result2 =  math (20, 30, mi)
val result3 =  math (20, 30, mx)

//three arguments 
def mathThree(x:Double,y:Double,z:Double,f : (Double,Double) => Double) :Double =
    f( f(x,y) ,z )  
val resultThree = mathThree(1.0,2.0,3.0 ,(x,y)=> x+y)

val resultThree1 = mathThree(1.0,2.0,3.0 ,_ + _)


// Partially Applied Functions

// how functions works 
// fully aplpled function

val addingData = (x:Int,y:Int,z:Double) =>  x + y + z 


// few arguemnts 

val addingDataPartial = (x:Int,y:Int,z:Double) =>  x + y + z 

val f= addingDataPartial(10,20,_:Double )

f(1)


val f1= addingDataPartial(10,_,_ )

f1(1,111)


// Real world partial function 
import java.util.Date
def log(date:java.util.Date,message:String):Unit = println(date.toString() + " " + message)

val newLog = log(_,"This is a sample log")

val logUpdated =  newLog(Date())


/// closures  - is a function , one or more variable declared outside this functions

var xp = 99
def oneArg(x:Int):Int  =
    x +xp

oneArg(10)
 

//currying  - technique tranforming ther fuction take muliple argument that takes one argument 

 def first(x:Int) = 3.14 * x



 def calc(xp:Int) = (yy:Int) => xp + yy
 


calc(10)(11)


val pk = calc(10)
pk(21)

 def calc1(xp:Int,x1:Int) (yy:Int,yy1:Int) = xp + yy + x1 + yy1

 val kk = calc1(1,2)(3,4)

val pp = calc1(1,2)(_,_)
pp(9,111)

