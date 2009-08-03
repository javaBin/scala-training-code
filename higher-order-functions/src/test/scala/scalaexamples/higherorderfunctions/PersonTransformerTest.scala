package scalaexamples.higherorderfunctions

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class PersonTransformerTest {

  val personTransformer = new PersonTransformer

  val alf = Person("Alf Kristian", "Støyle", 30)
  val fredrik = Person("Fredrik", "Vraalsen", 33)
  val persons = alf :: fredrik :: Nil

  @Test 
  def testEquals {
    assertEquals(persons, personTransformer.transformPersons(persons, (p: Person) => p))
  }

  @Test
  def testFirstName {
    val expected = persons.map(_.firstName)
    assertEquals(expected, personTransformer.transformPersons(persons, (p: Person) => p.firstName))
  }
  
  @Test
  def testAge {
    val expected = persons.map(_.age)
    assertEquals(expected, personTransformer.transformPersons(persons, (p: Person) => p.age))
  }
  
}
