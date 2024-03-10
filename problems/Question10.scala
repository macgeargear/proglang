import scala.annotation.tailrec

object Question10 {
  var t = 0;
  def alternate(f1: (Int, Int) => Int, f2: (Int, Int) => Int, list: List[Int]): Int = {
    @tailrec
    def alternateHelper(f1: (Int, Int) => Int, f2: (Int, Int) => Int, list: List[Int], acc: Int, isEven: Boolean): Int = {
      if (list.isEmpty) {
        acc
      } else {
        val newAcc = if (isEven) f1(acc, list.head) else f2(acc, list.head)
        alternateHelper(f1, f2, list.tail, newAcc, !isEven)
      }
    }

    if (list.isEmpty) return 0
    alternateHelper(f1, f2, list.tail, list.head, isEven = true)
  }

}
