package org.genefun.script

/**
 * 
 */
trait Func {

  def parameters

  def parameterTypes: List[Type]
  def resultType: Type

  def eval: Value

}