package rosalind

import java.io.FileNotFoundException


object Main {
  def load(problemNumber: Int, args: Array[String]): Unit = {
    problemNumber match {
      case 1 => problems.Problem001(args)
      case _ => problems.DefaultProblem(args)
    }
  }

  def usage: String = "USAGE: sbt run <problem number> <file name>"

  def main(args: Array[String]) = {
    if (args.length < 2) {
      println(usage)
      sys.exit(0)
    }

    try {
      val problemNumber = args(0).toInt
      load(problemNumber, args)
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
