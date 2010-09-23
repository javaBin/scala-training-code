package scalaexamples.inheritance

import scala.math._

class Circle(radius: Double, color: String) extends Shape(color) {

  // Create a auxiliary constructor
  def this(radius: Double) = this(radius, Shape.DefaultColor)
  
  // Define the area function
  def area = Pi * radius * radius
  
  def circumference = 2 * Pi * radius
  
}
