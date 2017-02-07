// Model a Traffic Light (TL) using sealed trait(s)
// and case class(es) or case object(s)
// A TL is either Red, Green or Amber

// Using Polymorphism add a methond "next" which returns the next TL in the sequence
// Red -> Green -> Amber -> Red

sealed trait TrafficLight {
  def next: TrafficLight
}
final case object Red extends TrafficLight {
  def next = Green
}
final case object Green extends TrafficLight{
  def next = Amber
}
final case object Amber extends TrafficLight {
  def next = Red
}

