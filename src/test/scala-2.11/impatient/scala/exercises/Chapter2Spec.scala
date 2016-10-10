package impatient.scala.exercises

import impatient.scala.utils.print.AccumulatingPrinter
import org.specs2.mutable.Specification

class Chapter2Spec extends Specification {

  val subject = new Chapter2

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
      val printer = new AccumulatingPrinter
      subject.javaLikeLoop(10)(printer)
      val expectedResult = (0 to 10).reverse.toArray

      printer.lines mustEqual expectedResult
    }

    "print no numbers if argument equals to 0" in {
      val printer = new AccumulatingPrinter
      subject.javaLikeLoop(0)(printer)

      printer.lines mustEqual Array()
    }

    "throw exception if argument is negative" in {
      val printer = new AccumulatingPrinter
      subject.javaLikeLoop(-5)(printer) must throwA[RuntimeException]
    }

  }

  "chars product" should {
    "be equal to 0 for empty input string" in {
      subject.charsProduct("") mustEqual 0
    }

    "of 'Hello' must be equal to 9415087488L" in {
      subject.charsProduct("Hello") mustEqual 9415087488L
    }
  }

  "chars product without loop" should {
    "be equal to 0 for empty input string" in {
      subject.charsProductWithoutLoop("") mustEqual 0
    }

    "of 'Hello' must be equal to 9415087488L" in {
      subject.charsProductWithoutLoop("Hello") mustEqual 9415087488L
    }
  }

  "recursive chars product" should {
//    "be equal to 0 for empty input string" in {
//      subject.recursiveCharsProduct("") mustEqual 0
//    }

    "of 'Hello' must be equal to 9415087488L" in {
      subject.recursiveCharsProduct("Hello") mustEqual 9415087488L
    }
  }

}
