package scalaexamples.objectorientation

abstract class Shape(val color: String) {
  
  def area: Double
  def circumference: Double

}

object Shape {

  val DefaultColor = "white"

}

