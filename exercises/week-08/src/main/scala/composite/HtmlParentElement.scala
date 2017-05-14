package composite

case class HtmlParentElement(s: String) extends HtmlTag(s) {

  var startTag: String = new String()
  var endTag: String = new String()

  override def setStartTag(tag: String): Unit = {
    startTag = tag
  }

  override def setEndTag(tag: String): Unit = {
    endTag = tag
  }

  override def generateHtml: Unit = {

    println(startTag)
    getChildren.foreach(_.generateHtml)
    println(endTag)
  }
}
