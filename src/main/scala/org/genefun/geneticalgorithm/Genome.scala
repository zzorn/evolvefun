package org.genefun.geneticalgorithm

/**
 * 
 */
trait Genome[G <: Genome[G]] {

  def mutate(amount: Float): G
  def mix(other: G, amount: Float): G

  final def mix(other: G) : G = mix(other, 0.5f)
}