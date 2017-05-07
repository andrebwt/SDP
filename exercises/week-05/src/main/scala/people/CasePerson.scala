package people

case class CasePerson(val first: String, val last: String)

object CasePerson {

  // Additional apply method
  // A default apply method is provided by the case class
  def apply(name: String): CasePerson = {

    val parts = name.split(" ")
    new CasePerson(parts(0), parts(1))
  }

}