package scalaexamples.firstclassfunctions

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class AgeTest {

  val alf = Person("Alf", 30)
  val fredrik = Person("Fredrik", 33)
  val johannes = Person("Johannes", 0)

  val persons = List(alf, fredrik, johannes)
  
  @Test def testAgeLimit {
    val (adults, kids) = persons partition { person => Person.checkAgeLimit(18, person) }

    assertEquals(List(alf, fredrik), adults)
    assertEquals(List(johannes), kids)
  }
  
}
