package codes

import bc.{ByteCode, ByteCodeValues}
import vm.VirtualMachine

class IsubByteCode(byte: Byte) extends ByteCode {
  /**
    * A unique byte value representing the bytecode. An implementation
    * will set this to the bytecode corresponding to the name of the
    * bytecode in [[ByteCodeValues]]
    */


  val code: Byte = byte

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */

  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()._1
    val y = vm.pop()._1
    vm.push(x - y)
  }
}