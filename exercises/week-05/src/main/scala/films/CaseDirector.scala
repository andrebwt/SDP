package films

// Don't need to define apply method
case class CaseDirector(val firstName: String, val lastName: String, val yearOfBirth: Int) {

  def name: String = firstName + " " + lastName
}

object CaseDirector {

  def older(dirA: Director, dirB: Director): Director = {

    if(dirA.yearOfBirth < dirB.yearOfBirth) dirA else dirB
  }
}
