package NBD_2

object Task4 {

  def tripleEval(arg: Int, fun: Int => Int): Int = {
    fun(fun(fun(arg)))
  }

  def main(args: Array[String]): Unit = {
    println(tripleEval(3, (x: Int) => x * 3))
  }
}
