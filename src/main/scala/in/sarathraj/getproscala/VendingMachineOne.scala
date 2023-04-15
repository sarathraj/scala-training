package in.sarathraj.getproscala
//package getprogrammingscala

// Problem
// EVERYTHING IS PUBLICLY ACCESSIBLE
// VARS ARE PROBLEMATIC
//STRING AS THE REPRESENTATION OF A PRODUCT
// STRING AS RETURN TYPE
// THE VENDING MACHINE IS NOT CONFIGURABLE
// p 68



class VendingMachineOne {

  var chocolateBar = 0
  var granolaBar =0
  var totalMoney = 0.0

  def buy(product:String,amount:Double):String = {
    if(!isProductAvailable(product)){
      s"Sorry no product $product Available"
    }else if(!isMoneyEnough(product,amount)){
      s"Sorry money is not enough "
    }else{
      completeRequest(product,amount)
    }
  }

  def isProductAvailable(product:String):Boolean = {
    val productQty =
      if(product=="chocolate") chocolateBar
      else if(product=="granola") granolaBar
      else 0
    productQty > 0
  }

  def isMoneyEnough(product:String,amount:Double):Boolean = {
    val productCost =  if(product=="chocolate") 1.5 else 1
    amount>=productCost
  }

  def completeRequest(product:String,amount:Double):String ={
    collectMoney(amount)
    releaseProduct(product)
    s"There you go! Have a $product bar"
  }

  def collectMoney(money:Double) ={
    totalMoney +=money
  }

  def releaseProduct(product: String) =
    if (product == "chocolate") chocolateBar -= 1
    else if (product == "granola") granolaBar -= 1


}
