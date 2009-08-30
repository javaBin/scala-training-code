package scalaexamples.functiontalprogramming

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class ListTest {

  @Test def testListEquality {
    val list1 = List(1, 2, 3)
    val list2 = 1 :: list1
    
    assertNotSame(list2, list1)
    assertSame(list2.tail, list1)

    val newList = list1.map(_.toInt)
    assertNotSame(newList, list1)
    assertEquals(newList, list1)
  }
  
}
