package singleton

class SingletonLazy (var timesRun: Int) {

  def doStuff = {
    timesRun += 1
    System.out.println("I was run " + this.timesRun + " time(s)")
  }
}

// Holds the static instance of the Singleton
// Lazy initialisation, constructs on demand
// You may want to Lazy initialise for thread safety
object SingletonLazy {

  private var theOneinstance: SingletonLazy = null

  def instance(): SingletonLazy = {

    if(theOneinstance != null) theOneinstance else {
      theOneinstance = new SingletonLazy(0)
      theOneinstance
    }
  }
}