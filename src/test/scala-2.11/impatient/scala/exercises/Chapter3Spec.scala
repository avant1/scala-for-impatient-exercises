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
      subject.generateRandomArray(5)(random) mustEqual Array[Int](2, 1, 3, 3, 4)

      there were 5.times(random).nextInt(5)
    }

    "should throw exception when input is negative" in {
      subject.generateRandomArray(-42) must throwA[RuntimeException]
    }

  }

  "swap adjacent elements" should {

    "be able to handle empty array" in {
      subject.swapAdjacentElements(Array()) mustEqual Array()
    }

    "be able to handle array containing only one element" in {
      subject.swapAdjacentElements(Array(0)) mustEqual Array(0)
    }

    "swap elements correctly when array contains even number of elements" in {
      subject.swapAdjacentElements(Array(5, 4, 3, 2)) mustEqual Array(4, 5, 2, 3)
    }

    "swap elements correctly when array contains odd number of elements" in {
      subject.swapAdjacentElements(Array(5, 4, 3, 2, 1)) mustEqual Array(4, 5, 2, 3, 1)
    }

  }

  "swap adjacent elements (producing new array)" should {

    "be able to handle empty array" in {
      subject.swapAdjacentElementsAndProduceNewArray(Array()) mustEqual Array()
    }

    "be able to handle array containing only one element" in {
      subject.swapAdjacentElementsAndProduceNewArray(Array(0)) mustEqual Array(0)
    }

    "swap elements correctly when array contains even number of elements" in {
      subject.swapAdjacentElementsAndProduceNewArray(Array(5, 4, 3, 2)) mustEqual Array(4, 5, 2, 3)
    }

    "swap elements correctly when array contains odd number of elements" in {
      subject.swapAdjacentElementsAndProduceNewArray(Array(5, 4, 3, 2, 1)) mustEqual Array(4, 5, 2, 3, 1)
    }

  }

}
