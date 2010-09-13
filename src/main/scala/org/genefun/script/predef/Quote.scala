package org.genefun.script.predef

import org.genefun.script.Scope
import org.genefun.script.list.Element

/**
 * 
 */
case class Quote(element: Element) extends Element {
  def evaluate(scope: Scope) = element
}