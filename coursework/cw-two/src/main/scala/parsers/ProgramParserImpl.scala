package parsers

import java.util

import vendor.{Instruction, ProgramParser}
import bc.{ByteCodeValues, InvalidBytecodeException}

class ProgramParserImpl extends ProgramParser with ByteCodeValues {

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

    val returnList = new util.ArrayList[Instruction]

    for (line <- lines) {
      //var args = new Array[Int]
      val fields = line.split(" ")
      val name = fields(0)

      try {
        fields.drop(1).map(_.toInt)
      } catch {
        case e: NumberFormatException => throw new IllegalArgumentException("Constant must be an integer. '"
          + fields.drop(1)(0) + "' is not an integer.")
      }

      val args = fields.drop(1).map(_.toInt).toVector

      if (names.contains(fields(0)) && args.forall(a => a.isInstanceOf[Int])) {
        returnList.add(new Instruction(name, args))
      }
      else {
        throw new InvalidBytecodeException("Invalid bytecode provided")
      }
    }
    returnList.toArray.map(_.asInstanceOf[Instruction]).toVector
  }
}

object ProgramParserImpl {

  def apply() : ProgramParser = new ProgramParserImpl

}
