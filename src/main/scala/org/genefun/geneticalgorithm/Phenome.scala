package org.genefun.geneticalgorithm

/**
 * 
 */
trait Phenome[G <: Genome[G]] {

  def genome: G
  def score: Float
  
}