package scalaexamples.oo_traits

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class CompanionObjectTest {

  @Test def companionObjectTest {
    // Make the following compile
    val trainOne = Train("Per", "Pål")
    assertEquals(List("Per", "Pål"), trainOne.passengers)
    assertTrue(trainOne.conductor.isEmpty)
    
    val trainTwo = Train(Array("Espen"))
    assertEquals(List("Espen"), trainTwo.passengers)
    assertTrue(trainTwo.conductor.isEmpty)
    
    val trainObject = Train
    val trainThree = trainObject(Array("Espen"))
    assertEquals(List("Espen"), trainTwo.passengers)
    assertTrue(trainThree.conductor.isEmpty)

    val trainFour = trainObject.apply(Some("conductor"), "Espen")
    assertEquals(List("Espen"), trainTwo.passengers)
    assertTrue(trainFour.conductor.isDefined)
  }
  
  @Test def constructorTest {
    
  }
  
}

class Train(val passengers: List[String], val conductor: Option[String]) {
  
  def this(passengers: List[String]) = this(passengers, None)
}

object Train {
  
  def apply(passengerName: Array[String]) = new Train(passengerName.toList)
  def apply(passengerName: String*) = new Train(passengerName.toList)
  def apply(conductor: Option[String], passengerName: String*) = new Train(passengerName.toList, conductor)
  
}