package scalaexamples.traits

// Make this class Ordered!
class Element(val anIntValue: Int) {
  
  // def compare(other: Element) = 
  
  override def toString = "anIntValue is " + anIntValue
  
}

trait InterfaceTrait {
  
  def getSomeString: String
  
}

trait MethodTrait {
  
  def mixedInMethod = "a value"
  
}

trait SubClassTrait extends Element {
  
  override def toString = "stacked toString, super toString is '" + super.toString + "'"
  
} 

