package films

class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {

  val ageAtFilming = yearOfRelease - director.yearOfBirth

  def isDirectedBy(d: Director): Boolean = if (d == director) true else false

  def copy(copyName: String = name, copyYearOfRelease: Int = yearOfRelease,
           copyImdbRating: Double = imdbRating, copyDirector: Director = director): Film = {

    new Film(copyName, copyYearOfRelease, copyImdbRating, copyDirector)
  }
}

object Film {

  def apply(name: String, yearOfRelease: Int, imdbRating: Double, director: Director): Film = {
    new Film(name, yearOfRelease, imdbRating, director)
  }

  def highestRating(filmA: Film, filmB: Film): Double = {
    if(filmA.imdbRating > filmB.imdbRating) filmA.imdbRating else filmB.imdbRating
  }

  def oldestDirectorAtTheTime(filmA: Film, filmB: Film): Director = {
    if (filmA.ageAtFilming > filmB.ageAtFilming) filmA.director else filmB.director
  }
}
