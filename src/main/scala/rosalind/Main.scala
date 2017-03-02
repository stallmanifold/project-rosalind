package rosalind

import java.io.FileNotFoundException

import scala.io.Source

import rosalind.problems

object Main {
  def usage: String = "USAGE: sbt run <problem number> <file name>"

  def main(args: Array[String]) = {
    if (args.length < 2) {
      println(usage)
      sys.exit(0)
    }

    try {
      val problemNumber = args(0).toInt
      problemNumber match {
        case 1 => problems.Problem001.main(args)
        case _ => sys.exit(0)
      }
    } catch {
      case e: FileNotFoundException => {
        println(e.getMessage)
        sys.exit(1)
      }
      case e: NumberFormatException => {
        println(e.getMessage)
        sys.exit(1)
      }
    }
  }
}
