package impatient.scala.exercises

import impatient.scala.utils.print.{ConsolePrinter, Printer}

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
    val result = s.foldLeft(1L)(_ * _)

    if (result == 1)
      0L
    else
      result
  }

  def recursiveCharsProduct(s: String): Long = {
    var result: Long = 1
    if (s.length == 1) {
      result = s(0).toLong
    } else if (s.length > 1) {
      result = s(0).toInt * recursiveCharsProduct(s.substring(1))
    }

    if (result == 1)
      0
    else
      result
  }


}
