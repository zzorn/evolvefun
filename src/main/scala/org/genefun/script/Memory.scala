package org.genefun.script

/**
 * 
 */
class Memory {

  /**
   * Creates a new constant with the specified value, and returns its index.
   */
  def defineVal(value: Float): Int

  /**
   * Return the value with the specified index.
   */
  def getVal(index: Int): Float

  
}