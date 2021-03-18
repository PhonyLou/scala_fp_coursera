package example

import example.List.{lengthLeft, productLeft, sumLeft}
import org.junit.{Assert, Test}

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(is: List[Int]): Int = is match {
    case Nil => 0
    case Cons(head, tail) => head + sum(tail)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1
    case Cons(0.0, _) => 0.0
    case Cons(head, tail) => head * product(tail)
  }

  def sum2(is: List[Int]): Int = {
    def loop(acc: Int, xs: List[Int]): Int = xs match {
      case Nil => acc
      case Cons(head, tail) => loop(acc + head, tail)
    }

    loop(0, is)
  }

  def tail[A](xs: List[A]): List[A] = xs match {
    case Nil => Nil
    case Cons(_, ts) => ts
  }

  def setHead[A](x: A, xs: List[A]): List[A] = Cons(x, xs)

  def drop[A](l: List[A], n: Int): List[A] = {
    if (n == 0) l
    else drop(tail(l), n - 1)
  }

  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(head, tail) if f(head) => dropWhile(tail, f)
    case _ => l
  }

  def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
    case Nil => a2
    case Cons(head, tail) => Cons(head, append(tail, a2))
  }

  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(h, t) => foldLeft(t, f(z, h))(f)
  }

  def sumLeft(xs: List[Int]) = foldLeft(xs, 0)(_ + _)

  def productLeft(xs: List[Int]) = foldLeft(xs, 1)(_ * _)

  def lengthLeft(xs: List[Int]) = foldLeft(xs, 0)((b, _) => b + 1)

}

class ListSuit {
  @Test def `sum left` = {
    val valueActual = sumLeft(Cons(1, Cons(2, Cons(3, Nil))))
    Assert.assertEquals(6, valueActual)
  }

  @Test def `product left` = {
    val valueActual = productLeft(Cons(1, Cons(2, Cons(3, Nil))))
    Assert.assertEquals(6, valueActual)
  }

  @Test def `length left` = {
    val valueActual = lengthLeft(Cons(1, Cons(2, Cons(3, Nil))))
    Assert.assertEquals(3, valueActual)
  }

}
