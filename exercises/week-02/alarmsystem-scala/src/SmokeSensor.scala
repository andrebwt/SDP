import scala.util.Random

class SmokeSensor extends Sensor {

  var batteryPercentage: Int = 100

  override def isTriggered: Boolean = {
    // Drain battery 20% each Poll
    batteryPercentage -= 20

    // Raise alarm 10% of the time
    val chance: Int = Random.nextInt(100) + 1
    if (chance < 11) true else false
  }

  override def getLocation: String = null

  override def getSensorType: String = null

  override def getBatteryPercentage: Double = -1
}
