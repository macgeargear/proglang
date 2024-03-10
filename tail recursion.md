##### Pascal's triangle (ex)
```scala
def pascal(c: Int, r: Int): Int = {
	if (c==0 || c==r) 1
	else pascal(c-1, r-1) + pascal(c, r-1)
}
```

##### Parenthesis balancing (ex)
```scala
def balance(chars: List[Char]): Boolean = {
	balance(chars, 0)	
}

def balance(chars: List[Char], acc: Int): Boolean = {
	if (chars.isEmpty && acc == 0) true
	else if (chars.isEmpty && acc != 0) false
	else if (acc < 0) false
	else if (chars.head != '(' && chars.head != ')') balance(chars.tail, acc)
	else if (chars.head == '(') balance(chars.tail, acc+1)
	else balance(chars.tail, acc-1)
}
```
**List**
- `isEmpty`: check if the list is empty
- `head`: return first element of the list
- `tail`: returns the list with the first element removed

##### Factorial (non tail-recursive)
not obtimize in memory
```scala
def factorial(x: Int): Int = {
	if (x==0) return 1
	x * factorial(x-1)
}

def main(args: Array[String]): Unit = {
	println(factorial(4))
}
```
##### Factorial (tail-recursive)
```scala
def factorial(x: Int, acc: Int): Int = {
	if (x==0) return acc
	factorial(x-1, x*acc)
}

def main(args: Array[String]): Unit = {
	println(factorial(4, 1)) // -> f(3,4) -> f(2, 12) -> f(1, 24) -> f(0, 24) -> 24
} 
