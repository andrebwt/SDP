package abstractfactory

case class LondonOrderXMLParser() extends XMLParser {
  override def parse: String = "London Parsing Order XML..."
}

case class LondonResponseXMLParser() extends XMLParser {
  override def parse: String = "London Response XML Message"
}

case class LondonFeedbackXMLParser() extends XMLParser {
  override def parse: String = "London Feedback XML Message"
}

case class LondonErrorXMLParser() extends XMLParser {
  override def parse: String = "London Error XML Message"
}
