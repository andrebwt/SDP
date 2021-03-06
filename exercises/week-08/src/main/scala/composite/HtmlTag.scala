package composite

import scala.collection.mutable.ListBuffer

abstract class HtmlTag(tagName: String) {

  var children = new ListBuffer[HtmlTag]()
  var body: String

  def getTagName: String = tagName

  def setStartTag(tag: String)

  def setEndTag(tag: String)

  def setTagBody(tagBody: String) = {
    body = tagBody
  }

  def addChildTag(htmlTag: HtmlTag) = children += htmlTag

  def removeChildTag(htmlTag: HtmlTag) = children -= htmlTag

  def getChildren: ListBuffer[HtmlTag] = children

  def generateHtml
}