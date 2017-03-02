package rosalind.data.dna

import rosalind.data.dna
import rosalind.parse.Parser


object DnaStringParser {
  def apply(string: TraversableOnce[Char]): Option[DnaString] = {
    new DnaStringParser().parse(string)
  }
}

final class DnaStringParser extends Parser[TraversableOnce[Char], DnaString] {
  def parse(string: TraversableOnce[Char]): Option[DnaString] = {
    // check for invalid characters.
    val whitespace = (ch: Char) => " \n\r\t".contains(ch)
    val (iter0, iter1) = string.toIterator.filterNot(whitespace).duplicate
    for (ch <- iter0) {
      if (step(ch).isEmpty) { None }
    }

    val pf = PartialFunction((ch: Char) => step(ch).get)
    val dnaSeq = iter1 map pf

    Some(DnaString(dnaSeq))
  }

  private def step(ch: Char): Option[NucleoBase] = {
    ch match {
      case 'T' => Some(dna.T)
      case 'A' => Some(dna.A)
      case 'C' => Some(dna.C)
      case 'G' => Some(dna.G)
      case _   => None
    }
  }
}
