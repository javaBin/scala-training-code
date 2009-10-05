package scalaexamples.patternmatching

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class TypeMatchingTest extends EmptyTest {
  
  // @Test 
  def matchOnType {
	val elements = List(23, "Hello", 8.5, 'q') 
	for (element <- elements) { 
	  element match { 
	    // Make test run, and assert on types, e.g. " => assertEquals(23, integer)" or " => assertEquals("Hello", s)"
	    case other => error("Should match other on type")
	 }
	}
  }

}
