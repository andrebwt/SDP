package composite

import scala.collection.mutable.ListBuffer

abstract class HtmlTag(tagName: String) {

  var children = new ListBuffer[HtmlTag]()


  def getTagName: String = tagName

  def setStartTag(tag: String)

  def setEndTag(tag: String)

  def setTagBody(tagBody: String) = tagBody

  def addChildTag(htmlTag: HtmlTag) = children += htmlTag

  def removeChildTag(htmlTag: HtmlTag) = children -= htmlTag

  def getChildren: ListBuffer[HtmlTag] = children

  def generateHtml
}