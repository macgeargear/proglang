import scala.annotation.tailrec

object Question08 {
  def sumAll(lists: List[List[Int]]): List[Int] = {
    @tailrec
    def findSum(list: List[Int], sum: Int): Int = {
      if (list.isEmpty) sum
      else findSum(list.tail, sum + list.head)
    }

    def getHead(lists: List[List[Int]]): List[Int] = {
      if (lists.isEmpty) return List()
      if (lists.head.isEmpty) return getHead(lists.tail)
      lists.head.head :: getHead(lists.tail)
    }
    def removeHead(lists: List[List[Int]]): List[List[Int]] = {
      if (lists.isEmpty) return List()
      if (lists.head.isEmpty) return removeHead(lists.tail)
      lists.head.tail :: removeHead(lists.tail)
    }

    var h: List[Int] = getHead(lists)
    if (h.isEmpty) return List()
    findSum(h, 0) :: sumAll(removeHead(lists))
  }

}
