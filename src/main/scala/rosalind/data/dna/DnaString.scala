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

class DnaString(private val data: Seq[NucleoBase]) extends Seq[NucleoBase] {
  override def apply(idx: Int): NucleoBase = this.data.apply(idx)

  override def iterator: Iterator[NucleoBase] = this.data.iterator

  override def length: Int = this.data.length

  override def toString = data.mkString
}