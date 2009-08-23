package scalaexamples.objectorientation

import Math.Pi

class Circle(radius: Double, color: String) extends Shape(color) {

  def this(radius: Double) = this(radius, Shape.DefaultColor)
  
  def area = Pi * radius * radius
  def circumference = 2 * Pi * radius
  
}
