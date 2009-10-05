package scalaexamples.intro

class Stuff {
  
  // Override the toString method to say "Stuff"
  override def toString = "Stuff"
  
  // Define a constant saying "This is a constant"
  val const = "This is a constant"
  
  // Define a variable saying "This is a variable"
  var variable = "This is a variable"
  
  // Define a method saying "Hello " to whatever input
  def sayHello(name: String) = "Hello " + name
  
  // Deine a method which prints hello, returning Unit (void)
  def printHello(name: String) {
    println("Hello " + name)
  }

}

object Stuff {
  
  // Define a method that returns "StuffObject"
  def getString = "StuffObject"
  
}
