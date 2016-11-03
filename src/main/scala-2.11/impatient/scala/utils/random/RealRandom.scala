package impatient.scala.utils.random

object RealRandom extends Random {

  override def nextInt(max: Int): Int = {
    scala.util.Random.nextInt(max)
  }

}
