sealed trait Feline {
  def dinner: Food = {
    this match {
      case Lion() => Antelope
      case Tiger() => TigerFood
      case Panther() => Licorice
      case Cat() => Mice()
    }
  }
}

final case class Lion() extends Feline
final case class Tiger() extends Feline
final case class Panther() extends Feline
final case class Cat() extends Feline


sealed trait Food

final case object Antelope extends Food
final case object TigerFood extends Food
final case object Licorice extends Food
final case class Mice() extends Food



// Another approach. A function just to compute dinner
object Dinner {
  def dinner(feline: Feline): Food =
    feline match {
      case Lion() => Antelope
      case Tiger() => TigerFood
      case Panther() => Licorice
      case Cat() => Mice()
    }
}