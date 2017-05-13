import scala.util.Random

class FireSensor(val location: String = "Unknown Location") extends Sensor {

  val sensorType: String = "Fire Sensor"
  var batteryPercentage: Int = 100

  override def isTriggered: Boolean = {
    // Drain Battery 10% each Poll
    batteryPercentage -= 10

    // Raise alarm 5% of the time
    val chance: Int = Random.nextInt(100) + 1
    if (chance < 6) true else false
  }

  override def getLocation: String = location

  override def getSensorType: String = sensorType

  override def getBatteryPercentage: Double = batteryPercentage
}
