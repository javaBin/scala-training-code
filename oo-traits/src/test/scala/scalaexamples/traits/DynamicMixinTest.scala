package scalaexamples.traits

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class DynamicMixinTest extends EmptyTest {
  
  @Test def mixInTraitTest {
    val myElement = new Element(0) with MethodTrait
    
    // Make the following compile and run
    
    assertEquals("a value", myElement.mixedInMethod)
    val anotherElement = new Element(0) with MethodTrait { override val mixedInMethod = "another value" }
    assertEquals("another value", anotherElement.mixedInMethod)
  }
  
  
  @Test def mixInInterfaceTest {
    // Make the following compile and run
    
    val myElement = new Element(0) with InterfaceTrait {
       def getSomeString = "Something"
    }
    assertNotNull(myElement.getSomeString)
  }
  
  
  @Test def stackableTraitTest {
   // Hint make your own class here, which extends Element
    class ElementWithStackableTrait(value: Int) extends Element(value) with SubClassTrait
    val element = new ElementWithStackableTrait(1)
    assertEquals("stacked toString, super toString is 'anIntValue is 1'", element.toString)
  }
  

}
