package scalaexamples

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class MyCaseClassMatching {
  
  @Test def matchMySuperType {
     val theClass: MyCaseClass = FirstSubClass(1)
     
     val found = theClass match {
       case s: MyCaseClass => true
     }
     assertTrue(found)
  }
  
  @Test def matchSubType {
     
     def mathSubType(myType: MyCaseClass) = myType match {
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
       case FirstSubClass(value) => None
       case SecondSubClass(one) => None
       case ThirdSubClass(_, elements) => None
       case FourthSubClass(value, element) => Some(element)
     }
     
     assertEquals(FirstSubClass(11), foundElement.get)
  }

}
