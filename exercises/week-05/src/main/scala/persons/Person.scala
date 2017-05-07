package persons

class Person(val first: String, val last: String)

object Person {

  def apply(name: String): Person = {

    val parts = name.split(" ")
    new Person(parts(0), parts(1))
  }

}
