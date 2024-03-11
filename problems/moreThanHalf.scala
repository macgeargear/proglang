import applySeq.applySeq

object moreThanHalf {
  def moreThanHalf(l1: List[Any], l2: List[Any]): Boolean = {
    if (l1.isEmpty && l2.isEmpty) return false
    var n: Double = l1.length
    var cnt =  solve(l1, l2, 0)
    return cnt >= n/2
  }
  def contain(x: Any, l: List[Any]): Boolean = {
    if (l.isEmpty) false
    else if (l.head.equals(x)) true
    else contain(x, l.tail)
  }
  def solve(l1: List[Any], l2: List[Any], cnt: Double): Double = {
    if (l1.isEmpty || l2.isEmpty) return cnt
    if (contain(l1.head, l2)) return solve(l1.tail, l2, cnt+1)
    else return solve(l1.tail, l2, cnt)
  }

  def main(args: Array[String]): Unit = {
    val l00 = List()
    val l01 = List()
    val l1 = List(1,4,3,2,7,8)
    val l2 = List(2,9,7,1,6,10)
    val l3 = List(12,11,6,5,3,2)
    val l4 = List("1","2","3","4","5")
    val l5 = List("9","7","5","3","1")
    val l6 = List("2","4","6","8","10")
    println(moreThanHalf(l00,l01)) //false
    println(moreThanHalf(l1,l01)) //false
    println(moreThanHalf(l1,l2)) //true เพรำะจำก l1 มี 1,2,7 อยู่ใน l2 ด้วย (ครึ่งหนึ่ง สำมตัว พอดี)
    println(moreThanHalf(l1,l3)) //false จำก l1 มีแค่ 3 กับ 2 ที่อยู่ใน l3 ด้วย (แค่สองตัว)
    println(moreThanHalf(l4,l5)) //true จำก l4 มี “1”,”3”,”5” อยู่ใน l5 ซึ่งเกินครึ่ง (2.5 ตัว)
    println(moreThanHalf(l4,l6)) //false จำก l4 มี “2”,”4” เท่ำนั้นที่อยู่ใน l6 จึงไม่ถึงครึ่งนึง
  }
}
