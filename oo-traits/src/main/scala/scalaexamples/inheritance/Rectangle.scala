package scalaexamples.inheritance

class Rectangle(width: Double, height: Double, color: String) extends Shape(color) {

  def this(width: Double, height: Double) = this(width, height, Shape.DefaultColor)
  
  def area = width * height
  def circumference = 2 * width + 2 * height
  
}
