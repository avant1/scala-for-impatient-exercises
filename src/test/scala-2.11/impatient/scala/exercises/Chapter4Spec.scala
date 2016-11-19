package impatient.scala.exercises

import java.io.File
import java.util.Scanner

import impatient.scala.utils.random.Random
import org.specs2.ScalaCheck
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class Chapter4Spec extends Specification with ScalaCheck with Mockito {

  val subject = new Chapter4

  "gizmos with discount producer" should {

    "apply discount to all gizmos in given map" in {
      val input = Map("apple earpods" -> 40D, "bravery" -> Double.MaxValue, "carrot" -> 1D)
      val expected = Map("apple earpods" -> 36, "bravery" -> Double.MaxValue / 100 * 90, "carrot" -> 0.90)

      subject.produceGizmosMapWithDiscount(input) mustEqual expected

    }

  }

  "words frequency in a file calculator" should {

    "handle empty file gracefully" in {
      subject.countWordsNumbersInString("") mustEqual Map()
    }

    "correctly count number of words" in {
      subject.countWordsNumbersInString("foo bar foo") mustEqual Map("foo" -> 2, "bar" -> 1)
    }

  }

  "words frequency in a file calculator with immutable map" should {

    "handle empty file gracefully" in {
      subject.countWordsNumbersInStringWithImmutableMap("") mustEqual Map()
    }

    "correctly count number of words" in {
      subject.countWordsNumbersInStringWithImmutableMap("foo bar foo") mustEqual Map("foo" -> 2, "bar" -> 1)
    }

  }


}
