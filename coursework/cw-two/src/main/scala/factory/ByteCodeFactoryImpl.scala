package factory

import bc.{ByteCode, ByteCodeFactory}


class ByteCodeFactoryImpl extends ByteCodeFactory {

  def make(byte: Byte, args: Int*): ByteCode = ???

}

object ByteCodeFactoryImpl {

  def apply() = new ByteCodeFactoryImpl

}
