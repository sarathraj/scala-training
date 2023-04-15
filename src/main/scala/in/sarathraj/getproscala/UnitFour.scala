package in.sarathraj.getproscala

object UnitFour extends App {

  case class Person(name:String,age:Int)

  def check(p:Person):String = p match {
    case Person("Tom",_) => "Its tom"
    case Person(name,age) if(age>18) => "Its sarath"
    case p @ Person(_, 10) =>   "Its a boy"
    case Person(_,_) => "Hi Bro"
  }

  println(check(Person("sam",11)))
  println(check(Person("Riho",88)))

  case object PersonA{
    val age = 10
  }
  // case object product the name of the class , normal object looks like  UnitFour$PersonB$@1554909b
  println(PersonA.toString)

  object PersonB
  println(PersonB.toString)
 ///////
 // Higher order function

  //name : type => return
  //name : type => return = default
  //def name(functionParameters): return = expression

  // return value not function

  def lenNumber(s:String):Int = s.count(_.isDigit)
  def lenChar(s:String):Int = s.count(_.isLetter)

  //combine above
  // predicate:Char =>Boolean is a function
  def stat(s:String,predicate:Char => Boolean):Int={
    s.count(predicate)
  }

  println(stat("sarath",_.isLetter))  // 6
  println(stat("sarath1234",_.isDigit)) //4
  println(stat("sarath1234x",_ == 'x'))  // // count of chars equal to "x" // 1
  println(stat("sSSarath1234x",_.isUpper))  // // count of chars upper // 2

  // with a default value
  def stat1(s:String,predicate:Char => Boolean = { _ => true } ):Int={
    s.count(predicate)
  }

  println(stat1("sarath1234x",_.isUpper))  // // count of chars upper // 2
  // function return

  sealed trait Mode
  case object Length extends Mode
  case object Letters extends Mode
  case object Digits extends Mode

  def predicate(mode:Mode):Char =>Boolean = mode match {
  case Length => _ => true
  case Letters => _.isLetter
  case Digits => _.isDigit
  }


  println(stat("sarath",predicate(Letters)))  // 6
  println(stat("sarath1234",predicate(Digits))) //4


  //map option flatten to  and flatmap

  case class Car(model: String,
                 owner: Option[PersonC],
                 registrationPlate: Option[String])
  case class PersonC(name: String,
                    age: Int,
                    drivingLicense: Option[String])

  var per = PersonC("sarath",36,Some("DR1133"))
  var per1 = PersonC("jijo",36,None)

  val car = Car("Ford",None,None)
  var car1 = Car("Ford1",Some(per),Some("1231"))
  var car2 = Car("Ford2",Some(per),None)
  var car3 = Car("Ford3",Some(per1),Some("1111"))



  val cars = List(car,car1,car2,car3)

  //find owner
  def findOwnerOfCar(car:Car):Option[String] =car.owner match {
    case Some(person: PersonC) => Some(person.name)
    case None => None
  }

  println(findOwnerOfCar(car1))
  println(findOwnerOfCar(car2))
  println(findOwnerOfCar(car3))
  println(findOwnerOfCar(car))


  //find owners driving license
  def findOwnerDrivingLicense(car:Car):Option[Option[String]] =car.owner match {
    case Some(person: PersonC) => Some(person.drivingLicense match {
      case Some(license:String) => Some(license)
      case None => None
    })
    case None => None
  }

  println(findOwnerDrivingLicense(car)) //.//. Some(Some(DR1133))
  println(findOwnerDrivingLicense(car1))


  //find owners driving license using map
  def findOwnerDrivingLicense1(car:Car):Option[Option[String]] =car.owner.map(_.drivingLicense)
  println(findOwnerDrivingLicense1(car))  // Some(Some(DR1133))
  println(findOwnerDrivingLicense1(car1))


  //find owners driving license using map and flatten  to avoid two option in reutn type
  def findOwnerDrivingLicense2(car:Car):Option[String] =car.owner.map(_.drivingLicense).flatten
  println(findOwnerDrivingLicense2(car)) // Some(DR1133)
  println(findOwnerDrivingLicense2(car1))

  // flattern definition
//  def flatten: Option[A] =
//    this match {
//      case Some(opt) => opt
//      case None => None
//    }

  // flatmap items

   def findOwnerDrivingLicense3(car:Car):Option[String] = car.owner.flatMap(_.drivingLicense)
  println(findOwnerDrivingLicense3(car)) // Some(DR1133)
  println(findOwnerDrivingLicense3(car1))


  def ownerDrivingLicense(optCar: Option[Car]): Option[String] =
   optCar.flatMap { car =>
     car.owner.flatMap { person =>
       person.drivingLicense
} }

// for-comprehension. to avoid too much flatmap 
def ownerDrivingLicense22(optCar: Option[Car]): Option[String] =
   for {
     car <- optCar
     person <- car.owner
     drivingLicense <- person.drivingLicense
} yield drivingLicense


def ownerDrivingLicense1(optCar: Option[Car]): Unit =
   for {
     car <- optCar
     person <- car.owner
     drivingLicense <- person.drivingLicense
} yield ()


}
