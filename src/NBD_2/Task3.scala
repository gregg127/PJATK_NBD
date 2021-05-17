package NBD_2

object Task3 {

  case class Person(private var _firstName: String, private var _lastName: String) {
    def firstName: String = _firstName
    def lastName: String = _lastName
  }

  def sayHello(p: Person): String = p match {
    case Person("Keanu", "Reeves") => "Welcome Mr. Wick."
    case Person("Lance", "Reddick") => "Hi Charon."
    case _ => "Hello stranger."
  }

  def main(args: Array[String]): Unit = {
    println(sayHello(Person("Keanu", "Reeves")))
    println(sayHello(Person("Lance", "Reddick")))
    println(sayHello(Person("Willem", "Dafoe")))
  }
}
