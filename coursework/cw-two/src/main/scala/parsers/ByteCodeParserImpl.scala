package parsers

import bc._
import java.util

import codes._

class ByteCodeParserImpl extends ByteCodeParser {

  private final val ADD = bytecode.getOrElse("iadd",0)
  private final val CONST = bytecode.getOrElse("iconst",0)
  private final val SUB = bytecode.getOrElse("isub",0)
  private final val MUL = bytecode.getOrElse("imul",0)
  private final val DIV = bytecode.getOrElse("idiv",0)
  private final val REM = bytecode.getOrElse("irem",0)
  private final val NEG = bytecode.getOrElse("ineg",0)
  private final val INC = bytecode.getOrElse("iinc",0)
  private final val DEC = bytecode.getOrElse("idec",0)
  private final val DUP = bytecode.getOrElse("idup",0)
  private final val SWAP = bytecode.getOrElse("iswap",0)
  private final val PRINT = bytecode.getOrElse("print",0)


  /**
    * Parses a vector of `Byte` into a vector of `ByteCode`.
    *
    * You should use [[ByteCodeValues.bytecode]] to help translate
    * the individual `Byte`s into a correponding [[ByteCode]].
    *
    * @param bc a vector of bytes representing bytecodes
    * @return a vector of `ByteCode` objects
    */
  def parse(bc: Vector[Byte]): Vector[ByteCode] = {

    var returnList= new util.ArrayList[ByteCode]
    for (byte <- bc) {
        byte match {
          case ADD  => returnList.add(new IaddByteCode(byte))
          case CONST  => returnList.add(new IconstByteCode(byte, 0))
          case SUB  => returnList.add(new IsubByteCode(byte))
          case MUL  => returnList.add(new ImulByteCode(byte))
          case DIV  => returnList.add(new IdivByteCode(byte))
          case REM  => returnList.add(new IremByteCode(byte))
          case NEG  => returnList.add(new InegByteCode(byte))
          case INC  => returnList.add(new IincByteCode(byte))
          case DEC  => returnList.add(new IdecByteCode(byte))
          case DUP  => returnList.add(new IdupByteCode(byte))
          case SWAP  => returnList.add(new IswapByteCode(byte))
          case PRINT  => returnList.add(new IprintByteCode(byte))
          case _ => throw new InvalidBytecodeException("Invalid bytecode provided")
        }
    }
    returnList.toArray.map(_.asInstanceOf[ByteCode]).toVector
  }

}

object ByteCodeParserImpl {

  def apply() = new ByteCodeParserImpl

}