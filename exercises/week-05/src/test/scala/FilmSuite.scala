import films._
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

class FilmSuite extends FunSuite {


    val eastwood = new Director("Clint", "Eastwood", 1930)
    val mcTiernan = new Director("John", "McTiernan", 1951)
    val nolan = new Director("Christopher", "Nolan", 1970)
    val someGuy = new Director("Just", "Some Guy", 1990)

    val memento = new Film("Memento", 2000, 8.5, nolan)
    val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
    val inception = new Film("Inception", 2010, 8.8, nolan)

    val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
    val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
    val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
    val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
    val invictus = new Film("Invictus", 2009, 7.4, eastwood)

    val predator = new Film("Predator", 1987, 7.9, mcTiernan)
    val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
    val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
    val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

    // Added Directors
    val jc = new Director("James", "Cameron", 54)
    val pj = Director("Peter", "Jackson", 61)

    // Added Films
    val avatar = Film("Avatar", 2009, 7.8, jc)

  test("Director created correctly with new") {

    assert(jc.firstName == "James")
    assert(jc.lastName == "Cameron")
    assert(jc.yearOfBirth == 54)
  }

  test("Provided tests pass") {
    assert(eastwood.yearOfBirth == 1930) // should be 1930
    assert(dieHard.director.name == "John McTiernan") // should be "John McTiernan"
    assert(invictus.isDirectedBy(nolan) == false) // should be false
  }

  test("Copy method works") {

    val nameChange = highPlainsDrifter.copy("L'homme des hautes plaines")

      assert(nameChange.name == "L'homme des hautes plaines")
      assert(nameChange.yearOfRelease == 1973)
      assert(nameChange.imdbRating == 7.7)
      assert(nameChange.director == eastwood)

  }

  test("Copy method works multiple times without parameters") {

    val copyTest = inception.copy().copy().copy()

      assert(copyTest.name == "Inception")
      assert(copyTest.yearOfRelease == 2010)
      assert(copyTest.imdbRating == 8.8)
      assert(copyTest.director == nolan)

  }

  test("Director created correctly with apply method") {

    assert(pj.firstName == "Peter")
    assert(pj.lastName == "Jackson")
    assert(pj.yearOfBirth == 61)
  }

  test("older method works correctly") {

    assert(Director.older(jc, pj) == jc) // James Cameron is older than Peter Jackson
    assert(Director.older(pj, jc) == jc)

  }

  test("Film created correctly with apply method") {

    assert(avatar.name == "Avatar")
    assert(avatar.yearOfRelease == 2009)
    assert(avatar.imdbRating == 7.8)
    assert(avatar.director == jc)


  }

}
