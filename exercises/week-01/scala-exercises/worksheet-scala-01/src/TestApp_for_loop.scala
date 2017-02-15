object TestApp_for_loop extends App {

  for (i <- 1 to 25) {

    val square = i * i
    val cube = i * square

    println("value: " + i + " squared: " + square + " cubed: " + cube)
  }
}
