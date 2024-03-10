package Lecture02_HigherOrderAndCurrying

object SumOrProd {
  private def cal(f: Int => Int)(isSum: Boolean, a: Int, b: Int): Int = {
    if (a>b) 0
    else if (isSum) f(a) + cal(f)(isSum, a+1, b)
    else f(a) * cal(f)(isSum, a+1, b)
  }
  private def square(a: Int): Int = a*a

  def main(args: List[String]): Unit = {
    val isSum = true
    println(cal(square)(isSum, 1, 10))
  }
}
