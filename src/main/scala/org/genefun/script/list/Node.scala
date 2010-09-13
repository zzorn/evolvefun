package org.genefun.script.list

import org.genefun.script.Scope

/**
 * 
 */
case class Node(head: Element, tail: Node) extends Element {
  def evaluate(scope: Scope) = // Invoke head with tail
}
