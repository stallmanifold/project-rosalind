package rosalind.problems

import rosalind.data.dna
import scala.io.Source
import java.io.FileNotFoundException


object Problem001 {
  def apply(): Unit = new Problem001()

  def apply(args: Array[String]): Unit = {
    new Problem001().run(args)
  }
}

final class Problem001 extends Problem {
  private def usage: String = "USAGE: sbt run <problem number> <file name>"

  def name: String = "Counting DNA Nucleotides"

  def run(args: Array[String]): Unit = {
    if (args.length < 2) {
      println(usage)
      sys.exit(0)
    }

    try {
      val handle = Source.fromFile(args(1))
      val dnaStr = dna.DnaStringParser(handle)
      println(dnaStr)
    } catch {
      case e: FileNotFoundException => {
        println(e.getMessage)
        sys.exit(1)
      }
    }
  }
}

