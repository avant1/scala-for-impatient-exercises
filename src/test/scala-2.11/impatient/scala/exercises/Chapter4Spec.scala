package impatient.scala.exercises

import impatient.scala.utils.print.Printer
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

  "words frequency in a file calculator with sorted map" should {

    "handle empty file gracefully" in {
      subject.countWordsNumbersInStringWithSortedMap("") mustEqual Map()
    }

    "correctly count number of words" in {
      val printer = mock[Printer]

      subject.countWordsNumbersInStringWithSortedMap("foo bar foo")(printer) mustEqual Map("bar" -> 1, "foo" -> 2)

      there was one(printer).println("bar: 1") andThen one(printer).println("foo: 2")
    }

  }

  "words frequency in a file calculator with java.util.TreeMap" should {

    "handle empty file gracefully" in {
      subject.countWordsNumbersInStringWithJavaTreeMap("") mustEqual Map()
    }

    "correctly count number of words" in {
      val printer = mock[Printer]

      subject.countWordsNumbersInStringWithJavaTreeMap("foo bar foo")(printer) mustEqual Map("bar" -> 1, "foo" -> 2)

      there was one(printer).println("bar: 1") andThen one(printer).println("foo: 2")
    }

  }


  "linked hash map iteration order" should {

    "be the same as insertion order" in {

      val printer = mock[Printer]

      subject.buildAndIterateWeekDays((string, int) => printer.println(s"$string: $int"))

      //todo how can this andThen stuff be writted on multiple lines?
      there was one(printer).println("Sunday: 1") andThen one(printer).println("Monday: 2") andThen one(printer).println("Tuesday: 3")
    }


  }


}
