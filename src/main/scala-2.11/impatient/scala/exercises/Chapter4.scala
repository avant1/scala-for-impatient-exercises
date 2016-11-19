package impatient.scala.exercises

class Chapter4 {

  def produceGizmosMapWithDiscount(map: Map[String, Double]): Map[String, Double] = {
    map.map(tuple => (tuple._1, tuple._2 / 100 * 90))
  }

}
