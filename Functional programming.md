---
topics: "[[scala]]"
---

- no changing variable
- no assignment
- no loop
- just focusing on ==function==
- functions can be defined anywhere, including in other functions
- functions can be passsed as paramsters and returned as results
- there're operator that can compse function

### What are good about functional programming?
- simpler reasoning
- good for multicore and cloud computing
	- Avoid modifying variables by different parts of the program
- places to use (where we want scalable solutions)
	- web
	- trading platforms
	- simulation

### Evaluating function == Evaluation expression
- substitution model(evaluating until getting a `value`)
	- can be use when function have no side effect
		- `square(square(2))`
		- `square(4)`
		- `16`
- example of side effect (cannot be expressed in a substitution model)
	- `x++`


### Recursion is important in this paradigm
- need to be able to think of it instead of loop
- can be optimized to use only 1 stack frame([[tail recursion]])

### Higer order function
- take functions as arguments
- can return function
##### ex function higher order

```scala
def calculate(x: Double, y: Double, f: (Double, Double) => Double): Double = {
	f(x,y) // return double
}

def mul(x: Double, y: Double): Double = x*y

def main(args: Array[String]): Unit = {
	println(calculate(3,5, (a,b) => a+b))
	println(calculate(3,5, mul))
}
```
#### Chaining function
```scala
def calculate(x: Double, y: Double, z: Double, f: (Double, Double) => Double): Double = {
	f( f(x,y), z) 
}

def main(args: Array[String]): Unit = {
	println(calculate(3,5,7, (a,b) => a+b))
	println(calculate(3,5,7, _ + _)) // short hand
	println(calculate(3,5,7, mul))
	println(calculate(3,5,7, (a,b) => a min b))
	println(calculate(3,5,7, _ min _)) // short hand
}
```

- define $\sum_{n=a}^{b} f(n)$ where $f$ can be any function
```scala
// not tail
def sum(f: Int => Int, a: Int, b: Int): Int = {
	if (a>b) return 0
	f(a) + sum(f, a+1, b)
}

// tail v1
def sum(f: Int => Int, a: Int, b: Int, acc: Int) = {
	if (a>b) return acc
	sum(f, a+1, b, acc + f(a))
}

// tail v2
def sum(f: Int => Int, a: Int, b: Int): Int = {
	def sumAcc(a: Int, acc: Int): Int = {
		if (a>b) return acc
		sumAcc(a+1, acc + f(a))
	}
	sumAcc(a, 0)
}

def id(a: Int): Int  = a
def square(a: Int): Int = a*a
def fac(x: Int, acc: Int): Int = {
	if (x==0) return acc
	fac(x-1, acc*x)
}

def main(args: Array[String]): Unit = {
	println(sum(id, 2, 4)) // 2+3+4
	println(sum(square, 2, 4)) // 2^2 + 3^2 + 4^2
	println(sum(fac, 2, 4)) // 2! + 3! + 4!
}

```

### Currying - Function as return value
func with multiple args -> func with one arg returning another func
```scala
def add(x: Int, y: Int): Int = {
	x+y
}

def addCurry(x: Int): Int => Int = {
	(y: Int) => x+y
}

// cannot use partial execution
// if you want to use
// var sum30 = addCurryShort(30)_    -> in scala2
def addCurryShort(x: Int)(y: Int): Int = x+y 

def main(args: Array[String]): Unit = {
	println(addCurry(3)(5))

	val sum20 = addCurry(20) // partial execution
	println(sum20(7)) //27
	println(addCurryShort(3)(5)) // 8
}
```

#### Currying $\sum_{n=a}^{b} f(n)$
```scala
def sum(f: Int => Int): (Int, Int) => Int = {
	def sumF(a: Int, b: Int) => {
		if (a>b) 0
		else f(a) + sumF(a+1, b)
	}
	sumF
}

def main(args: Array[String]): Unit = {
	println(sum(id)(2,4))
	println(sum(square)(2,4))
	println(sum(fac)(2,4))
}
```

#### Currying - special syntax (multiple parameter list)
```scala
def sum(f: Int => Int)(a: Int, b: Int): Int = {
	if (a>b) 0
	else f(a) + sum(f)(a+1, b)
}
```
the type of this function is
`(Int => Int) => ((Int, Int) => Int)` or `(Int => Int) => (Int, Int) => Int`
since function types are right associative, so `Int => Int => Int` ===
`Int => (Int => Int)`

#### Factorial in terms of product $\prod_{i=a}^{b} f(i)$
```scala
def product(f: Int => Int)(a: Int, b: Int): Int = {
	if (a>b) 0
	else f(a) * product(f)(a+1, b)
}

def myFac(n: Int): Int = {
	product(id)(1, n)
}
```

##### Exercise write a function that can be changed to use either sum or product
- using the new function, in main, calculate `2 + 3 + 4 and 2^2 * 3^2 * 4^2`
