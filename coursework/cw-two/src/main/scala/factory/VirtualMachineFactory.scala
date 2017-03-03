package factory

import java.util

import bc.{ByteCodeFactory, ByteCodeParser}
import vendor.{Instruction, ProgramParser}
import vm.{VirtualMachine, VirtualMachineParser}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  */
object VirtualMachineFactory {
  // TODO
  def byteCodeFactory: ByteCodeFactory = ???

  // TODO
  def vendorParser: ProgramParser = new ProgramParserImpl

  // TODO
  def byteCodeParser: ByteCodeParser = ???

  // TODO
  def virtualMachineParser: VirtualMachineParser = ???

  // TODO
  def virtualMachine: VirtualMachine = ???
}

class ProgramParserImpl extends ProgramParser {

  def parse(file: String): InstructionList = {

    import scala.io.Source

    var returnList= new util.ArrayList[Instruction]

    val lines = Source.fromFile(file).getLines

    for (line <- lines) {
      //var args = new Array[Int]
      val fields = line.split(" ")

      val name = fields(0)

      val args =  fields.drop(1).map(_.toInt).toVector
      returnList.add(new Instruction(name, args))
    }
    returnList.toArray.map(_.asInstanceOf[Instruction]).toVector
  }

  def parseString(string: String): InstructionList = ???
}