

object Question03 {
  def delete(x: Any, l: List[Any]): List[Any] = {
    if (l.isEmpty) List()
    else if (x == l.head) delete(x, l.tail)
    else l.head :: delete(x, l.tail)
  }

  def contain(x: Any, l: List[Any]): Boolean = {
    if (l.isEmpty) false
    else if (l.head == x) true
    else contain(x, l.tail)
  }

  def subList(l1: List[Any], l2: List[Any]): Boolean = {
    if (l1.isEmpty) true
    else if (!contain(l1.head, l2)) false
    else subList(l1.tail, l2)
  }


}

/*
1 2 3
4 2 1 3
*/
