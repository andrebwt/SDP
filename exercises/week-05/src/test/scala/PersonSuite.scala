import people.{Person, _}
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

class PersonSuite extends FunSuite {

  test("Person created with 2 parameters") {
    val jd = new Person("John", "Doe")

    assert(jd.first == "John")
    assert(jd.last == "Doe")

  }

  test("Person created with single parameter") {
    val jd2 = Person("John Doe")

    assert(jd2.first == "John")
    assert(jd2.last == "Doe")

  }

}
