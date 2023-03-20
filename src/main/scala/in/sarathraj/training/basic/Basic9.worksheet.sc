//Type class part - 1


object TypeClass extends App {

    println("Hello world")

}

case class User(name:String,age:Int)

trait HTMLSeri[T]:
    def serialize(value:T):String

implicit object HTMLSeriImpl extends HTMLSeri[User]{
    override def serialize(value: User): String = s"name :${value.name} - age : ${value.age}"
}


//Type class part - 2 (using implicits)

object HTMLSerializer{
    def serialise[T](value:T)(implicit serializer:HTMLSeri[T]):String = 
        serializer.serialize(value)
}

implicit  object IntSerilaizer extends HTMLSeri[Int] {

    override def serialize(value: Int): String = s"<div>$value</div>"

    def apply[T] (implicit serializer:HTMLSeri[T]) = serialize
    
}


println(HTMLSerializer.serialise(42)(IntSerilaizer))

println(HTMLSerializer.serialise(42)) // implict action is performed

println(HTMLSerializer.serialise(User("sarath",20))) // implict action is performed

//Access to the entire type class interface , not working in 3
//println(HTMLSerializer[User].serialize(User("sarath",20)))


//Pimp my Library 

object PimpMyLibrary{
    implicit class RichInt(val i:Int){
        def isEven:Boolean = i%2==0
        def square:Double  = i*i
     }

     new RichInt(12).square
     42.isEven
     //type Entrichment or pimping
}

// Above item is danger 
// 1 * 2 = 10

//Part 3 