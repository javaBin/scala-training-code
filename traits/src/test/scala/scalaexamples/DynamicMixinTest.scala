package scalaexamples

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class DynamicMixinTest {
  
  @Test def mixInTraitTest {
    val myElement = new Element(0) with MethodTrait
    assertEquals("a value", myElement.mixedInMethod)
    
    val anotherElement = new Element(0) with MethodTrait { override val mixedInMethod = "another value" }
    assertEquals("another value", anotherElement.mixedInMethod)
  }
  
  
  @Test def mixInInterfaceTest {
    val myElement = new Element(0) with InterfaceTrait {
       def getSomeString = "Something"
    }
    assertNotNull(myElement.getSomeString)
  }

}
