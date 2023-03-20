package in.sarathraj.recursion

// Rules of Recursive Functions

//     A recursive function will always have two or more returns
//     The recursive call needs to be returned
//     Locally defined variables will be re-defined in the scope of each recursive call. 
        // Closures will keep variables bound to the outer scope of the recursive function.
//     The base case should be returned before the recursive case



object MainRec_1 extends App{

    println("Testin Main")
   
     val items1 = List(1,2,2,1)

    //sum of n numbers  and iteration
    val s = new MainRec()
    println(s.sumItems(items1))

    s.printNTime(10,"sarath")
  
}

class MainRec {

 def sumItems(items:List[Int]):Int = {
    val length = items.length
    def sum(items:List[Int],nlen:Int) : Int = {
      if(nlen<=0) 
       0
      else sum(items,nlen-1) + items(nlen-1)
    }
     sum(items,length)
   }


   //print recursively and return final string

   def printNTime(n:Int,s:String):String = {
    if(n<=0) return s
    else {
        println(s)
        printNTime(n-1,s)
    }
   }
}
