package scalaexamples.objectorientation

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class EmployeeTest {

  @Test
  def testEmployeeSalary {
    val employee = new Employee("Fredrik", 500000)
    assertEquals(500000, employee.salary)
  }
}
