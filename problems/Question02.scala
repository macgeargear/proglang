import scala.annotation.tailrec

object Question02 {
  def insertInOrder(x: Int, l: List[Int]): List[Int] = {
    val ans: List[Int] = List()
    insertInOrderHelper(x, l, ans, isInsert = false)
  }

  @tailrec
  private def insertInOrderHelper(x: Int, l: List[Int], ans: List[Int], isInsert: Boolean): List[Int] = {
    if (l.isEmpty && !isInsert) ans ++ List(x)
    else if (l.isEmpty) ans
    else if (x < l.head && !isInsert) insertInOrderHelper(x, l.tail, ans ++ List(x) ++ List(l.head), !isInsert)
    else insertInOrderHelper(x, l.tail, ans ++ List(l.head), isInsert)
  }
}

/*

7, 1 2 3 10 12
         ^

*/
