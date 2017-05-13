import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FireSensorTest {

  @Test
  public void testThatIsTriggeredReturnsFalse() {
    FireSensor sensor = new FireSensor("Unknown Location");
    boolean isTriggered = sensor.isTriggered();
    assertEquals(false, isTriggered);
  }

  @Test
  public void testThatGetLocationReturnsNull() {
    FireSensor sensor = new FireSensor("Unknown Location");
    String location = sensor.getLocation();
    assertEquals(null, location);
  }

  @Test
  public void testThatGetSensorTypeReturnsNull() {
    FireSensor sensor = new FireSensor("Unknown Location");
    String sensorType = sensor.getSensorType();
    assertEquals(null, sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturnsNegativeOne() {
    FireSensor sensor = new FireSensor("Unknown Location");
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(-1.0, batteryPercentage, 0.01);
  }
}
