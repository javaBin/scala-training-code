package scalaexamples.intro

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class CreateStuffTest {

  val stuff = new Stuff
  
  @Test def accessOverridenToString {
    assertEquals("Stuff", stuff.toString)
  }
  
  @Test def accessVal {
  	assertEquals("This is a constant", stuff.const)
  	// stuff.const = "Must give compile error"
  }
  
  @Test def changeVar {
    assertEquals("This is a variable", stuff.variable)
    val text = "Changed it"
    stuff.variable = text
    assertEquals(text, stuff.variable)
  }
  
  @Test def accessStuffObject {
    assertEquals("StuffObject", Stuff.getString)
  }
  
}
