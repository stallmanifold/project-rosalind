package rosalind.parse


trait Parser[T, Val] {
  def parse(seq: T): Option[Val]
}
