package parsers

import java.util

import vendor.{Instruction, ProgramParser}

class ProgramParserImpl extends ProgramParser {

  def parse(file: String): InstructionList = {
    import scala.io.Source
    val lines = Source.fromFile(file).getLines.toArray
    parseLines(lines)
  }

  def parseString(string: String): InstructionList = {
    val lines = string.split("\n")
    parseLines(lines)
  }

  def parseLines(lines: Array[String]): InstructionList = {

    var returnList= new util.ArrayList[Instruction]

    for (line <- lines) {
      //var args = new Array[Int]
      val fields = line.split(" ")

      val name = fields(0)

      val args =  fields.drop(1).map(_.toInt).toVector
      returnList.add(new Instruction(name, args))
    }
    returnList.toArray.map(_.asInstanceOf[Instruction]).toVector
  }
}

object ProgramParserImpl {

  def apply() = new ProgramParserImpl

}