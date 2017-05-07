package films

class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {

  def isDirectedBy(d: Director): Boolean = if (d.equals(director)) true else false

}
