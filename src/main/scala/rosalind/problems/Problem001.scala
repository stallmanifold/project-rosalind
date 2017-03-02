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

final class Problem001 extends Problem with Usage {
  def name: String = "Counting DNA Nucleotides"

  def run(args: Array[String]): Unit = {
    if (args.length < 2) {
      println(usage)
      sys.exit(0)
    }

    try {
      val handle = Source.fromFile(args(1))
      val dnaStr = dna.DnaStringParser(handle)
      val countBases = (base: dna.NucleoBase) => dnaStr map (str => str count (ch => ch == base))
      
      val a_count = countBases(dna.A).get
      val c_count = countBases(dna.C).get
      val g_count = countBases(dna.G).get
      val t_count = countBases(dna.T).get
      val string  = a_count + " " + c_count + " " + g_count + " " + t_count
      println(string)
    } catch {
      case e: FileNotFoundException => {
        println(e.getMessage)
        sys.exit(1)
      }
    }
  }
}

