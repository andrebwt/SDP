import persons._
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

  test("CasePerson created with 2 parameters") {
    val jd3 = new Person("John", "Doe")

    assert(jd3.first == "John")
    assert(jd3.last == "Doe")

  }

  test("CasePerson created with companion object") {
    val jd4 = CasePerson("John Doe")

    assert(jd4.first == "John")
    assert(jd4.last == "Doe")

  }

  test("CasePerson created with case class default apply method") {
    val jd4 = CasePerson("John", "Doe")

    assert(jd4.first == "John")
    assert(jd4.last == "Doe")

  }

}
