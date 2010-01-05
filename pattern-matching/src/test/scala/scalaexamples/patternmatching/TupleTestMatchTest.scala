package scalaexamples.patternmatching

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import scalaexamples.EmptyTest

@RunWith(classOf[JUnit4])
class TupleTestMatchTest extends EmptyTest {
  
  @Test def matchOnTupes {
    val simpleTuple: Any = (1, "string")

    simpleTuple match {
      // Match on the tuple, and assert that its the same => assertEquals(simpleTuple, (one, two))
      case (one, two) => assertEquals(simpleTuple, (one, two))
      case _ => error("Couldnt match it")
    }
  }
  
  @Test def matchOnTupesWithGuard {
    val simpleTuple: Any = (1, "string")

    simpleTuple match {
      case (one, _) if one != 1 => assertEquals(2, one)
      // Comment in this line and make this run, (hint create guard on the previous match)
      case (one, _) => assertEquals(1, one)
      case _ => error("Couldnt match it")
    }
  }

  @Test def matchOnLargerTuple{
    val simpleTuple: Any = (1, "string", false)
    
    simpleTuple match {
      // Match on the tuple, and assert with assertFalse(three)
      case (one, two, three: Boolean) => assertFalse(three)
      case (one, two, three: String) => error("this is not a Tuple2")
      case _ => error("Couldnt match it")
    }
  }
}
