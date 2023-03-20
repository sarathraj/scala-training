// class objects 

class  Calc:
    var sum = 0
    private val count = 10


val c = new Calc
c.sum = 200

import java.time.OffsetDateTime

val offsetDT = OffsetDateTime.now();  
println(offsetDT.getDayOfYear());  
println(offsetDT.toLocalDate());