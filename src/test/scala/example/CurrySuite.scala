package example

import org.junit.Test

class CurrySuite {

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a, b)
  }

  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)

  def compose[A, B, C](f: B => C, g: A => B): A => C =
    (a: A) => f(g(a))

  def f(a: Int) = a + 1
  def g(b: Int) = b * 2

  @Test def `uuu` = {
    val r = f _ compose g
    println(r(1))

    val r2 = f _ andThen g
    println(r2(1))
  }
}
