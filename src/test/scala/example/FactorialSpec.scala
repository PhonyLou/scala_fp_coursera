package example

import org.junit._

class FactorialSpec {
  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int = {
      if (n == 0) acc
      else loop(acc * n, n - 1)
    }

    loop(1, n)
  }


  @Test def `should return 2 when calculate factorial given 2` = {
    Assert.assertEquals(2, factorial(2))
  }

  @Test def `should return 24 when calculate factorial given 4` = {
    Assert.assertEquals(24, factorial(4))
  }

}
