package scalaexamples.objectorientation

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class ManagerTest {

  @Test
  def testManagerSalary() {
    val manager = new Manager("Fredrik", 500000, 75000)
    assertEquals(575000, manager.salary)
  }
}
