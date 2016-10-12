package impatient.scala.exercises

import impatient.scala.utils.print.AccumulatingPrinter
import org.scalacheck.Gen
import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

class Chapter2Spec extends Specification with ScalaCheck {

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

    "print zero if argument equals to 0" in {
      val printer = new AccumulatingPrinter
      subject.javaLikeLoop(0)(printer)

      printer.lines mustEqual Array(0)
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
    "of 'Hello' must be equal to 9415087488L" in {
      subject.recursiveCharsProduct("Hello") mustEqual 9415087488L
    }
  }

  "pow" should {

    "be equal to 1 if power equals 0 for any base" in {
      subject.pow(0)(0) mustEqual 1F
      subject.pow(50)(0) mustEqual 1F
      subject.pow(-42)(0) mustEqual 1F
    }

    "calculate correct value when base is positive and power is positive" in {
      subject.pow(5)(2) mustEqual 25F
      subject.pow(4)(3) mustEqual 64F
      subject.pow(2)(5) mustEqual 32F
    }

    "calculate correct value when base is negative and power is positive" in {
      subject.pow(-4)(3) mustEqual -64F
      subject.pow(-2)(5) mustEqual -32F
    }

    "return positive number for negative base and positive and odd power" in {
      subject.pow(-5)(2) mustEqual 25F
      subject.pow(-1)(6) mustEqual 1F
    }

    "calculate correct value when power is negative and base is negative too" in {
      subject.pow(-2)(-2) mustEqual 0.25
      subject.pow(-3)(-3) mustEqual -1F/27
      subject.pow(-4)(-4) mustEqual 1F/(16*16)
    }

    "calculate correct value when power is positive and base is negative" in {
      subject.pow(-2)(2) mustEqual 4
      subject.pow(-3)(3) mustEqual -27
      subject.pow(-4)(4) mustEqual 16*16F
    }

    "pass scalacheck set of input" in {
      prop { (base: Int, power: Int) => subject.pow(base)(power) mustEqual Math.pow(base, power) }
    }

  }


}
