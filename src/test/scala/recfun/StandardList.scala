package recfun

import org.junit.{Assert, Test}

class StandardListSuit {

  @Test def `take while` = {
    val list = List(1, 2, 3, 5, 7, 2)
    val l2 = list.takeWhile(i => i < 3)
    Assert.assertEquals(List(1, 2), l2)
  }

}
