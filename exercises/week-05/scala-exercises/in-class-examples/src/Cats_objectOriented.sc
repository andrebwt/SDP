// Only use an object when there's just one
// () because you need a constructor
// Feline at root and Lion, Tiger, Panther and Cat as subtypes

// Add a method "dinner" ->
// Lions -> Antelope
// Tigers -> Tiger Food
// Panthers -> Licorice
// Cats -> Mice

// Implement the Food as a sealed trait and case object

// Start by using polymorphism
// Learn the pattern, repeat the pattern

sealed trait Feline {
  def dinner: Food
}

final case class Lion() extends Feline {
  def dinner = Antelope
}
final case class Tiger() extends Feline {
  def dinner = TigerFood
}
final case class Panther() extends Feline {
  def dinner = Licorice
}
final case class Cat() extends Feline {
  def dinner = Mice()
}

sealed trait Food

final case object Antelope extends Food
final case object TigerFood extends Food
final case object Licorice extends Food
final case class Mice() extends Food