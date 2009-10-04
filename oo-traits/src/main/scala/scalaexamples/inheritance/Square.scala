package scalaexamples.inheritance

// Subclass the Rectangle
class Square(length: Double, color: String) extends Rectangle(length, length, color) {
  
  // Create an auxiliary constructor
  def this(length: Double) = this(length, Shape.DefaultColor)
  
  // Override the area method
  override def area = length * length

}
