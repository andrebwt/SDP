package abstractfactory

case class LondonOrderXMLParser() extends XMLParser {
  override def parse: String = "London Parsing Order XML...\nLondon Order XML Message"
}

case class LondonResponseXMLParser() extends XMLParser {
  override def parse: String = "London Parsing Response XML...\nLondon Response XML Message"
}

case class LondonFeedbackXMLParser() extends XMLParser {
  override def parse: String = "London Parsing Feedback XML...\nLondon Feedback XML Message"
}

case class LondonErrorXMLParser() extends XMLParser {
  override def parse: String = "London Parsing Error XML...\nLondon Error XML Message"
}
