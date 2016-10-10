package impatient.scala.utils.print

class AccumulatingPrinter extends Printer {

  private var printedLines: List[String] = List()

  override def println(s: String): Unit = {
    printedLines = s :: printedLines
  }

  def lines = printedLines

  def reset() = printedLines = List()

}
