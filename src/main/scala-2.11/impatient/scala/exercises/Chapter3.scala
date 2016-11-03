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
    Array()
  }


}
