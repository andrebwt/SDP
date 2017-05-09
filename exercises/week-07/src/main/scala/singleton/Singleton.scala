package singleton

class Singleton (var timesRun: Int) {

  def doStuff = {
      timesRun += 1
      System.out.println("I was run " + this.timesRun + " time(s)")
    }
}

// Holds the static instance of the Singleton
object Singleton {

  private val theOneinstance = new Singleton(0)
  def instance(): Singleton = theOneinstance
}
