// read 4 students details and print 
// read n students details and print 

case class Student(id:Int,name:String,age:Int): 
    override def toString() = s"$id - $name - age: $age"

def getStudent(id:Int,name:String,age:Int):Student =
    Student(id,name,age)

def getStudentById(students:List[Student],id:Int):Option[Student] = 
    students.find(p=> p.id==id)

var students:List[Student] = List()
students = students :+ getStudent(1,"sarath",10) :+ getStudent(1,"raj",11)
println(students)   
getStudentById(students,1)


for stu <- students do
    println(stu.id)



val filesHere = (new java.io.File(".")).listFiles
for file <- filesHere do
    println(file)    

for i <- 1 to 100 do
    print(i)    

for file <- filesHere do
    if file.getName.endsWith(".scala") then
        println(file)    

for file <- filesHere
        if file.isFile
        if file.getName.endsWith(".scala")
    do println(file) 


val scalaFiles =
    for
      file <- filesHere
      if file.getName.endsWith(".scala")
    yield file


for k <- scalaFiles do
    print(k)

    