import scala.io.StdIn.readLine

object TestApp_while_loop extends App {

  var num = readLine("Enter a number: ").toInt

  while (num != 0) {
    println(num + " squared is " + (num * num))
    num = readLine("Enter a number: ").toInt
  }

}
