package rosalind.data

import rosalind.parse.Parser
import rosalind.data.nucleobase.NucleoBase


object DnaString {
  def apply(args: Seq[NucleoBase]): DnaString = {
    new DnaString(args)
  }

  def apply(arg: NucleoBase): DnaString = {
    new DnaString(Seq(arg))
  }
}

class DnaString(private val seq: Seq[NucleoBase])

final class DnaStringParser extends Parser[String, DnaString] {
  def parse(string: String): Option[DnaString] = {
    for (ch <- string) {
      if (step(ch).isEmpty) { None }
    }

    val dnaSeq: Seq[NucleoBase] = for (ch <- string) yield step(ch).get

    Some(DnaString(dnaSeq))
  }

  private def step(ch: Char): Option[NucleoBase] = {
    ch match {
      case 'T' => Some(nucleobase.T)
      case 'A' => Some(nucleobase.A)
      case 'C' => Some(nucleobase.C)
      case 'G' => Some(nucleobase.G)
      case _   => None
    }
  }
}
