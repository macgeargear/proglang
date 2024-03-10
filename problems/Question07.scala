object Question07 {

  def myFilter(f: Int => Boolean)(list: List[Int]): List[Int] = {
    if (list.isEmpty) List()
    else if (f(list.head)) list.head :: myFilter(f)(list.tail)
    else myFilter(f)(list.tail)
  }
}
