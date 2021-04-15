package NBD_1

object Task9 {

  def increment(numbers: List[Int]): List[Int] = {
    numbers map { case numbers => numbers + 1 }
  }

  def main(args: Array[String]): Unit = {
    println(increment(List(1, 2, 3, 4, 5)))
  }
}
