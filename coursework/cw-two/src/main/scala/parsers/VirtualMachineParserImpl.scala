package parsers

import java.util

import bc.{ByteCode, ByteCodeValues}
import vm.VirtualMachineParser
import vendor.Instruction
/**
  * A `VirtualMachineParser` is used to parse a file of bytecode
  * instructions (as defined by [[vendor.ProgramParser]]). Note,
  * we will use the vendor's parser to parse a file and use the
  * adapter design pattern to write an adapter that will
  * translate a vector of [[vendor.Instruction]] into a
  * vector [[bc.ByteCode]].
  */
class VirtualMachineParserImpl extends VirtualMachineParser with ByteCodeValues {

  val bytecodeParser = ByteCodeParserImpl()
  val programParser = ProgramParserImpl()

  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a file into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program file correctly.
    *
    * @param file the file containing a program
    * @return a vector of bytecodes
    */
  def parse(file: String): Vector[ByteCode] = {
    parseInstructionList(programParser.parse(file))
  }

  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a string into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program string correctly.
    *
    * @param str a string containing a program
    * @return a vector of bytecodes
    */
  def parseString(str: String): Vector[ByteCode] = {
    parseInstructionList(programParser.parseString(str))
  }

  def parseInstructionList(instructionList: Vector[Instruction]): Vector[ByteCode] = {
    val byteList = new util.ArrayList[Byte]

    for (instruction <- instructionList) {
      byteList.add(bytecode(instruction.name))
      for (number <- instruction.args) {
        byteList.add(number.toByte)
      }
    }
    val byteVector = byteList.toArray.map(_.asInstanceOf[Byte]).toVector

    bytecodeParser.parse(byteVector)
  }
}
object VirtualMachineParserImpl {

  def apply() : VirtualMachineParser = new VirtualMachineParserImpl

}
