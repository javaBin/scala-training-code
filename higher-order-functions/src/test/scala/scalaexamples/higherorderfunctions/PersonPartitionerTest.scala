package scalaexamples.higherorderfunctions

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class PersonPertitionerTest extends EmptyTest {

  val partitioner = new PersonPartitioner

  val alf = Person("Alf Kristian", 30)
  val fredrik = Person("Fredrik", 33)
  val johannes = Person("Johannes", 0)
  val persons = alf :: fredrik :: johannes :: Nil

  @Test
  def testAgeLimit {
    val (adults, kids) = partitioner.partition(persons, (p: Person) => p.age >= 18)
    assertEquals(List(alf, fredrik), adults)
    assertEquals(List(johannes), kids)
  }

}
