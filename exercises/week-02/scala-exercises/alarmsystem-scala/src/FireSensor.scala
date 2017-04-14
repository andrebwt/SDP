import scala.util.Random

class FireSensor extends Sensor {

  override def isTriggered: Boolean = {
    val r: Int = Random.nextInt(100) + 1
    if (r < 6) true else false
  }

  override def getLocation: String = null

  override def getSensorType: String = null

  override def getBatteryPercentage: Double = -1
}
