package scalaexamples.patternmatching

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class TupleTestMatchTest extends EmptyTest {
  
  @Test def matchOnTupes {
    val simpleTuple: Any = (1, "string")

    simpleTuple match {
      // Comment out next line
      case (one, two) => assertEquals(simpleTuple, (one, two))
      case _ => error("Couldnt match it")
    }
  }
  
  @Test def matchOnTupesWithGuard {
    val simpleTuple: Any = (1, "string")

    simpleTuple match {
      // Comment out next line
      case (one, _) if one == 1 => assertEquals(1, one)
      case (one, _) => assertEquals(2, one)
      case _ => error("Couldnt match it")
    }
  }

  @Test def matchOnLargerTuple{
    val simpleTuple: Any = (1, "string", false)
    
    simpleTuple match {
      // Comment out next line
      case (one, two, three: Boolean) => assertFalse(three)
      case (one, two) => error("this is not a Tuple2")
      case _ => error("Couldnt match it")
    }
  }
}
