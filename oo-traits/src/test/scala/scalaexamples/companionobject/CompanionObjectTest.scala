package scalaexamples.companionobject

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class CompanionObjectTest {

  @Test def companionObjectTest {
    // Comment in epression for expression and make them compile and run
    // val trainOne = Train("Per", "Pål")
    // assertEquals(List("Per", "Pål"), trainOne.passengers)
    // assertTrue(trainOne.conductor.isEmpty)
    
    // val trainTwo = Train(Array("Espen"))
    // assertEquals(List("Espen"), trainTwo.passengers)
    // assertTrue(trainTwo.conductor.isEmpty)
    
    // val trainObject = Train
    // val trainThree = trainObject(Array("Espen"))
    // assertEquals(List("Espen"), trainTwo.passengers)
    // assertTrue(trainThree.conductor.isEmpty)

    // val trainFour = trainObject.apply(Some("conductor"), "Espen")
    // assertEquals(List("Espen"), trainTwo.passengers)
    // assertTrue(trainFour.conductor.isDefined)
  }
  
}