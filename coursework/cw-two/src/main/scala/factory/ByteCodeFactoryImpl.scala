package factory

import bc._
import codes._


class ByteCodeFactoryImpl extends ByteCodeFactory with ByteCodeValues {

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


  /** @inheritdoc */
  def make(byte: Byte, args: Int*): ByteCode = {
    byte match {
      case ADD  => new IaddByteCode(byte)
      case CONST  => new IconstByteCode(byte, args(0))
      case SUB  => new IsubByteCode(byte)
      case MUL  => new ImulByteCode(byte)
      case DIV  => new IdivByteCode(byte)
      case REM  => new IremByteCode(byte)
      case NEG  => new InegByteCode(byte)
      case INC  => new IincByteCode(byte)
      case DEC  => new IdecByteCode(byte)
      case DUP  => new IdupByteCode(byte)
      case SWAP  => new IswapByteCode(byte)
      case PRINT  => new IprintByteCode(byte)
      case _ => throw new InvalidBytecodeException("Invalid bytecode provided")
    }
  }
}

object ByteCodeFactoryImpl {
  def apply() : ByteCodeFactory = new ByteCodeFactoryImpl
}
