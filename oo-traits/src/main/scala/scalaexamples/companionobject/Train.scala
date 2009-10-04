package scalaexamples.companionobject


class Train(val passengers: List[String], val conductor: Option[String]) {
  
  def this(passengers: List[String]) = this(passengers, None)
}

object Train {
  
  def apply(passengerName: Array[String]) = new Train(passengerName.toList)
  def apply(passengerName: String*) = new Train(passengerName.toList)
  def apply(conductor: Option[String], passengerName: String*) = new Train(passengerName.toList, conductor)
  
}