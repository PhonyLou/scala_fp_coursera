package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0) 1
    else if (c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def loop(left: Int, right: Int, pair: Int, cs: List[Char]): Boolean = {
      if (cs.isEmpty) (left == right) && (pair == left)
      else if (cs.head == '(') loop(left + 1, right, pair, cs.tail)
      else if (cs.head == ')') {
        if (left >= right + 1) loop(left, right + 1, pair + 1, cs.tail)
        else loop(left, right + 1, pair, cs.tail)
      }
      else loop(left, right, pair, cs.tail)
    }

    loop(0, 0, 0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
