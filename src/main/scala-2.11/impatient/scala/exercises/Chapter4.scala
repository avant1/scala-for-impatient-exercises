package impatient.scala.exercises

import java.io.{File, PrintWriter}
import java.util
import java.util.{Calendar, Scanner}

import impatient.scala.utils.print.{ConsolePrinter, Printer}

import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.{SortedMap, mutable}
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
    scanner.close()

    mutableMap.toMap
  }

  def countWordsNumbersInStringWithImmutableMap(text: String): Map[String, Int] = {
    val scanner = new Scanner(text)
    var map : Map[String, Int] = Map()
    while (scanner.hasNext) {
      val next = scanner.next()

      map = map + (next -> (map.getOrElse(next, 0) + 1))
    }
    scanner.close()

    map
  }

  def countWordsNumbersInStringWithSortedMap(text: String)(implicit printer: Printer = ConsolePrinter): Map[String, Int] = {
    val scanner = new Scanner(text)
    var map : SortedMap[String, Int] = SortedMap()
    while (scanner.hasNext) {
      val next = scanner.next()

      map = map + (next -> (map.getOrElse(next, 0) + 1))
    }
    scanner.close()

    for ((k, v) <- map) {
      printer.println(s"$k: $v")
    }

    map.toMap
  }

  def countWordsNumbersInStringWithJavaTreeMap(text: String)(implicit printer: Printer = ConsolePrinter): Map[String, Int] = {
    val scanner = new Scanner(text)
    val map: MutableMap[String, Int] = new util.TreeMap[String, Int]
    while (scanner.hasNext) {
      val next = scanner.next()

      map(next) = map.getOrElse(next, 0) + 1
    }
    scanner.close()

    for ((k, v) <- map) {
      printer.println(s"$k: $v")
    }

    map.toMap
  }

  def buildAndIterateWeekDays(callback: (String, Int) => Unit) {

    val map = new mutable.LinkedHashMap[String, Int]

    map("Sunday") = Calendar.SUNDAY
    map("Monday") = Calendar.MONDAY
    map("Tuesday") = Calendar.TUESDAY
    map("Wednesday") = Calendar.WEDNESDAY
    map("Thursda") = Calendar.THURSDAY
    map("Friday") = Calendar.FRIDAY
    map("Saturday") = Calendar.SATURDAY

    for ((s, i) <- map) {
      callback(s, i)
    }

  }

  def printJavaProperties()(implicit printer: Printer = ConsolePrinter) {
    val props = System.getProperties
    val keys = props.map(_._1)
    val keysLengths = keys.map(_.length)
    val maxLength = keysLengths.max
    val values = props.map(_._2)
    val leftParts = keys.zip(keysLengths).map(t => t._1 + (" " * (maxLength - t._2)))
    val result = leftParts.zip(values).map(t => t._1 + "| " + t._2).mkString("\n")

    printer.println(result)

//    val writer = new PrintWriter(new File("C:\java-properties-table.txt"))
//    try writer.write(result) finally writer.close()

  }

  def minMax(values: Array[Int]): (Int, Int) = {
    if (values.isEmpty) {
      throw new IllegalArgumentException("Cannot detect min nor max value of empty array")
    }

    (values.min, values.max)
  }


}
