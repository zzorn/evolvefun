package org.genefun.geneticalgorithm

import util.Random
import collection.mutable.{Buffer, ListBuffer}

/**
 * 
 */
class GeneticAlgorithm[G <: Genome[G], P <: Phenome[G]](environmentFactory: () => Environment[G, P]) {

  var random: Random = new Random()
  var mutationAmount = 0.5f
  var mixAmount = 0.5f
  var winnerFaction = 0.3f
  var steps = 1000
  var populationSize = 100

  def run(initialGenes: List[G]): List[G] = {

    // Expand genes if needed
    var genePool: List[G] = initialGenes
    0 until (populationSize - genePool.size) foreach {_ => genePool = expandGenePool(genePool) }

    val environment = environmentFactory()

    0 until steps foreach { _ =>
      environment.clear()      
      genePool foreach { environment.addGenome(_) }
      val phenomes = environment.phenomes.toIndexedSeq.sortWith(_.score > _.score)
      val numberOfWinners = (phenomes.size * winnerFaction).toInt
      val winners = phenomes.take(numberOfWinners).map(_.genome)
      genePool = newGeneration(winners, populationSize)
    }
    
    genePool
  }

  def expandGenePool(genePool: List[G]) = genePool(random.nextInt(genePool.size)).mutate(mutationAmount) :: genePool

  def newGeneration(genes: IndexedSeq[G], targetSize: Int): List[G] = {
    var newGenePool: List[G] = Nil
    0 until targetSize foreach { _ => 
      val a = genes(random.nextInt(genes.size))
      val b = genes(random.nextInt(genes.size))
      newGenePool = a.mix(b, mixAmount).mutate(mutationAmount) :: newGenePool
    }
    newGenePool
  }
}