import scala.annotation.tailrec

object Palindrome {
  def palindrome(list: List[Any]): Boolean = {
    val res: Boolean = true
    palindrome_helper(list, rev(list), res)
  }

  @tailrec
  private def palindrome_helper(l1: List[Any], l2: List[Any], res: Boolean): Boolean = {
    if (l1.isEmpty || l2.isEmpty) res
    else palindrome_helper(l1.tail, l2.tail, res && l1.head == l2.head)
  }

  private def rev(list: List[Any]): List[Any] = {
    if (list.isEmpty) List()
    else rev(list.tail) ++ List(list.head)
  }
}
