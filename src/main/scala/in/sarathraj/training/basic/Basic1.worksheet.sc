//Day 2

def sample(x:Int):Int = 
    if(x > 20) 
        100
    else
        0    

sample(10)        

sample(200)


var i = 1

while i <10 do 
    print( s"$i  ")
    i+=1

val kp = Array(1,2,3,4)
kp.foreach(arg => println(arg+11))

for i <- 1 to 10 do
    println (i)    


val x  =new Array[String](2)
x(0) = "hello"    
x(1) = "hello1"   

println(x.map(println))


val oneTwo = List(1, 2)
val threeFour = List(3, 4)

val newList = oneTwo ::: threeFour

val twoThree = List(2, 3)
val oneTwoThree = 1 :: twoThree 
val twoThree1 =oneTwoThree :: Nil
val twoThree14 = twoThree1 :: 1 :: Nil
val a = List.empty

import scala.collection.mutable
val movieSet = mutable.Set("Spotlight", "Moonlight")
movieSet += "Parasite"

import scala.collection.immutable
val movieSetIm = immutable.Set("Spotlight", "Moonlight")

def formatArgs(args: List[String]) = args.mkString(" -- ")

val arr = List("sarath ","aaa")
formatArgs(arr)