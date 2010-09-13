package org.genefun.script.list

import org.genefun.script.Scope

/**
 * 
 */
trait Element {
  def evaluate(scope: Scope): Element
}