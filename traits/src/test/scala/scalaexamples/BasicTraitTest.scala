package scalaexamples

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import util.Sorting

@RunWith(classOf[JUnit4])
class BasicTraitTest {
  
  @Test def mixInTraitTest {
    val myElement = new Element(0) with MethodTrait
    assertEquals("a value", myElement.mixedInValue)
    
    val anotherElement = new Element(0) with MethodTrait { override val mixedInValue = "another value" }
    assertEquals("another value", anotherElement.mixedInValue)
  }
  
  val list = List(new Element(10), new Element(2))
  
  @Test def mixInOrderedTraitTest {
	  // Hint implement the Ordered interface
	  assertTrue((list(0) compare list(1)) > 0)
	  assertTrue(list(0) > list(1))
	  assertTrue(list(0) >= list(1))
	  assertFalse(list(0) < list(1))
	  assertFalse(list(0) <= list(1))
  }
  
  
  @Test def testOrderedSorting {
    val intArray = Array(2, 10, 1)

    // Check out util.Sorting
    Sorting.quickSort(intArray)
    assertEquals(List(1, 2, 10), intArray.toList)
    
    val elementArray = list.toArray
    Sorting.quickSort(elementArray)
    assertEquals(list.reverse, elementArray.toList)
  }
}
