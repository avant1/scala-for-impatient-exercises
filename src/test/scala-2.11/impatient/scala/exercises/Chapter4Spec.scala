package impatient.scala.exercises

import impatient.scala.utils.random.Random
import org.specs2.ScalaCheck
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class Chapter4Spec extends Specification with ScalaCheck with Mockito {

  val subject = new Chapter4

  "gizmos with discount producer" should {

    "apply discount to all gizmos in given map" in {
      val input = Map("apple earpods" -> 40D, "bravery" -> Double.MaxValue, "carrot" -> 0.99)
      val expected = Map("apple earpods" -> 36, "bravery" -> Double.MaxValue / 100 * 90, "carrot" -> 0.891)

      subject.produceGizmosMapWithDiscount(input) mustEqual expected

    }

  }


}
