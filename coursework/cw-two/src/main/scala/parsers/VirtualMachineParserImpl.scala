package parsers

import java.util

import bc.{ByteCode, ByteCodeValues}
import vm.VirtualMachineParser
import vendor.Instruction

class VirtualMachineParserImpl extends VirtualMachineParser with ByteCodeValues {

  val bytecodeParser = ByteCodeParserImpl()
  val programParser = ProgramParserImpl()

  /** @inheritdoc */
  def parse(file: String): Vector[ByteCode] = {
    parseInstructionList(programParser.parse(file))
  }

  /** @inheritdoc */
  def parseString(str: String): Vector[ByteCode] = {
    parseInstructionList(programParser.parseString(str))
  }

  /**
    * Parses a series of Instructions into a vector of ByteCodes
    * @param instructionList a Vector of Instructions
    */
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
