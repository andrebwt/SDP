package sml

import scala.collection.mutable.ListBuffer
import scala.reflect.runtime.{universe => ru}


/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  private final val ADD = "add"
  private final val LIN = "lin"
  private final val BNZ = "bnz"
  private final val MUL = "mul"
  private final val SUB = "sub"
  private final val OUT = "out"
  private final val DIV = "div"

  def getTypeTag[T: ru.TypeTag](obj: T) = ru.typeTag[T]


  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      //val theType = getTypeTag(line).tpe
      //println(s"The type of object is: $theType.")
      //println(s"The line read is: $line.")

      if (fields.length > 0) {

        // Get the type of instruction
        val ins = fields(1)
        //println(s"The type of instruction is: $ins.")

        // Get the name of the class needed
        val insName = ins.substring(0, 1).toUpperCase() + ins.substring(1).toLowerCase() + "Instruction"
        //println(s"The instruction classname is: $insName.")

        // Get the Class object for the named class
        val insClass = Class.forName("sml." + insName)
        //println(s"The instruction object is: $insClass.")

        // Reflect Class
        val mirror  = ru.runtimeMirror(getClass.getClassLoader)
        val className = mirror.classSymbol(insClass)
        val classMirror = mirror.reflectClass(className)

        println(s"The reflected class is: $classMirror .")

        val ctor = className.primaryConstructor.asMethod
        val ctorMirror = classMirror.reflectConstructor(ctor)

        val ctorParam = ctor.paramLists
        val paramTypes = new ListBuffer[Any]()

        for (p <- ctorParam; j <- p) {
          println(j.info.toString)

        }

        println(s"The constructor parameters are: $ctorParam .")

        //println(s"The constructor mirror is: $ctorMirror .")

        println(s"The parameter types are: $paramTypes")

        //println(s"The constructor is: $ctor .")


        //val nextInstruction = ctorMirror.apply(paramTypes).asInstanceOf[Instruction]
        //println(s"Added Instruction: $nextInstruction .")




        fields(1) match {
          case ADD =>
            program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case LIN =>
            program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
          case OUT =>
            program = program :+ OutInstruction(fields(0), fields(2).toInt)
          case BNZ =>
            program = program :+ BnzInstruction(fields(0), fields(2).toInt, fields(3))
          case DIV =>
            program = program :+ DivInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case MUL =>
            program = program :+ MulInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case SUB =>
            program = program :+ SubInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case x =>
            println(s"Unknown instruction $x")
        }

        labels.add(fields(0))


      }

    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}
