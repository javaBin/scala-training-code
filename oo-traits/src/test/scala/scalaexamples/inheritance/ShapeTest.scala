package scalaexamples.inheritance

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import scala.math._
import scalaexamples.EmptyTest

@RunWith(classOf[JUnit4])
class ShapeTest extends EmptyTest {

  val rectangle = new Rectangle(4.0, 10.0, Shape.DefaultColor)
  val circle = new Circle
  val square = new Square

  val shapes = List(rectangle, circle, square)
  
  @Test
  def testArea {
    assertEquals(40.0, rectangle.area)
    // Make this compile and run
    // assertEquals(Pi * 3.0 * 3.0, circle.area)
    // assertEquals(4.0, square.area)
  }
  
  @Test
  def testCircumference {
    assertEquals(28.0, rectangle.circumference)
    // Make this compile and run
    // assertEquals(2 * Pi * 3.0, circle.circumference)
    // assertEquals(8.0, square.circumference)
  }
  
  @Test
  def testColor {
    // Make this compile and run
    // shapes foreach { shape => assertEquals(Shape.DefaultColor, shape.color) }
  }
}
