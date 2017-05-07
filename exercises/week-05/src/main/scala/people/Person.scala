package people

class Person(first: String, last: String)

object Person {

  def apply(name: String): Person = {

    val nameSplit = name.split(" ")
    new Person(nameSplit(0), nameSplit(1))
  }

}
