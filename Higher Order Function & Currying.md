### Partially applied function
```scala
def main(args: Array[String]): Unit = {
	// fully applied function
	val sum = (x: Double, y: Double, z: Double) => x+y+x
	// partially applied function
	val f = sum(3, 5, _: Double)

	println(f(2))
	println(partialMul(3))
}
```

**Application**
```scala
import java.util.Date  
  
object FunctionPartiallyAppliedApplication {  
  def dateMessage(date: Date, s: String) ={  
    println(date + ", " +s)  
  }  
  
  def main(args: Array[String]): Unit = {  
    var date = new Date  
    var newMessage = dateMessage(date, _:String) //closure  
    for(i:Int <- 0.to(5)) {  
      Thread.sleep(300)  
      date = new Date  
      newMessage("message " + i)  
    }  
  }  
}
```

### Closure
- A function that uses variable(s) declared outside the function.
```scala
object Closure {
	var n = 5
	var add = (x: Int) => x + n // closure with n coming from outside

	def main(args: Array[String]): Unit = {
		println(add(2)) // -> 7
		n = 100
		println(add(2)) // -> 102
	}
}
```
> result will be 
> 7
> 102

**Closure with side effect** (impure closure)
- usually we not prefered side effect (wrong logic with function programming)
```scala
object ClosureSideEffect {  
  var n = 5  
  val add = (x:Int) => {  
    n = x+n  
    n 
  }    //closure with n coming from outside  
  
  def main(args: Array[String]): Unit = {  
    println(add(2))           //closure with add coming from outside  
    n =100  
    println(add(2))  // 102
    println(add(2))  // 104
  }  
}
```
