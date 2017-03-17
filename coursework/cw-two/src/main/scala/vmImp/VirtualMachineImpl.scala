package vmImp


import bc.ByteCode
import vm.VirtualMachine
import scala.collection.mutable.ListBuffer

class VirtualMachineImpl extends VirtualMachine {

  /**
    * An internal stack on which all operands are held
   */
  var vmStack = new ListBuffer[Int]

  /** @inheritdoc */
  def execute(bc: Vector[ByteCode]): VirtualMachine = {
    var tuple: (Vector[ByteCode], VirtualMachine) = (bc, this)
    if (bc.nonEmpty) {
      tuple = executeOne(bc)
      tuple._2.execute(tuple._1)
    }
    this
  }

  /** @inheritdoc */
  def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = {
      bc(0).execute(this)
      (bc.drop(1), this)
  }

  /** @inheritdoc */
  def push(value: Int): VirtualMachine = {
    value +=: vmStack
    this
  }

  /** @inheritdoc */
  def pop(): (Int, VirtualMachine) = {
    if (vmStack.isEmpty) {
      throw new NoSuchElementException("Insufficient constants on the stack")
    }
    else {
      val head  = vmStack.head
      vmStack = vmStack.tail
      (head, this)
    }
  }

  /** @inheritdoc */
  def state: Vector[Int] = {
    vmStack.toVector
  }

}

object VirtualMachineImpl {

  def apply() : VirtualMachine = new VirtualMachineImpl

}
