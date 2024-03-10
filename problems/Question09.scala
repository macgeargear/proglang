import scala.annotation.tailrec

object Question09 {
  //val tape = List('C','H','A','R')
  def turingStep(f: Char => Char, tape: List[Char], n: Int): List[Char] = {
    @tailrec
    def step(f: Char => Char, tape: List[Char], n: Int, res: List[Char]): List[Char] = {
      if (tape.isEmpty) return res
      else if (n>0) step(f, tape.tail, n-1, res ++ List(f(tape.head)))
      else step(f, tape.tail, n-1, res++List(tape.head))
    }
    var res = List()
    step(f, tape, n, res)
  }


}
