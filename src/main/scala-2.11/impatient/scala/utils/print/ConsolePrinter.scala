package impatient.scala.utils.print

object ConsolePrinter extends Printer{

  override def println(s: String): Unit = scala.Predef.println(s)

}
