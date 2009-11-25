package scalaexamples.higherorderfunctions

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

// Comment in the tests below and make them run and pass

@RunWith(classOf[JUnit4])
class PersonTransformerTest extends EmptyTest {

  val personTransformer = new PersonTransformer

  val alf = Person("Alf", 30, List(EmailAddress("alf.kristian@gmail.com")))
  val fredrik = Person("Fredrik", 33, List(EmailAddress("fredrik@vraalsen.no"), EmailAddress("fvr@knowit.no")))
  val johannes = Person("Johannes", 0, Nil)

  val persons = alf :: fredrik :: johannes:: Nil

  // @Test 
  def testEquals {
    // Pass in a function that returns the list of persons unchanged
    // assertEquals(persons, personTransformer.transformPersons(persons, error("")))
  }

  // @Test
  def testName {
    // Pass in a function transforming the list to the names of the persons
    val expected = List("Alf", "Fredrik", "Johannes")
    // assertEquals(expected, personTransformer.transformPersons(persons, error("")))
    ()
  }
  
  // @Test
  def testAge {
    // Pass in a function transforming the list to the ages of the persons
    val expected = List(30, 33, 0)
    // assertEquals(expected, personTransformer.transformPersons(persons, error("")))
    ()
  }
  
}
