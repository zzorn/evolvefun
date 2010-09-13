package org.genefun

import geneticalgorithm.{Phenome, Genome, Environment, GeneticAlgorithm}
import util.Random

/**
 * Example that uses a genetic algorithm to create efficient search algorithms.
 */
object SearchSearch {

  val random = new Random()

  case class Gen(v: Float) extends Genome[Gen] {

    def mix(other: Gen, amount: Float): Gen = Gen((other.v + v) * 0.5f)

    def mutate(amount: Float): Gen = Gen(v + random.nextGaussian().toFloat)
  }

  case class Phen(genome: Gen) extends Phenome[Gen] {
    def score = 100 - math.abs(genome.v - 42f)

    override def toString = "Genome: " + genome + ", score: " + score
  }

  class Env extends Environment[Gen, Phen] {
    def simulateStep() {
      phenomes foreach { p: Phen =>
        
      }
    }

    def instantiate(genome: Gen) = Phen(genome)
  }


  def main(args: Array[String]) {

    val ga = new GeneticAlgorithm(() => new Env())

    val pop = List(Gen(1), Gen(2), Gen(3))

    println("Initial population " + pop.mkString("\n"))

    val finalPop = ga.run(pop)

    println("Final population " + finalPop.mkString("\n"))

  }


}