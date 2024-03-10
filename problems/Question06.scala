object Question06 {
  def myMap(f: Int => Int)(list: List[Int]): List[Int] = {
    if (list.isEmpty) List()
    else f(list.head) :: myMap(f)(list.tail)
  }
}
