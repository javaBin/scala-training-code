package scalaexamples.higherorderfunctions

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class PersonFilterTest extends EmptyTest {
  
  val personFilter = new PersonFilter
  
  val alf = Person("Alf Kristian", 30)
  val fredrik = Person("Fredrik", 33)
  val johannes = Person("Johannes", 0)
  val persons = alf :: fredrik :: johannes :: Nil
  
  val all = (p: Person) => true
  val none = (p: Person) => false
  
  @Test 
  def testEmptyList {
    assertEquals(Nil, personFilter.filterPersons(Nil, none))
    assertEquals(Nil, personFilter.filterPersons(Nil, all))
  }

  @Test 
  def testAll {
    assertEquals(persons, personFilter.filterPersons(persons, all))
  }
  
  @Test 
  def testNone {
    assertEquals(Nil, personFilter.filterPersons(persons, none))
  }
  
  @Test 
  def testOld {
    assertEquals(alf :: fredrik :: Nil, personFilter.filterPersons(persons, _.age > 18))
  }

  @Test 
  def testYoung {
    assertEquals(johannes :: Nil, personFilter.filterPersons(persons, _.age <= 18))
  }

}
