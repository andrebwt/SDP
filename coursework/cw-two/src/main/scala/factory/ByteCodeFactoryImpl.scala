package factory

import bc._
import codes._


/**
  * [[ByteCodeFactory]] defines a factory interface for creating
  * [[ByteCode]] objects. You will need to extend this to provide
  * your own implementation of a [[ByteCodeFactory]].
  */
class ByteCodeFactoryImpl extends ByteCodeFactory with ByteCodeValues {


  /**
    * Returns a [[ByteCode]].
    *
    * This method creates a new [[ByteCode]] object given the `byte`
    * that corresponds to the bytecode (see [[ByteCodeValues]]. If
    * the bytecode requires arguments then an optional integer
    * argument is provided.
    *
    * This method should throw an [[InvalidBytecodeException]] if the
    * given bytecode value is unknown.
    *
    * @param byte the byte code of a bytecode
    * @param args an optional integer argument (depends on bytecode)
    * @return a new bytecode object
    */
  def make(byte: Byte, args: Int*): ByteCode = {

    /*
    "iconst", "iadd", "isub", "imul", "idiv", "irem",
    "ineg", "iinc", "idec", "idup", "iswap", "print")
     */


    val ADD = bytecode.getOrElse("iadd",0)
    val CONST = bytecode.getOrElse("iconst",0)
    val SUB = bytecode.getOrElse("isub",0)
    val MUL = bytecode.getOrElse("imul",0)
    val DIV = bytecode.getOrElse("idiv",0)
    val REM = bytecode.getOrElse("irem",0)
    val NEG = bytecode.getOrElse("ineg",0)
    val INC = bytecode.getOrElse("iinc",0)
    val DEC = bytecode.getOrElse("idec",0)
    val DUP = bytecode.getOrElse("idup",0)
    val SWAP = bytecode.getOrElse("iswap",0)
    val PRINT = bytecode.getOrElse("print",0)


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
  def apply() = new ByteCodeFactoryImpl
}
