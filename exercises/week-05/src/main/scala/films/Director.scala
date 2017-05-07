package films

class Director(val firstName: String, val lastName: String, val yearOfBirth: Int) {

  def name: String = firstName + " " + lastName

}

object Director {

  def apply(firstName: String,  lastName: String, yearOfBirth: Int): Director = {

    new Director(firstName, lastName, yearOfBirth)

  }

  def older(dirA: Director, dirB: Director): Director = {

    if(dirA.yearOfBirth < dirB.yearOfBirth) dirA else dirB

  }



}
