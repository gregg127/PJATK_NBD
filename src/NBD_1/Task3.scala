package NBD_1

import scala.annotation.tailrec

object Task3 {

  def convertToStringTailRecursive(list: List[String]): String = {
    @tailrec
    def iter(list: List[String], index: Int = 0, result: String = ""): String = {
      if (index == list.length) {
        if (index > 0) {
          result.stripSuffix(", ")
        } else {
          result
        }
      } else {
        iter(list, index + 1, result + list(index) + ", ")
      }
    }
    iter(list)
  }

  def main(args: Array[String]): Unit = {
    val weekDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
    println(convertToStringTailRecursive(weekDays))
  }
}
