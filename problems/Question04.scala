object Question04 {

  def mergesort(l: List[Int]): List[Int] = {

    def merge(l1: List[Int], l2: List[Int], ans: List[Int]): List[Int] = {
      if (l1.isEmpty && l2.isEmpty) return ans
      if (l2.isEmpty) return merge(l1.tail, l2, ans ++ List(l1.head))
      if (l1.isEmpty) return merge(l1, l2.tail, ans ++ List(l2.head))
      if (l1.head > l2.head) return merge(l1, l2.tail, ans ++ List(l2.head))
      merge(l1.tail, l2, ans ++ List(l1.head))
    }

    def split(list: List[Int], l: Int, r: Int, curr: Int, res: List[Int]): List[Int] = {
      if (curr > r) return res
      if (curr >= l) return split(list.tail, l, r, curr+1, res ++ List(list.head))
      split(list.tail, l, r, curr+1, res)
    }

    def mergeSort(l: List[Int], n: Int): List[Int] = {
      if (l.length <= 1) return l
      var m = n/2
      var left = mergeSort(split(l, 0, n/2, 0, List()), n/2)
      var right = mergeSort(split(l, n/2+1, n, 0, List()), n-n/2-1)
      merge(left, right, List())
    }

    mergeSort(l, l.length-1)
  }


}
