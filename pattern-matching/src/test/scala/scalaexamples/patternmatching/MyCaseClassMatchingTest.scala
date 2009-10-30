package scalaexamples.patternmatching

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

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
     
     def mathSubType(myType: MyCaseClass) = myType match {
       // Add match expressions which make the following code pass.
       case _ => error("Should never reach this")
     }

     // You should not change the following code at all. Only add matches which will make the tests match.
     var theClass: MyCaseClass = FirstSubClass(10)
     var foundElement = mathSubType(theClass)
     assertEquals(10, foundElement)
     
     theClass = SecondSubClass("verdi")
     foundElement = mathSubType(theClass)
     assertEquals("verdi", foundElement)
     
     theClass = ThirdSubClass("verdi", List(1, 2))
     foundElement = mathSubType(theClass)
     assertEquals(List(1, 2), foundElement)
     
     theClass = FourthSubClass("verdi", FirstSubClass(11))
     foundElement = mathSubType(theClass)
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
