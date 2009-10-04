package scalaexamples.patternmatching

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class ListMatchingTest extends EmptyTest  {

  val list = List("Scala", "is", "powerful")
  
  // @Test
  def matchFirstElementOfList {
    
    // matchedElement must find the first element. It can also skip the rest (if you want to)
    val mathedElement = list match {
      case _ => "failed"
    }
    
    assertEquals(list(0), mathedElement)
  }
  
  // @Test 
  def matchSecondElementOfList {
    
    // matchedElement should fint the second element of the list. 
    // You may ignore the first element and any subsequent elements if you want
    val mathedElement = list match {
      //case List(firstElement, middle, lastElement) => middle
      case _ => "failed"
    }

    assertEquals(list(1), mathedElement)
  }

  
  // @Test 
  def matchNestedLists {
	val nestedList = list :: List("Indeed", "it", "is")
	// Same as list("Scala", "is", "powerful", List("Indeed", "it", "is")). 
 
	// A side note here. If you want only one list use "list ::: List("Indeed", "it", "is")" 
	// Which adds the entire list and concateneates them.
                                                                   
	// You must fint the sublist to make the test pass.
    val mathedElement = nestedList match {
      case _ => "failed"
    }

    assertEquals(nestedList(3), mathedElement)
  }
  
  // @Test 
  def matchNestedElementOfList {
    val subList = List("Indeed", "it", "is")
	val list = List("Scala", "is", "powerful", subList)
 
	// Here you must find the first element of the second sublist
    val mathedElement = list match {
      case _ => "failed"
    }
    assertEquals(subList(0), mathedElement)
  }
  
  
}
