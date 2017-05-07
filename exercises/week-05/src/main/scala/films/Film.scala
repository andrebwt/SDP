package films

class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {

  def isDirectedBy(d: Director): Boolean = if (d == director) true else false

  def copy(copyName: String = name, copyYearOfRelease: Int = yearOfRelease,
           copyImdbRating: Double = imdbRating, copyDirector: Director = director): Film = {

  new Film(copyName, copyYearOfRelease, copyImdbRating, copyDirector)

  }

}
