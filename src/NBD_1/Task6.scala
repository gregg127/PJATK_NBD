package NBD_1

object Task6 {

  def fun(tuple: Tuple3[Int, String, Boolean]): Unit = {
    println(tuple._1, tuple._2, tuple._3)
  }

  def main(args: Array[String]): Unit = {
    fun(55, "Tekst", true)
  }

}
