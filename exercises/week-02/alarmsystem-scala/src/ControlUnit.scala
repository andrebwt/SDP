import scala.collection.mutable.ListBuffer

class ControlUnit(sensors: ListBuffer[Sensor]) {


  def this() {
    this(ControlUnit.EMPTY_SENSOR_COLLECTION)
  }

  def pollSensors() {

    if (sensors.isEmpty) println("Cannot poll, no sensors have been added.")

    for (sensor <- sensors) {
      if (sensor.isTriggered) {
        System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)
      }
      else {
        System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
      }
    }
  }
}

object ControlUnit {
  // def apply(sensors: ListBuffer[Sensor]): ControlUnit = new ControlUnit(sensors)
  val EMPTY_SENSOR_COLLECTION = new ListBuffer[Sensor]()
}


// Q3, Responsibilities
// Creates new sensors and adds them to a collection
// Checks which sensors have been triggered and where

// Q4, ControlUnit now takes a collection of sensors in the constructor