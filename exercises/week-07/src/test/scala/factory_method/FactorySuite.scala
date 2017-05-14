package factory_method

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FactorySuite extends FunSuite {

  val testProduct = ConcreteCreator.build("xbox")
  val testAlternative = ConcreteCreator.build("playstation")

// Checking libraries are imported correctly


  test("one plus one is two")(assert(1 + 1 == 2))


  test("expected product was built") {
    assert(testProduct.name == "Xbox")
    assert(testAlternative.name == "Playstation")
  }

}
