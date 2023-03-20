//implicits 

val pair = "sarath" -> 44

case class Person(name:String){
    def greet =s" Hi $name"
    
}
implicit def nameToPerson(name:String) :Person = Person(name)

println(("peter".greet))

// muliple implicits 

case class PersonA(name:String,age:Int)

object PersonOrdering{
   implicit val nameOrdering:Ordering[PersonA] = Ordering.fromLessThan((a,b) => a.name < b.name) 
}

object PersonAgeOrdering{
   implicit val nameOrdering:Ordering[PersonA] = Ordering.fromLessThan((a,b) => a.age < b.age) 
}

import PersonAgeOrdering._
val list = List(PersonA("sarath",22),PersonA("amitha",33),PersonA("prayan",12))
list.sorted

import PersonOrdering._
list.sorted

