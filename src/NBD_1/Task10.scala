package NBD_1

object Task10 {

  def rangeMapToAbs(args: List[Int], min: Int, max: Int): List[Int] = {
    args.filter(num => min until max + 1 contains num)
        .map(num => num.abs)
  }

  def main(args: Array[String]): Unit = {
    println(rangeMapToAbs(List(-53, -20, -5, -1, 0, 1, 5, 12, 24, 53), -5, 12))
  }
}
