package NBD_1

object Task4 {

  def main(args: Array[String]): Unit = {
    val weekDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
    // foldl
    println(weekDays.foldLeft("")((a, b) => a + ", " + b).stripPrefix(", "))
    // foldr
    println(weekDays.foldRight("")((a, b) => a + ", " + b).stripSuffix(", "))
    // filter + foldl
    println((weekDays filter (_ startsWith "P")).foldLeft("")((a, b) => a + ", " + b).stripPrefix(", "))
  }
}
