class CalculatorSpec extends org.specs2.mutable.Specification {

  "calculator should " should {
    "sum positive numbers" in {
      Calculator.sum(5, 6) mustEqual 11
    }
    "sum negative numbers" in {
      Calculator.sum(-5, -4) mustEqual -9
    }
    "detect unequality of integers" in {
      Calculator.equal(5, 6) must beFalse
    }

    "detect equality of integers" in {
      Calculator.equal(-1, -1) must beTrue
    }

    "calculate abs() from positive numbers" in {
      Calculator.abs(5) mustEqual 5
    }
    "calculate abs() from negative numbers" in {
      Calculator.abs(-5) mustEqual 5
    }

    "throw exception on square root of negative number" in {
      Calculator.sqrt(-4) must throwA[RuntimeException]
    }
    "calculate square root of number" in {
      Calculator.sqrt(9) mustEqual 3
    }
    "calculate square root of number without integer square root result" in {
      Calculator.sqrt(10) mustEqual 3.1622776601683795
    }

  }

}
