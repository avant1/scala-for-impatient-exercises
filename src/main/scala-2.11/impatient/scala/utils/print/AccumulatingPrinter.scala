package impatient.scala.utils.print

class AccumulatingPrinter extends Printer {

  private var printedLines: Array[Any] = Array()

  override def println(s: String): Unit = {
    printedLines = printedLines :+ s
  }

  override def println(i: Int): Unit = {
    printedLines = printedLines :+ i
  }

  def lines = printedLines

}
