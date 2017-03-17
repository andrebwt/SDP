package codes

import bc.{ByteCode, ByteCodeValues}
import vm.VirtualMachine

class IconstByteCode(byte: Byte, arg: Int) extends ByteCode {

  /** @inheritdoc */
  val code: Byte = byte

  /**
    * The constant to be pushed to the stack, as passed in through the constructor
    */
  val argument : Int = arg

  /** @inheritdoc */
  def execute(vm: VirtualMachine): VirtualMachine = {
        vm.push(argument)
  }


}
