class Rational (n:Int,d:Int):
   
    require(d!=0)
    println("Created " + n + "/" + d)
    private val g = gcd(n.abs, d.abs)
    val numer = n /g
    val denom = d /g 
    
     def this (n:Int) = this(n,1) //auxilary constructor    
    override def toString = s"$numer/$denom"
    def + (that: Rational): Rational =
        Rational(
            numer * that.denom + that.numer * denom,
            denom * that.denom
        )
    def * (that: Rational): Rational =
        Rational(numer * that.numer, denom * that.denom)
    def thisDetails():String =
        " " + this.numer + " / " +  this.denom + ""
    def lessThan(that: Rational) =
        this.numer * that.denom < that.numer * this.denom
    def max(that:Rational):Rational =
        if this.lessThan(that) then that else this 
        
    private def gcd(a: Int, b: Int): Int =
        if b == 0 then a else gcd(b, a % b)

            



val oneHalf = Rational(1,2)
oneHalf.denom
oneHalf.numer

val twoThirds = Rational(2,3)
twoThirds.thisDetails()

oneHalf.+(twoThirds)

oneHalf.lessThan(twoThirds)

oneHalf.max(twoThirds)



val one= Rational(5)

val gcdItem = Rational(66, 42)


val x = Rational(1,2)
val y = Rational(1,2)
val z = Rational(1,2)

x+y *z