package scalaexamples

class Element(val anIntValue: Int) extends Ordered[Element] {
  
  def compare(other: Element) = this.anIntValue - other.anIntValue
  
}

trait InterfaceTrait {
  
  def getSomeString
  
}

trait MethodTrait {
  
  def mixedInMethod = "a value"
  
}

