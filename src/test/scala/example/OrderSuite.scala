package example

import org.junit._

class OrderSuite {

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    def loop(pre: A, n: Int): Boolean = {
      if (as.length == 0) false
      else if (n >= as.length) true
      else if (ordered(pre, as(n))) loop(as(n), n + 1)
      else false
    }

    loop(as(0), 1)
  }

  @Test def `is ordered as desc`: Unit = {
    val as = Array(3, 2, 1)
    Assert.assertEquals(true, isSorted(as, (a: Int, b: Int) => {
      a > b
    }))
  }

  @Test def `is ordered as asc`: Unit = {
    val as = Array(1, 2, 3)
    Assert.assertEquals(true, isSorted(as, (a: Int, b: Int) => {
      a < b
    }))
  }

  @Test def `should return false given 1 3 1`: Unit = {
    val as = Array(1, 3, 1)
    Assert.assertEquals(false, isSorted(as, (a: Int, b: Int) => {
      a < b
    }))
  }

}
