package NBD_1

object Task1 {
  def main(args: Array[String]): Unit = {
    val weekDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

    def convertToStringFor(list: List[String]): String = {
      val result = new StringBuilder(list.head)
      for (i <- 1 until list.size) {
        result.append(", ").append(list(i))
      }
      result.toString()
    }

    def convertToStringWhile(list: List[String]): String = {
      val result = new StringBuilder(list.head)
      var i = 1
      while (i < list.size) {
        result.append(", ").append(list(i))
        i += 1
      }
      result.toString()
    }

    println(convertToStringFor(weekDays))
    println(convertToStringFor(weekDays.filter(day => day.startsWith("P"))))
    println(convertToStringWhile(weekDays))
  }
}
