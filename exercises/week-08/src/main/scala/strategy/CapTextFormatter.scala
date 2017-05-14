package strategy

// TODO

case class CapTextFormatter() extends TextFormatter {
  override def format(text: String): Unit = println(text.toUpperCase)
}
