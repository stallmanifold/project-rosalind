package rosalind.problems


object DefaultProblem {
  def apply(): Unit = new DefaultProblem()

  def apply(args: Array[String]): Unit = new DefaultProblem().run(args)
}

final class DefaultProblem extends Problem with Usage {
  def name: String = "Default Problem"

  def run(args: Array[String]): Unit = {
    if (args.length < 2) {
      println(usage)
    }

    sys.exit(0)
  }
}
