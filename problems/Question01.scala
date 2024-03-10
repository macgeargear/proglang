import scala.annotation.tailrec

object Question01 {
  def insertAtPosition(x: Any, pos: Int, l: List[Any]): List[Any] = {
    if (l.isEmpty) return List(x)
    val ans: List[Any] = List()
    insertHelper(x, pos, 0, l.length, l, ans)
  }

  def insertLast(x:Any, l:List[Any]): List[Any] = {
    insertAtPosition(x, l.length, l)
  }

  @tailrec
  private def insertHelper(x: Any, pos: Int, i: Int, n: Int, l: List[Any], ans: List[Any]): List[Any] = {
    if (l.isEmpty) ans
    else if (pos == n) l ++ List(x)
    else if (pos == 0) List(x) ++ l
    else if (i == pos) insertHelper(x, pos, i + 1, n, l, ans ++ List(x))
    else insertHelper(x, pos, i + 1, n, l.tail, ans ++ List(l.head))
  }

}

/*
2 99
--
0 1 2 3
1 2 3 4 -> 1 2 99 3 4

1 2

*/
