package scalaexamples.firstclassfunctions

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class PersonTest extends EmptyTest {

  val alf = Person("Alf", 30, List(EmailAddress("aks@knowit.no")))
  val fredrik = Person("Fredrik", 33, List(EmailAddress("fredrik@vraalsen.no"), EmailAddress("fvr@knowit.no")))
  val johannes = Person("Johannes", 0, Nil)

  val persons = List(alf, fredrik, johannes)

  @Test def testName {
    val names = persons map (_.name)
    
    assertEquals(List("Alf", "Fredrik", "Johannes"), names)
  }

  @Test def testNamesOfAdults {
    val names = persons filter (_.age >= 18) map (_.name)

    assertEquals(List("Alf", "Fredrik"), names)
  }

  @Test def testAgeLimit {
    val (adults, kids) = persons partition (_.age >= 18)

    assertEquals(List(alf, fredrik), adults)
    assertEquals(List(johannes), kids)
  }

  @Test def testFindByName {
    val name = "Johannes"
    val person = persons find(_.name == name)
    
    person match {
      case Some(person) => assertEquals(johannes, person)
      case _ => error("No match")
    }
  }
  
  @Test def testFindEmailAddressesByName {
    val name = "Alf"
    val addresses = persons find(_.name == name) map (_.emailAddresses)
    
    addresses match {
      case Some(addresses) => assertEquals(List(EmailAddress("aks@knowit.no")), addresses)
      case None => error("No match")
    }
  }

  @Test def testFindPersonByEmail {
    val address = EmailAddress("fvr@knowit.no")
    val person = persons find(_.emailAddresses exists (address ==))
    
    person match {
      case Some(person) => assertEquals(fredrik, person)
      case _ => error("No match")
    }
  }
  
}
