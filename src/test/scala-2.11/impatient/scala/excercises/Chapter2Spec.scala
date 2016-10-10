package impatient.scala.excercises

import impatient.scala.utils.print.AccumulatingPrinter
import org.specs2.mutable.Specification
import org.specs2.specification.BeforeAfter

class Chapter2Spec extends Specification  with BeforeAfter {

  val subject = new Chapter2

  val printer = new AccumulatingPrinter

  override def before: Any = {
    printer.reset()
  }


  "signum" should {

    "return 1 for positive argument" in {
      subject.signum(5) mustEqual 1
      subject.signum(1) mustEqual 1
    }

    "return -1 for negative argument" in {
      subject.signum(-5) mustEqual -1
      subject.signum(-999) mustEqual -1
    }

    "return 0 for zero argument" in {
      subject.signum(0) mustEqual 0
    }


  }

  "java like loop" should {

    "print numbers from positive N to 0" in {
      subject.javaLikeLoop(10)(printer)
      val expectedResult = (0 to 10).reverse.toList

      printer.lines mustEqual expectedResult
    }

    "print no numbers if argument equals to 0" in {
      subject.javaLikeLoop(0)(printer)

      printer.lines mustEqual List()
    }

    "throw exception if argument is negative" in {
      subject.javaLikeLoop(-5)(printer) must throwA[RuntimeException]
    }

  }


  override def after: Any = {

  }

}
