object Calculator {

  def sum(a: Int, b: Int): Int = {
    a + b
  }


  def equal(a: Int, b: Int): Boolean = a == b

  def abs(a: Int): Int = if (a > 0) a else a * -1

  def sqrt(a: Int): Double = {
    if (a < 0) {
      throw new RuntimeException(s"Cannot calculate sqrt() of negative number $a")
    }

    Math.sqrt(a)
  }



}
