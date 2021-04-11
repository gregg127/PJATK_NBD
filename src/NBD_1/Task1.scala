package NBD_1

object Task1 {
  def convertToStringWhile(list: List[String]): String = {
    val result = new StringBuilder()
    var i = 0
    while (i < list.size) {
      result.append(list(i)).append(", ")
      i += 1
    }
    result.toString().stripSuffix(", ")
  }

  def convertToStringForStartsWithP(list: List[String]): String = {
    val result = new StringBuilder()
    for (i <- list.indices) {
      if (list(i)(0) == 'P') {
        result.append(list(i)).append(", ")
      }
    }
    result.toString().stripSuffix(", ")
  }

  def convertToStringFor(list: List[String]): String = {
    val result = new StringBuilder()
    for (i <- list.indices) {
      result.append(list(i)).append(", ")
    }
    result.toString().stripSuffix(", ")
  }

  def main(args: Array[String]): Unit = {
    val weekDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
    println(convertToStringFor(weekDays))
    println(convertToStringForStartsWithP(weekDays))
    println(convertToStringWhile(weekDays))
  }
}
