package example

import org.junit._

class FpSuite {

  def test(i: Int) = {
    println(s"hello $i")
  }

  @Test def `xxxxxx`: Unit = {
    val x = true
    val y = true
    Assert.assertEquals(true, add(x, y))
  }

  @Test def `xxxxxx2`: Unit = {
    val x = true
    val y = false
    Assert.assertEquals(false, add(x, y))
  }

  @Test
  def `xxxxxx3`: Unit = {
    val x = false
    val y = true
    Assert.assertEquals(false, add(x, y))
  }

  @Test
  def `xxxxxx4`: Unit = {
    val x = false
    val y = false
    Assert.assertEquals(false, add(x, y))
  }

  def add(x: Boolean, y: => Boolean): Boolean = if (x) y else false

  def or(x: Boolean, y: => Boolean) = if (x) x else y

  @Test def `or1`: Unit = {
    val x = true
    val y = true
    Assert.assertEquals(true, or(x, y))
  }

  @Test def `or2`: Unit = {
    val x = true
    val y = false
    Assert.assertEquals(true, or(x, y))
  }

  @Test
  def `or3`: Unit = {
    val x = false
    val y = true
    Assert.assertEquals(true, or(x, y))
  }

  @Test
  def `or4`: Unit = {
    val x = false
    val y = false
    Assert.assertEquals(false, or(x, y))
  }
}
