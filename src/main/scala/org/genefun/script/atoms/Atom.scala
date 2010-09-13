package org.genefun.script.atoms

import org.genefun.script.list.Element
import org.genefun.script.Scope

/**
 * 
 */

trait Atom extends Element {
  def evaluate(scope: Scope) = this
}