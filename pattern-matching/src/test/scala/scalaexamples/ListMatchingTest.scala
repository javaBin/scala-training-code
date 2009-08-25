package scalaexamples

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class ListMatchingTest {

  @Test def matchFirstElementOfList {
    val list = List("Scala", "is", "powerful")
    val mathedElement = list match {
      //case List(firstElement, lastElement) => firstElement
      case List(firstElement, _ *) => firstElement
      case _ => "failed"
    }
    
    assertEquals(list(0), mathedElement)
  }
  
  @Test def matchSecondElementOfList {
	val list = List("Scala", "is", "powerful")
    val mathedElement = list match {
      //case List(firstElement, middle, lastElement) => middle
      //case List(_, middle, _) => middle
      case List(_, middle, _ *) => middle
      case _ => "failed"
    }

    assertEquals(list(1), mathedElement)
  }

  
  @Test def matchNestedLists {
	val list = List("Scala", "is", "powerful", List("Indeed", "it", "is"))
    val mathedElement = list match {
      case List(_, _, _, sublist) => sublist
      case _ => "failed"
    }

    assertEquals(list(3), mathedElement)
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
