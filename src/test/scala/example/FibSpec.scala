package example

import org.junit._

class FibSpec {

  def fib(n: Int): Int = {
    def loop(pre2: Int, pre1: Int, i: Int): Int = {
      if (n == 1) 0
      else if (n == 2) 1
      else if (i < n) loop(pre1, pre2 + pre1, i + 1)
      else pre2
    }

    loop(0, 1, 1)
  }


  @Test def `d d` = {
    Assert.assertEquals(0, fib(1))
    Assert.assertEquals(1, fib(2))
    Assert.assertEquals(1, fib(3))
    Assert.assertEquals(2, fib(4))
    Assert.assertEquals(3, fib(5))
    Assert.assertEquals(5, fib(6))
    Assert.assertEquals(8, fib(7))
  }
}
