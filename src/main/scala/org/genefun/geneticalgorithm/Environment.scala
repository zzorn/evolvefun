package org.genefun.geneticalgorithm

/**
 * 
 */
trait Environment[G <: Genome[G], P <: Phenome[G]] {

  private var _phenomes: List[P] = Nil

  def instantiate(genome: G): P
  def simulateStep()

  def clear() = _phenomes = Nil
  def add(phenome: P) = _phenomes = phenome :: _phenomes
  
  final def phenomes: List[P] = _phenomes

  final def addGenome(genome: G) = add(instantiate(genome))
  final def simulate(steps: Int) = 1 to steps foreach {_ => simulateStep()}

}