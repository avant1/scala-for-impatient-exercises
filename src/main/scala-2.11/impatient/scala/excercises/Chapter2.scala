package impatient.scala.excercises

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

  }


}
