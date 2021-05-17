package NBD_2

object Task5 {

  trait Student extends Person {
    override val tax: BigDecimal = BigDecimal(0)
  }

  trait Teacher extends Employee {
    override val tax: BigDecimal = BigDecimal(0.1) * salary
  }

  trait Employee extends Person {
    var salary: BigDecimal = BigDecimal(10000)
    override val tax: BigDecimal = BigDecimal(0.2) * salary
  }

  class Person(val firstName: String, val lastName: String, val tax: BigDecimal = BigDecimal(0))

  def main(args: Array[String]): Unit = {
    val student = new Person("A", "AA") with Student
    val teacher = new Person("B", "BB") with Teacher
    val employee = new Person("C", "CC") with Employee
    val employeeStudent = new Person("D", "DD") with Employee with Student
    val studentEmployee = new Person("E", "EE") with Student with Employee

    println("Student tax: " + student.tax)
    println("Teacher tax: " + teacher.tax)
    println("Employee tax: " + employee.tax)
    println("EmployeeStudent tax: " + employeeStudent.tax)
    println("StudentEmployee tax: " + studentEmployee.tax)
  }
}
