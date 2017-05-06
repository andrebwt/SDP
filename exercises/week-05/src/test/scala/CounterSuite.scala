import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

class CounterSuite extends FunSuite {

  // Checking libraries imported correctly
  test("one plus one is two")(assert(1 + 1 == 2))

  test("inc and dec without parameters work") (assert(new Counter(10).inc.dec.inc.inc.count == 12))


}
