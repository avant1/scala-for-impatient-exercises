package impatient.scala.exercises

import impatient.scala.utils.random._

class Chapter3 {

  def generateRandomArray(n: Int)(implicit random: Random = RealRandom): Array[Int] = {
    if (n < 0) {
      throw new RuntimeException("Cannot generate array of negative length")
    }

    (1 to n map { _ => random.nextInt(n) }).toArray
  }

  def swapAdjacentElements(a: Array[Int]): Array[Int] = {
    val evenKeysWithoutLastOne = a.indices.dropRight(1).filter(x => x % 2 == 0)
    for (k <- evenKeysWithoutLastOne) {
      val tmp = a(k)
      a(k) = a(k + 1)
      a(k + 1) = tmp
    }

    a
  }

  //todo refactor
  def swapAdjacentElementsAndProduceNewArray(a: Array[Int]): Array[Int] = {
    val evenKeysWithoutLastOne = a.indices.dropRight(1).filter(x => x % 2 == 0)
    val partialResult = (for (k <- evenKeysWithoutLastOne) yield (a(k + 1), a(k))) . flatMap(t => Array(t._1, t._2)).toArray

    if (partialResult.length < a.length)
      partialResult ++ Array(a.last)
    else
      partialResult
  }


}
