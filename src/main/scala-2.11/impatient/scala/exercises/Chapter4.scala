package impatient.scala.exercises

import java.util.Scanner
import scala.collection.mutable.{Map => MutableMap}

class Chapter4 {

  def produceGizmosMapWithDiscount(map: Map[String, Double]): Map[String, Double] = {
    map.map(tuple => (tuple._1, tuple._2 / 100 * 90))
  }

  def countWordsNumbersInString(text: String): Map[String, Int] = {
    val scanner = new Scanner(text)
    val mutableMap : MutableMap[String, Int] = MutableMap()
    while (scanner.hasNext) {
      val next = scanner.next()
      mutableMap(next) = mutableMap.getOrElse(next, 0) + 1
    }

    mutableMap.toMap
  }

}
