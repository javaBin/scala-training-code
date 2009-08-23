package scalaexamples.fp

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
    val (kids, adults) = Utils.partitionByAge(persons, 18)
    assertEquals(List(johannes), kids)
    assertEquals(List(alf, fredrik), adults)
  }
  
}
