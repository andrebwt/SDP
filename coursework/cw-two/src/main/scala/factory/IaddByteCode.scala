package factory

import bc.{ByteCode, ByteCodeValues}
import vm.VirtualMachine

class IaddByteCode(byte: Byte) extends ByteCode {
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
    vm.push(vm.pop()._1 + vm.pop()._1)
  }


}