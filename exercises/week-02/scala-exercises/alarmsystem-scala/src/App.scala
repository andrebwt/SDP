import java.io.IOException
import java.util.Scanner
import scala.collection.mutable.ListBuffer


object App {
  private val EXIT: String = "exit"
  private val POLL: String = "poll"

  @throws[IOException]
  def main(args: Array[String]) {

    val testSensors = new ListBuffer[Sensor]()
    testSensors += new FireSensor()
    testSensors += new SmokeSensor()

    //val controlUnit: ControlUnit = new ControlUnit
    val controlUnit: ControlUnit = new ControlUnit(testSensors)

    val scanner: Scanner = new Scanner(System.in)
    var input: String = ""
    while (input != EXIT) {
      println("Type \"poll\" to poll all sensors once or \"exit\" to exit")
      input = scanner.nextLine
      if (input == POLL) {
        controlUnit.pollSensors()
      }
    }
  }
}
