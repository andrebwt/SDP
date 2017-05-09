package singleton

import scala.collection.mutable.ListBuffer
import scala.util.Random

object SingletonProtected {
  // Used to slow down 1st thread
  private[singleton] var firstThread: Boolean = true
  private var firstInstance: SingletonProtected = null

  // Created to keep users from instantiation
  // Only Singleton will be able to instantiate this class
  // We could make getInstance a synchronized method to force
  // every thread to wait its turn. That way only one thread
  // can access a method at a time. This can really slow everything
  // down though
  // public static synchronized Singleton getInstance()
  def getInstance: SingletonProtected = {
    if (firstInstance == null) {
      // This is here to test what happens if threads try
      // to create instances of this class
      if (firstThread) {
        firstThread = false
        try {
          Thread.currentThread
          Thread.sleep(1000)
        }
        catch {
          case e: InterruptedException => {
            e.printStackTrace()
          }
        }
      }
      // Here we just use synchronized when the first object
      // is created
      classOf[SingletonProtected] synchronized {
        if (firstInstance == null) {
          // If the instance isn't needed it isn't created
          // This is known as lazy instantiation
          firstInstance = new SingletonProtected
          // Shuffle the letters in the list
          Random.shuffle(firstInstance.letterList)
        }
      }
    }
    // Under either circumstance this returns the instance
    firstInstance
  }
}

class SingletonProtected private() {
  private[singleton] val scrabbleLetters: Array[String] =
    Array("a", "a", "a", "a", "a", "a", "a", "a", "a", "b", "b", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h", "h", "i", "i", "i", "i", "i", "i", "i", "i", "i", "j", "k", "l", "l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n", "o", "o", "o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r", "r", "r", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "u", "u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z")
  private var letterList: ListBuffer[String] = scrabbleLetters.to[ListBuffer]

  def getLetterList: ListBuffer[String] = SingletonProtected.firstInstance.letterList

  def getTiles(howManyTiles: Int): ListBuffer[String] = {
    // Tiles to be returned to the user
    val tilesToSend = new ListBuffer[String]
    // Cycle through the LinkedList while adding the starting
    // Strings to the to be returned List while deleting
    // them from letterList
    var i: Int = 0
    while (i <= howManyTiles) {

      var tile = SingletonProtected.firstInstance.letterList(0)

      tilesToSend += tile
      SingletonProtected.firstInstance.letterList -= tile

      i += 1;
    }
    // Return the number of letter tiles requested
    tilesToSend
  }
}
