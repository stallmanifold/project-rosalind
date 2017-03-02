package rosalind.problems

/**
  * Marker trait for Project Rosalind problems.
  */
abstract class Problem {
  def run(args: Array[String]): Unit
  def name: String
}

trait Usage {
  def usage: String = "USAGE: sbt run <problem number> <file name>"
}
