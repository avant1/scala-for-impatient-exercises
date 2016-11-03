package impatient.scala.utils.random

class PredefinedRandom extends Random {

  private var randomSource = Array[Int]()

  def seed(values: Array[Int]) = {
    randomSource = values
  }

  override def nextInt(max: Int): Int = {
    val nextInt = randomSource.head
    if (nextInt > max) {
      throw new RuntimeException(s"Next predefined random number $nextInt is larger than max allowed value of $max. Given random source seems to be invalid")
    }

    randomSource = randomSource.drop(1)

    nextInt
  }

}
