package sml

class BnzInstruction(label: String, op: String, val op1: Int, val op2: String)
  extends Instruction(label, op) {

  override def execute(m: Machine) {
    val value1 = m.regs(op1)
    val value2 = m.labels.labels.indexOf(op2)

    if (value1 != 0) m.pc = value2
  }

  override def toString(): String = {
    super.toString + " " + op1 + " goto " + op2 + "\n"
  }
}

object BnzInstruction {
  def apply(label: String, op1: Int, op2: String) =
    new BnzInstruction(label, "bnz", op1, op2)
}
