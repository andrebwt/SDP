import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

class CounterSuite extends FunSuite {

  // Checking libraries imported correctly
  test("one plus one is two")(assert(1 + 1 == 2))

  test("Counter inc and dec work without parameters") (assert(new Counter(10).inc().dec().inc().inc().count == 12))
  test("Counter inc and dec work with parameters") (assert(new Counter(10).inc(4).dec(3).inc(2).inc(1).count == 14))

  test("CaseCounter inc and dec work without parameters") (assert(new CaseCounter(10).inc().dec().inc().inc().count == 12))
  test("CaseCounter inc and dec work with parameters") (assert(new CaseCounter(10).inc(4).dec(3).inc(2).inc(1).count == 14))

  test("CaseCounter copy method works") {
    val testCounter = new CaseCounter(10)
    val testCounter2 = testCounter.copy(9).inc(2)
    assert(testCounter2.count == 11)
  }

  test("Counter adjust method works") {
    val testAdder = new Adder(5)
    val testCounter3 = new Counter(10).adjust(testAdder)

    assert(testCounter3.count == 15)
  }

  test("CaseCounter adjust method works") {
    val testAdder2 = new Adder(5)
    val testCounter4 = new Counter(10).adjust(testAdder2)

    assert(testCounter4.count == 15)
  }

}
