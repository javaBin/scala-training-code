package scalaexamples.firstclassfunctions

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import scalaexamples.EmptyTest

// Comment in the tests below and make them run and pass

@RunWith(classOf[JUnit4])
class PersonTest extends EmptyTest {

  val alf = Person("Alf", 30, List(EmailAddress("alf.kristian@gmail.com")))
  val fredrik = Person("Fredrik", 33, List(EmailAddress("fredrik@vraalsen.no"), EmailAddress("fvr@knowit.no")))
  val johannes = Person("Johannes", 0, Nil)

  val persons = List(alf, fredrik, johannes)

  @Test
  def testAdults {
    // Find all adults
    val adults = persons filter (_.age >= 18)

    assertEquals(List(alf, fredrik), adults)
  }

  @Test
  def testName {
    // Find the names of all persons
    val names = persons map (_.name)
    
    assertEquals(List("Alf", "Fredrik", "Johannes"), names)
  }

  @Test def testNamesOfAdults {
    // Find the names of all adults
    val names = persons filter (_.age >= 18) map (_.name)

    assertEquals(List("Alf", "Fredrik"), names)
  }

  @Test
  def testAgeLimit {
    // Split the list of persons into two new lists containing adults and kids
    val (adults, kids) = persons partition (_.age >= 18)

    assertEquals(List(alf, fredrik), adults)
    assertEquals(List(johannes), kids)
  }

  @Test
  def testHasMultipleEmails {
    // Split the list of persons into two new lists containing
    // techies (more than one email address) and luddites (zero or only one email address)
    val (techies, luddites) = persons.partition(_.emailAddresses.size > 1)

    assertEquals(List(fredrik), techies)
    assertEquals(List(alf, johannes), luddites)
  }

  @Test
  def testFindByName {
    // Find the person named "Johannes"
    val name = "Johannes"
    val person = persons find(_.name == name)
    
    person match {
      case Some(person) => assertEquals(johannes, person)
      case _ => error("No match")
    }
  }
  
  @Test
  def testFindByName2 {
    // Find the person named "Jon-Anders" (should not match)
    val name = "Jon-Anders"
    val person = persons find(_.name == name)

    person match {
      case None => "OK"
      case _ => error("Unexpected match")
    }
  }

  @Test
  def testFindEmailAddressesByName {
    // Find the e-mail addresses of the person named "Alf"
    val name = "Alf"
    val addresses = persons find(_.name == name) map (_.emailAddresses)
    
    addresses match {
      case Some(addresses) => assertEquals(alf.emailAddresses, addresses)
      case _ => error("No match")
    }
  }

  @Test
  def testFindPersonByEmail {
    // Find the person who has the e-mail address "fredrik@vraalsen.no"
    val address = EmailAddress("fredrik@vraalsen.no")
    val person = persons find(_.emailAddresses exists (address ==))
    
    person match {
      case Some(person) => assertEquals(fredrik, person)
      case _ => error("No match")
    }
  }
  
  @Test
  def testGetFirstEmailAddress {
    // Create a new list of the first e-mail address of each person,
    // filtering out persons without e-mail addresses
    val addresses = persons filter (!_.emailAddresses.isEmpty) map (_.emailAddresses.head)

    assertEquals(List(alf.emailAddresses.head, fredrik.emailAddresses.head), addresses)
  }

  @Test
  def testGetFirstEmailAddress2 {
    // Create a map from each persons name to their e-mail addresses,
    // filtering out persons without e-mail addresses
    // Hint: Use folding to accumulate...
    val emptyMap: Map[String, List[EmailAddress]] = Map()
    val nameToEmail = persons.filter(!_.emailAddresses.isEmpty).foldLeft(emptyMap){(m, p) => m + (p.name -> p.emailAddresses)}

    assertEquals(Map(alf.name -> alf.emailAddresses, fredrik.name -> fredrik.emailAddresses), nameToEmail)
  }

}
