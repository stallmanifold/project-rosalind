package rosalind.problems

import rosalind.data
import scala.io.Source
import java.io.FileNotFoundException
import scala.sys


object Problem001 {
  def usage: String = "USAGE: sbt run <problem number> <file name>"

  def main(args: Array[String]): Unit = {
    if (args.length < 2) {
      println(usage)
      sys.exit(0)
    }

    try {
      val handle = Source.fromFile(args(1))
      val dnaStr = data.DnaStringParser(handle)
      println(dnaStr)
    } catch {
      case e: FileNotFoundException => {
        println(e.getMessage)
        sys.exit(1)
      }
    }
  }
}
