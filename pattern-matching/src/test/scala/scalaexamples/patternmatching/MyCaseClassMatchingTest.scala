package scalaexamples.patternmatching

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import scalaexamples.EmptyTest

@RunWith(classOf[JUnit4])
class MyCaseClassMatchingTest extends EmptyTest {
  
  @Test def matchMySuperType {
     val theClass: Any = FirstSubClass(1)
     
     val found = theClass match {
       // Add a match expression which return true
       case s: MyCaseClass => true
       case _ => false
     }
     assertTrue(found)
  }
  
  @Test def matchSubType {
     
     def mathSubType(myType: MyCaseClass) = myType match {
       // Add match expressions which make the following code pass.
       case FirstSubClass(value) => value
       case SecondSubClass(one) => one
       case ThirdSubClass(_, elements) => elements
       case FourthSubClass(value, FirstSubClass(element)) => element
     }

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
  
  @Test def matchWithExplicitType {
     val theClass: MyCaseClass = FourthSubClass("verdi", FirstSubClass(11))

     val foundElement: Option[FirstSubClass] = theClass match {
       // Add a match expression which make the following assertion true. Use Option type
       case FirstSubClass(value) => None
       case SecondSubClass(one) => None
       case ThirdSubClass(_, elements) => None
       case FourthSubClass(value, element) => Some(element)
       case _ => None
     }
     
     assertEquals(FirstSubClass(11), foundElement.get)
  }

}
