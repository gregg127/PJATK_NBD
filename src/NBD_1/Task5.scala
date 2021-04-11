package NBD_1

object Task5 {

  def main(args: Array[String]): Unit = {
    val productsPrices = Map("jabłko" -> 2.10, "ananas" -> 6.98, "marakuja" -> 12.99)
    println(productsPrices)
    println(productsPrices map { case (name, price) => (name, price * 0.9) })
  }

}
