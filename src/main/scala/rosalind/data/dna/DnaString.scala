package rosalind.data.dna


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
