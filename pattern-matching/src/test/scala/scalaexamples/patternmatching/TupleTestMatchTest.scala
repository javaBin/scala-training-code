package scalaexamples.patternmatching

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import scalaexamples.EmptyTest

@RunWith(classOf[JUnit4])
class TupleTestMatchTest extends EmptyTest {
  
  // @Test
  def matchOnTupes {
    val simpleTuple: Any = (1, "string")

    simpleTuple match {
      // Match on the tuple, and assert that its the same => assertEquals(simpleTuple, (one, two))
      case _ => sys.error("Couldnt match it")
    }
  }
  
  // @Test
  def matchOnTupesWithGuard {
    val simpleTuple: Any = (1, "string")

    simpleTuple match {
      case (one, _) => assertEquals(2, one)
      // Comment in this line and make this run, (hint create guard on the previous match, so that it won't hit)
      // case (one, _) => assertEquals(1, one)
      case _ => sys.error("Couldnt match it")
    }
  }

  // @Test
  def matchOnLargerTuple{
    val simpleTuple: Any = (1, "string", false)
    
    simpleTuple match {
      // Match on the tuple, and assert with assertFalse(three)
      case (one, two, three: String) => sys.error("this is not a Tuple3 with last element Boolean")
      case _ => sys.error("Couldnt match it")
    }
  }
}
