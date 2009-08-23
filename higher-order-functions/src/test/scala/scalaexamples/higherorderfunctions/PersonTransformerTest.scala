package scalaexamples.higherorderfunctions

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class PersonTransformerTest {

  val personTransformer = new PersonTransformer

  val alf = Person("Alf Kristian", 30)
  val fredrik = Person("Fredrik", 33)
  val johannes = Person("Johannes", 0)
  val persons = alf :: fredrik :: Nil

  @Test 
  def testEquals {
    assertEquals(persons, personTransformer.transformPersons(persons, (p: Person) => p))
  }

  @Test
  def testFirstName {
    val expected = persons.map(_.name)
    assertEquals(expected, personTransformer.transformPersons(persons, (p: Person) => p.name))
  }
  
  @Test
  def testAge {
    val expected = persons.map(_.age)
    assertEquals(expected, personTransformer.transformPersons(persons, (p: Person) => p.age))
  }
  
}
