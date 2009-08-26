package scalaexamples

class Element(val anIntValue: Int) extends Ordered[Element] {
  
  def compare(other: Element) = this.anIntValue - other.anIntValue
  
}


trait MethodTrait {
  
  def mixedInValue = "a value"
  
}