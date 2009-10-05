package scalaexamples.companionobject

// Define a primary constructor which takes a list of passengers (String) and an Option(al) conductor also Sting
class Train(val passengers: List[String], val conductor: Option[String]) {

  // You should also define an auxiliary constructor, which ignores the conductor
  def this(passengers: List[String]) = this(passengers, None)
}

object Train {
  
  // make a method which makes Train(Array("Alf", "Fredrik")) compile
  def apply(passengerName: Array[String]) = new Train(passengerName.toList)

  // make a method which makes Train("Alf", "Fredrik") compile
  def apply(passengerName: String*) = new Train(passengerName.toList)
  
  // make a method which makes Train(Some("Conductor"), "Alf", "Fredrik") compile
  def apply(conductor: Option[String], passengerName: String*) = new Train(passengerName.toList, conductor)
  
}