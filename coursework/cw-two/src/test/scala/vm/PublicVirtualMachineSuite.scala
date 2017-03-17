package vm

import factory.VirtualMachineFactory
import org.scalatest.{FunSuite, BeforeAndAfterEach}

class PublicVirtualMachineSuite extends FunSuite with BeforeAndAfterEach {
  var vmp = VirtualMachineFactory.virtualMachineParser
  var bcp = VirtualMachineFactory.byteCodeParser
  var vm  = VirtualMachineFactory.virtualMachine

  override def afterEach {
    vm = VirtualMachineFactory.virtualMachine
  }

  test("[10] a virtual machine should execute p01.vm") {
    val bc  = vmp.parse("programs/p01.vm")
    val vm2 = vm.execute(bc)
  }

  test("[10] p03.vm should throw an IllegalArgumentException on attempting modulus 0") {
    assertThrows[IllegalArgumentException] {
      val bc  = vmp.parse("programs/p03.vm")
      val vm2 = vm.execute(bc)
    }
  }

  test("[10] a virtual machine should execute a program") {
    val bc  = vmp.parse("programs/p05.vm")
    val vm2 = vm.execute(bc)
  }

  test("[2] iconst should work correctly") {
    val bc  = vmp.parseString("iconst 1")
    val (bc2, vm2) = vm.executeOne(bc)
    assert(vm2.state.head == 1)
  }

  test("[2] iadd should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\niadd")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 3)
  }

  test("[2] iadd should work correctly with negative numbers") {
    val bc  = vmp.parseString("iconst -4\niconst -3\niadd")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == -4)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == -3)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == -7)
  }

  test("[2] isub should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\nisub")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 1)
  }

  test("[2] iswap should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\niswap")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state(0) == 1)
    assert(next._2.state(1) == 2)
  }

  test("[2] idec should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 5\nidec")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 5)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 4)
  }

  test("[2] idiv should work correctly") {
    val bc  = vmp.parseString("iconst 2\niconst 8\nidiv")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 8)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 4)
  }

  test("[2] idup should work correctly") {
    val bc  = vmp.parseString("iconst 2\niconst 8\nidup")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 8)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 8)
    assert(next._2.state(1) == 8)
  }

  test("[2] iinc should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 5\niinc")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 5)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 6)
  }

  test("[2] imul should work correctly") {
    val bc  = vmp.parseString("iconst 2\niconst 8\nimul")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 8)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 16)
  }

  test("[2] ineg should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 5\nineg")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 5)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == -5)
  }

  test("[2] print should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\nprint")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 1)
  }

  test("[2] irem should work correctly") {
    val bc  = vmp.parseString("iconst 3\niconst 5\nirem")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 3)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 5)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
  }

  test("[10] a virtual machine should throw NoSuchElementException if there are insufficient constants on the stack") {
    val bc  = vmp.parse("programs/p02-bad-stack.vm")
    intercept[NoSuchElementException] {
      val vm2 = vm.execute(bc)
    }
  }

  test("[10] a virtual machine should throw IllegalArgumentException if modulating by 0") {
    val bc  = vmp.parseString("iconst 0\niconst 5\nirem")
    intercept[IllegalArgumentException] {
      val vm2 = vm.execute(bc)
    }
  }

  test("[10] a virtual machine should throw IllegalArgumentException if dividing by 0") {
    val bc  = vmp.parseString("iconst 0\niconst 5\nidiv")
    intercept[IllegalArgumentException] {
      val vm2 = vm.execute(bc)
    }
  }


}