package scalaexamples.patternmatching

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class RegexMatchingTest extends EmptyTest {
  
  @Test def matchEntireString {
    val string = "This is the string to find a match for."
    val matchRegex = "(.+)".r
    
    val mathedElement = string match {
      case matchRegex(firstElement) => firstElement
      //case s => s
      case _ => "Failed"
    }
    
    assertEquals(string, mathedElement)
  }
  
  
  @Test def matchFirstPartOfString {
    val start = "This is"
    val string = start + " the string to find a match for."
    // val matchRegex = """(.{7}).*""".r
    val matchRegex = """^(\w+\s\w+).*""".r
    
    val mathedElement = string match {
      case matchRegex(firstElement) => firstElement
      case _ => "Failed"
    }
    
    assertEquals(start, mathedElement)
  }
  
  @Test def matchFirstAndLastWordOfString {
    val start = "This"
    val end = "for"
    val string = start + " is the string to find a match " + end
    val matchRegex = """^(\w+).*?(\w+)$""".r
    
    val (first, last) = string match {
      case matchRegex(firstElement, lastElement) => (firstElement, lastElement)
      case _ => "Failed"
    }
    
    assertEquals(start, first)
    assertEquals(end, last)
  }

}
