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
    0
  }


}
