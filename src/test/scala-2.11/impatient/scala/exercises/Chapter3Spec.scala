package impatient.scala.exercises

import impatient.scala.utils.print.AccumulatingPrinter
import impatient.scala.utils.random.Random
import org.scalacheck.Gen
import org.scalacheck.Prop.forAll
import org.specs2.ScalaCheck
import org.specs2.matcher.SignificantFigures
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class Chapter3Spec extends Specification with ScalaCheck with Mockito {

  val subject = new Chapter3

  "random array generation" should {

    "return empty array for 0 as input" in {
      subject.generateRandomArray(0) mustEqual Array[Int]()
    }

    "should generate random array in given borders of given size" in {
      val random = mock[Random]
      random.nextInt(5) returns 2 thenReturns 1 thenReturns 3 thenReturns 3 thenReturns 4
      there were three(random).nextInt(5)

      subject.generateRandomArray(3)(random) mustEqual Array[Int](2, 1, 3, 3, 4)
    }

    "should throw exception when input is negative" in {
      subject.generateRandomArray(-42) must throwA[RuntimeException]
    }

  }

}
