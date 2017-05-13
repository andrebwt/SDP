import scala.util.Random

class SmokeSensor(val location: String = "Unknown Location") extends Sensor {

  val sensorType: String = "Smoke Sensor"
  var batteryPercentage: Int = 100

  override def isTriggered: Boolean = {
    // Drain battery 20% each Poll
    batteryPercentage -= 20

    // Raise alarm 10% of the time
    val chance: Int = Random.nextInt(100) + 1
    if (chance < 11) true else false
  }

  override def getLocation: String = location

  override def getSensorType: String = sensorType

  override def getBatteryPercentage: Double = batteryPercentage
}
