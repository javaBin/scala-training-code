package scalaexamples.patternmatching

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import scalaexamples.EmptyTest

@RunWith(classOf[JUnit4])
class MyCaseClassMatchingTest extends EmptyTest {
  
  // @Test 
  def matchMySuperType {
     val theClass: Any = FirstSubClass(1)
     
     val found = theClass match {
       // Add a match expression which return true
       case _ => false
     }
     assertTrue(found)
  }
  
  // @Test 
  def matchSubType {
     
     def matchSubType(myType: MyCaseClass) = myType match {
       // Add match expressions which make the following code pass.
       case _ => sys.error("Should never reach this")
     }

     // You should not change the following code at all. Only add matches which will make the tests match.
     var theClass: MyCaseClass = FirstSubClass(10)
     var foundElement = matchSubType(theClass)
     assertEquals(10, foundElement)
     
     theClass = SecondSubClass("verdi")
     foundElement = matchSubType(theClass)
     assertEquals("verdi", foundElement)
     
     theClass = ThirdSubClass("verdi", List(1, 2))
     foundElement = matchSubType(theClass)
     assertEquals(List(1, 2), foundElement)
     
     theClass = FourthSubClass("verdi", FirstSubClass(11))
     foundElement = matchSubType(theClass)
     assertEquals(11, foundElement)
  }
  
  // @Test 
  def matchWithExplicitType {
     val theClass: MyCaseClass = FourthSubClass("verdi", FirstSubClass(11))

     val foundElement: Option[FirstSubClass] = theClass match {
       // Add a match expression which make the following assertion true. Use Option type
       case _ => None
     }
     
     assertEquals(FirstSubClass(11), foundElement.get)
  }

}
