package sml

class OutInstruction (label: String, op: String, regRequest: Int) extends Instruction(label, op) {

  override def execute(m: Machine) = {
    println(s"The contents of register $regRequest is ${m.regs(regRequest)}.")
  }

  override def toString(): String = {
    super.toString + " register " + regRequest
  }
}

object OutInstruction {
  def apply(label: String, regRequest: Int) =
    new OutInstruction(label, "out", regRequest)
}
