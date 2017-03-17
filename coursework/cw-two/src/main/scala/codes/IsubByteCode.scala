package codes

import bc.{ByteCode, ByteCodeValues}
import vm.VirtualMachine

class IsubByteCode(byte: Byte) extends ByteCode {

  /** @inheritdoc */
  val code: Byte = byte

  /** @inheritdoc */
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()._1
    val y = vm.pop()._1
    vm.push(x - y)
  }
}
