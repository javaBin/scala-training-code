package scalaexamples.higherorderfunctions

import junit.framework.TestCase
import junit.framework.Assert._

class PersonFilterTest extends TestCase("PersonFilter") {
  
  val personFilter = new PersonFilter
  
  val alf = Person("Alf Kristian", "Støyle", 30)
  val fredrik = Person("Fredrik", "Vraalsen", 33)
  val persons = alf :: fredrik :: Nil
  
  val all = (p: Person) => true
  val none = (p: Person) => false
  
  def testEmptyList {
    assertEquals(Nil, personFilter.filterPersons(Nil, none))
    assertEquals(Nil, personFilter.filterPersons(Nil, all))
  }

  def testAll {
    assertEquals(persons, personFilter.filterPersons(persons, all))
  }
  
  def testNone {
    assertEquals(Nil, personFilter.filterPersons(persons, none))
  }
  
  def testOld {
    assertEquals(fredrik :: Nil, personFilter.filterPersons(persons, _.age > 30))
  }

  def testYoung {
    assertEquals(alf :: Nil, personFilter.filterPersons(persons, _.age <= 30))
  }

}
