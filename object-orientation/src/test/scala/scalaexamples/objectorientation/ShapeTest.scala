package scalaexamples.objectorientation

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import Math.Pi

@RunWith(classOf[JUnit4])
class ShapeTest extends EmptyTest {

  val rectangle = new Rectangle(10.0, 4.0)
  val circle = new Circle(3.0)

  val shapes = List(rectangle, circle)
  
  @Test
  def testArea {
    assertEquals(40.0, rectangle.area)
    assertEquals(Pi * 3.0 * 3.0, circle.area)
  }
  
  @Test
  def testCircumference {
    assertEquals(28.0, rectangle.circumference)
    assertEquals(2 * Pi * 3.0, circle.circumference)
  }
  
  @Test
  def testColor {
    shapes foreach { shape => assertEquals(Shape.DefaultColor, shape.color) }
  }
}
