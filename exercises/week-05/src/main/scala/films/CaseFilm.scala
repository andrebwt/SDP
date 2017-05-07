package films

// Don't need to define copy and apply methods
case class CaseFilm(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {

  val ageAtFilming = yearOfRelease - director.yearOfBirth

  def isDirectedBy(d: Director): Boolean = if (d == director) true else false

  def highestRating(filmA: Film, filmB: Film): Double = {
    if(filmA.imdbRating > filmB.imdbRating) filmA.imdbRating else filmB.imdbRating
  }
}

object CaseFilm {

  def oldestDirectorAtTheTime(filmA: Film, filmB: Film): Director = {
    if (filmA.ageAtFilming > filmB.ageAtFilming) filmA.director else filmB.director
  }

}