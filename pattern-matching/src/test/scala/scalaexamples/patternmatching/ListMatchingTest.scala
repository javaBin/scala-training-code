package scalaexamples.patternmatching

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class ListMatchingTest {

  val list = List("Scala", "is", "powerful")
  
  @Test def matchFirstElementOfList {
    val mathedElement = list match {
      //case List(firstElement, lastElement) => firstElement
      case List(firstElement, _ *) => firstElement
      case _ => "failed"
    }
    
    assertEquals(list(0), mathedElement)
  }
  
  @Test def matchSecondElementOfList {
    val mathedElement = list match {
      //case List(firstElement, middle, lastElement) => middle
      //case List(_, middle, _) => middle
      case List(_, middle, _ *) => middle
      case _ => "failed"
    }

    assertEquals(list(1), mathedElement)
  }

  
  @Test def matchNestedLists {
	val nestedList = list :: List("Indeed", "it", "is")
	// Same as list("Scala", "is", "powerful", List("Indeed", "it", "is")). If you want only one list use "list ::: List("Indeed", "it", "is")"
    val mathedElement = nestedList match {
      case List(_, _, _, sublist) => sublist
      case _ => "failed"
    }

    assertEquals(nestedList(3), mathedElement)
  }
  
  @Test def matchNestedElementOfList {
    val subList = List("Indeed", "it", "is")
	val list = List("Scala", "is", "powerful", subList)
    val mathedElement = list match {
      case List(_, _, _, List(matched, _ *)) => matched
      case _ => "failed"
    }
    assertEquals(subList(0), mathedElement)
  }
  
  
}
