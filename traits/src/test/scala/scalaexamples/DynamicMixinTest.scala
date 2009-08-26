package scalaexamples

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class DynamicMixinTest {
  
  @Test def mixInTraitTest {
    val myElement = new Element(0) with MethodTrait
    assertEquals("a value", myElement.mixedInValue)
    
    val anotherElement = new Element(0) with MethodTrait { override val mixedInValue = "another value" }
    assertEquals("another value", anotherElement.mixedInValue)
  }

}
