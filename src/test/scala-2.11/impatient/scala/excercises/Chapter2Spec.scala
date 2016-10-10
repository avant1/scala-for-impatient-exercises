package impatient.scala.excercises

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




}
