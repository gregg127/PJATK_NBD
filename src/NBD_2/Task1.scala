package NBD_2

object Task1 {

  def fun(s: String): String = {
    s match {
      case "Poniedziałek" | "Wtorek" | "Środa" | "Czwartek" | "Piątek" => "Praca"
      case "Sobota" | "Niedziela" => "Weekend"
      case _ => "Nie ma takiego dnia"
    }
  }

  def main(args: Array[String]): Unit = {
    List("Poniedziałek", "Wtorek", "test", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela", "oof")
      .foreach(e => println(s"$e => ${fun(e)}"))
  }
}
