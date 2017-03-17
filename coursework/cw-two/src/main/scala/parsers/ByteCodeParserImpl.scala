package parsers

import bc._
import java.util

import codes._

class ByteCodeParserImpl extends ByteCodeParser {

  private final val ADD = bytecode("iadd")
  private final val CONST = bytecode("iconst")
  private final val SUB = bytecode("isub")
  private final val MUL = bytecode("imul")
  private final val DIV = bytecode("idiv")
  private final val REM = bytecode("irem")
  private final val NEG = bytecode("ineg")
  private final val INC = bytecode("iinc")
  private final val DEC = bytecode("idec")
  private final val DUP = bytecode("idup")
  private final val SWAP = bytecode("iswap")
  private final val PRINT = bytecode("print")


  /** @inheritdoc */
  def parse(bc: Vector[Byte]): Vector[ByteCode] = {

    var createByte = true
    var returnList= new util.ArrayList[ByteCode]
    for (i <- 0 to bc.size - 1) {
      if (createByte) {
        bc(i) match {
          case ADD => returnList.add(new IaddByteCode(bc(i)))
          case CONST => returnList.add(new IconstByteCode(bc(i), bc(i + 1).toInt)); createByte = false
          case SUB => returnList.add(new IsubByteCode((bc(i))))
          case MUL => returnList.add(new ImulByteCode((bc(i))))
          case DIV => returnList.add(new IdivByteCode((bc(i))))
          case REM => returnList.add(new IremByteCode((bc(i))))
          case NEG => returnList.add(new InegByteCode((bc(i))))
          case INC => returnList.add(new IincByteCode((bc(i))))
          case DEC => returnList.add(new IdecByteCode((bc(i))))
          case DUP => returnList.add(new IdupByteCode((bc(i))))
          case SWAP => returnList.add(new IswapByteCode((bc(i))))
          case PRINT => returnList.add(new IprintByteCode((bc(i))))
          case _ => throw new InvalidBytecodeException("Invalid bytecode provided")
        }
      } else {
        createByte = true
      }
    }
    returnList.toArray.map(_.asInstanceOf[ByteCode]).toVector
  }

}

object ByteCodeParserImpl {
  def apply() : ByteCodeParser = new ByteCodeParserImpl
}
