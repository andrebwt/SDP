import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

class CounterSuite extends FunSuite {

  // Checking libraries are imported correctly
  test("one plus one is two")(assert(1 + 1 == 2))

  test("inc without parameter works") (assert(new Counter(10).inc.dec.inc.inc.count == 12))

}
