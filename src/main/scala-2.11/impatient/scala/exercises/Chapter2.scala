package impatient.scala.exercises

import impatient.scala.utils.print.{ConsolePrinter, Printer}

import scala.annotation.tailrec

class Chapter2 {

  def signum(n: Integer) = {
    if (n > 0)
      1
    else if (n < 0)
      -1
    else 0
  }


  def javaLikeLoop(start: Int)(implicit printer: Printer = ConsolePrinter) = {
    if (start < 0) {
      throw new RuntimeException(s"Cannot loop from negative value $start to 0.")
    }

    (0 to start).reverse.foreach(x => printer.println(x))

  }

  def charsProduct(s: String) = {
    var result = 1L
    for (c <- s) {
      result = result * c.toInt
    }

    if (result == 1) {
      result = 0
    }

    result
  }

  def charsProductWithoutLoop(s: String) = {
    val result = s.map(_.toLong).product

    if (result == 1)
      0L
    else
      result
  }

  private var recursiveCharsProductPartial: Long = 1

  //todo this looks like shit
  @tailrec
  final def recursiveCharsProduct(s: String): Long = {
    if (s.isEmpty) {
      val tmp = recursiveCharsProductPartial
      recursiveCharsProductPartial = 1
      return tmp
    } else if (s.length >= 1) {
      recursiveCharsProductPartial = recursiveCharsProductPartial * s(0).toLong
    }

    recursiveCharsProduct(s.substring(1))
  }


  def pow(base: Int)(power: Int): Double = {
    power match {
      case 0 => 1

      case x if x < 0 =>
        1 / pow(base)(-1 * x)

      case x if x > 0 && x % 2 == 1 =>
        base * pow(base)(x - 1)

      case x if x > 0 && x % 2 == 0 =>
        val tmp = pow(base)(x / 2)
        tmp * tmp

    }

  }


}
