package codes

import bc.{ByteCode, ByteCodeValues}
import vm.VirtualMachine

class IdivByteCode(byte: Byte) extends ByteCode {

  /** @inheritdoc */
  val code: Byte = byte

  /** @inheritdoc */
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()._1
    val y = vm.pop()._1
    if (y != 0) vm.push(x / y) else throw new IllegalArgumentException(s"$x / $y is undefined")
    vm.push(x / y)
  }
}
