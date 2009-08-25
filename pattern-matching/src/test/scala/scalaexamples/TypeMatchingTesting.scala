package scalaexamples

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class TypeMatchingTesting {
  
  @Test def matchOnType {
	val elements = List(23, "Hello", 8.5, 'q') 
	for (element <- elements) { 
	  element match { 
	    // Comment out every other line than other
	    case i: Int => assertEquals(23, i)
	    case s: String => assertEquals("Hello", s)
	    case f: Double => assertEquals(8.5, f)
	    case other => assertEquals('q', other)
	 }
	}
  }

}
