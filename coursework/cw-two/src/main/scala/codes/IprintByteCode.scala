package codes

import bc.{ByteCode, ByteCodeValues}
import vm.VirtualMachine

class IprintByteCode(byte: Byte) extends ByteCode {

  /** @inheritdoc */
  val code: Byte = byte

  /** @inheritdoc */
  def execute(vm: VirtualMachine): VirtualMachine = {
    print(vm.pop()._1)
    vm
  }
}
