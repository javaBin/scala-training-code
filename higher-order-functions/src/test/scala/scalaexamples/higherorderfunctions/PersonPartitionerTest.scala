package scalaexamples.higherorderfunctions

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

// Comment in the tests below and make them run and pass

@RunWith(classOf[JUnit4])
class PersonPartitionerTest extends EmptyTest {

  val partitioner = new PersonPartitioner

  val alf = Person("Alf", 30, List(EmailAddress("alf.kristian@gmail.com")))
  val fredrik = Person("Fredrik", 33, List(EmailAddress("fredrik@vraalsen.no"), EmailAddress("fvr@knowit.no")))
  val johannes = Person("Johannes", 0, Nil)

  val persons = alf :: fredrik :: johannes :: Nil

  @Test
  def testAgeLimit {
    // Pass in a function that tests whether the person is an adult
    val (adults, kids) = partitioner.partitionPersons(persons, (p: Person) => p.age >= 18)

    assertEquals(List(alf, fredrik), adults)
    assertEquals(List(johannes), kids)
  }

  @Test
  def testHasMoreThanOneEmail {
    // Pass in a function that tests whether the person is
    // a techie (2 or more e-mail addresses) or a luddite (zero or one e-mail address)
    val (techies, luddites) = partitioner.partitionPersons(persons, (p: Person) => p.emailAddresses match {
      case List(_, _, _*) => true
      case _ => false
    })

    assertEquals(List(fredrik), techies)
    assertEquals(List(alf, johannes), luddites)
  }

}
