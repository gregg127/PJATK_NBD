package NBD_1

object Task2 {
  def convertToStringRecursiveReversed(list: List[String], lastElementIndex: Int): String = {
    var result = list(lastElementIndex)
    if (lastElementIndex != 0)
      result += ", " + convertToStringRecursiveReversed(list, lastElementIndex - 1)
    result
  }

  def convertToStringRecursive(list: List[String], index: Int = 0): String = {
    var result = list(index)
    if (index != list.length - 1)
      result += ", " + convertToStringRecursive(list, index + 1)
    result
  }

  def main(args: Array[String]): Unit = {
    val weekDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
    println(convertToStringRecursive(weekDays))
    println(convertToStringRecursiveReversed(weekDays, weekDays.size - 1))
  }
}
