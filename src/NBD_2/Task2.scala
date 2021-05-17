package NBD_2

object Task2 {

  class BankAccount(private var _balance: BigDecimal) {

    def balance: BigDecimal = _balance

    def this() = {
      this(BigDecimal(0))
    }

    def deposit(amount: BigDecimal): Unit = {
      _balance += amount
    }

    def withdraw(amount: BigDecimal): BigDecimal = {
      if (amount > balance) {
        throw new IllegalStateException("Account has not sufficient funds")
      }
      _balance -= amount
      amount
    }
  }

  def main(args: Array[String]): Unit = {
    val acc1 = new BankAccount();
    println("Empty account balance: " + acc1.balance)
    val acc2 = new BankAccount(200);
    println("Account balance: " + acc2.balance)
    acc2.deposit(200)
    println("Account balance after deposit: " + acc2.balance)
    println("Withdrawn from account: " + acc2.withdraw(100))
    println("Account balance: " + acc2.balance)
  }
}
