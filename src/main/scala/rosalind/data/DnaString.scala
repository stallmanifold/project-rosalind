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

  def apply(args: TraversableOnce[NucleoBase]): DnaString = {
    new DnaString(args.toSeq)
  }
}

class DnaString(private val seq: Seq[NucleoBase])

object DnaStringParser {
  def apply(string: TraversableOnce[Char]): Option[DnaString] = {
    new DnaStringParser().parse(string)
  }
}

final class DnaStringParser extends Parser[TraversableOnce[Char], DnaString] {
  def parse(string: TraversableOnce[Char]): Option[DnaString] = {
    // check for invalid characters.
    for (ch <- string) {
      if (step(ch).isEmpty) { None }
    }

    val pf = PartialFunction((ch: Char) => step(ch).get)
    val dnaSeq = string map pf

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
