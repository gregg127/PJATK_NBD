package NBD_1

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object Task8 {

  def removeZeros(list: List[Int]): List[Int] = {
    @tailrec
    def iter(arg: ListBuffer[Int]): ListBuffer[Int] = {
      val len = arg.length
      arg -= 0
      if (arg.length == len) arg else iter(arg)
    }

    iter(ListBuffer.from(list)).toList
  }

  def main(args: Array[String]): Unit = {
    println(removeZeros(List(0, 1, 2, 0, 3, 4, 0, 0, 5, 6, 7, 0, 8, 9, 10, 0)))
  }
}