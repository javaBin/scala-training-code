package scalaexamples.higherorderfunctions

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.{JUnit4}

@RunWith(classOf[JUnit4])
class PersonFilterTest {
  
  val personFilter = new PersonFilter
  
  val alf = Person("Alf Kristian", "Støyle", 30)
  val fredrik = Person("Fredrik", "Vraalsen", 33)
  val persons = alf :: fredrik :: Nil
  
  val all = (p: Person) => true
  val none = (p: Person) => false
  
  @Test def testEmptyList {
    assertEquals(Nil, personFilter.filterPersons(Nil, none))
    assertEquals(Nil, personFilter.filterPersons(Nil, all))
  }

  @Test def testAll {
    assertEquals(persons, personFilter.filterPersons(persons, all))
  }
  
  @Test def testNone {
    assertEquals(Nil, personFilter.filterPersons(persons, none))
  }
  
  @Test def testOld {
    assertEquals(fredrik :: Nil, personFilter.filterPersons(persons, _.age > 30))
  }

  @Test def testYoung {
    assertEquals(alf :: Nil, personFilter.filterPersons(persons, _.age <= 30))
  }

}
