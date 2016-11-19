package impatient.scala.exercises

import java.io.File
import java.util.Scanner

class Chapter4 {

  def produceGizmosMapWithDiscount(map: Map[String, Double]): Map[String, Double] = {
    map.map(tuple => (tuple._1, tuple._2 / 100 * 90))
  }

  def countWordsNumberInFile(file: File)(implicit scanner: Scanner = new Scanner(file)): Map[String, Int] = {
    Map()
  }

}
