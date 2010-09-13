package org.genefun.script.list

import org.genefun.script.Scope
import org.genefun.script.atoms.Atom

/**
 * 
 */

object Empty extends Atom with Node {
  override def evaluate(scope: Scope) = Empty
  val head = Empty
  val tail = Empty
}