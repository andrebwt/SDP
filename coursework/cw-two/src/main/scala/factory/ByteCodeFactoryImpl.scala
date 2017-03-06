package factory

import bc._
import vendor.InvalidInstructionFormatException


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

    val ADD = bytecode.getOrElse("iadd",0)
    val CONST = bytecode.getOrElse("iconst",0)


    byte match {
      case ADD  => new IaddByteCode(byte)
      case CONST  => new IconstByteCode(byte, args(0))
      case _ => throw new InvalidBytecodeException("Invalid bytecode provided")
    }
  }
}

object ByteCodeFactoryImpl {
  def apply() = new ByteCodeFactoryImpl
}
