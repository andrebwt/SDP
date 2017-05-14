package composite

case class HtmlElement(s: String) extends HtmlTag(s) {

  var startTag: String = new String()
  var body: String = new String()
  var endTag: String = new String()

  override def setStartTag(tag: String): Unit = {
    startTag = tag
  }

  override def setEndTag(tag: String): Unit = {
    endTag = tag
  }

  override def generateHtml: Unit = {
    println(startTag + body + endTag)
  }
}
