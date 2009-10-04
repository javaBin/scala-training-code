package scalaexamples.inheritance

class Rectangle(width: Double, height: Double, color: String) extends Shape(color) {

  // Create a auxiliary constructor
  
  def area = width * height
  def circumference = 2 * width + 2 * height
  
}
