package impatient.scala.utils.random

class RealRandom extends Random {

  override def nextInt(max: Int): Int = {
    scala.util.Random.nextInt(max)
  }

}
