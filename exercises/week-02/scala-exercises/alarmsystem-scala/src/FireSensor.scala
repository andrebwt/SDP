import scala.util.Random

class FireSensor extends Sensor {

  var batteryPercent: Int = 100

  override def isTriggered: Boolean = {
    // Drain Battery 10% each Poll
    batteryPercent -= 10

    // Raise alarm 5% of the time
    val r: Int = Random.nextInt(100) + 1
    if (r < 6) true else false
  }

  override def getLocation: String = null

  override def getSensorType: String = null

  override def getBatteryPercentage: Double = -1
}
