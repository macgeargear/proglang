// isEmpty, length, head, tail, ::, ++
object ListExample {
  val myList = 1 :: 2 :: 3 :: 4 :: 5 :: Nil

  def member(x: Any, l: List[Any]): Boolean = {
    if (l.isEmpty) return false
    if (x == l.head) return true
    member(x, l.tail)
  }

  def sorted(l: List[Int]): Boolean = {
    if (l.isEmpty || l.length == 1) true
    else ((l.head) <= (l.tail).head) && sorted(l.tail)
  }

  def delete(x: Any, l: List[Any]): List[Any] = {
    if (l.isEmpty) List()
    else if (x == l.head) delete(x, l.tail) // just skip X
    else l.head :: delete(x, l.tail)
  }

  def length(l: List[Any]): Int = {
    if (l.isEmpty) 0
    else 1 + length(l.tail)
  }

  def append(l1: List[Any], l2: List[Any]): List[Any] = {
    if (l1.isEmpty) return l2
    if (l2.isEmpty) return l1
    val t = append(l1.tail, l2)
    return l1.head :: t
  }

  def myReverse(l: List[Any]): List[Any] = {
    if (l.isEmpty) List()
    else myReverse(l.tail) ++ List(l.head) // note that ++ concatenate LIST
  }

  def dot(l1: List[Int], l2: List[Int]): Int = {
    if (l1.isEmpty || l2.isEmpty) 0
    else l1.head * l2.head + dot(l1.tail, l2.tail)
  }

  def dot_v2(l1: List[Int], l2: List[Int], acc: Int): Int = {
    if (l1.isEmpty || l2.isEmpty) acc
    else dot_v2(l1.tail, l2.tail, acc + l1.head * l2.head)
  }

  def max_helper(l: List[Int], cur: Int): Int = {
    if (l.isEmpty) cur
    else if (cur >= l.head) max_helper(l.tail, cur)
    else max_helper(l.tail, l.head)
  }

  def max(l: List[Int]): Int = {
    max_helper(l, l.head)
  }

  def setify(l: List[Any]): List[Any] = {
    if (l.isEmpty) List()
    else if (member(l.head, l.tail)) l.tail
    else l.head :: setify(l.tail)
  }

  def main(args: Array[String]): Unit = {
    println(member(3, myList))
    println(member(9, myList))
    println(sorted(myList))
    println(dot_v2(myList, myList, 0))
  }
}
