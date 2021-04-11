package NBD_1

object Task7 {

  def getProductPriceOrZero(products: Map[String, Double], productName: String): Double = {
    val price = products.get(productName)
    if (price.isEmpty) {
      println(s"WARNING: No price found for product: $productName.")
    }
    price.getOrElse(0)
  }

  def main(args: Array[String]): Unit = {
    val productsPrices = Map("jabłko" -> 2.10, "ananas" -> 6.98, "marakuja" -> 12.99)
    println(getProductPriceOrZero(productsPrices, "ananas"))
    println(getProductPriceOrZero(productsPrices, "ogórek"))
  }
}
