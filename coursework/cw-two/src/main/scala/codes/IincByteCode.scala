package codes

import bc.{ByteCode, ByteCodeValues}
import vm.VirtualMachine

class IincByteCode(byte: Byte) extends ByteCode {

  /** @inheritdoc */
  val code: Byte = byte

  /** @inheritdoc */
  def execute(vm: VirtualMachine): VirtualMachine = {
    vm.push(vm.pop()._1 + 1)
  }
}
