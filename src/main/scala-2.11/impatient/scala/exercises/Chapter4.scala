package impatient.scala.exercises

import java.util.Scanner
import impatient.scala.utils.print.{ConsolePrinter, Printer}
import scala.collection.SortedMap
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

  def countWordsNumbersInStringWithImmutableMap(text: String): Map[String, Int] = {
    val scanner = new Scanner(text)
    var map : Map[String, Int] = Map()
    while (scanner.hasNext) {
      val next = scanner.next()

      map = map + (next -> (map.getOrElse(next, 0) + 1))
    }

    map
  }

  def countWordsNumbersInStringWithSortedMap(text: String)(implicit printer: Printer = ConsolePrinter): Map[String, Int] = {
    val scanner = new Scanner(text)
    var map : SortedMap[String, Int] = SortedMap()
    while (scanner.hasNext) {
      val next = scanner.next()

      map = map + (next -> (map.getOrElse(next, 0) + 1))
    }

    for ((k, v) <- map) {
      printer.println(s"$k: $v")
    }

    map.toMap
  }

}
