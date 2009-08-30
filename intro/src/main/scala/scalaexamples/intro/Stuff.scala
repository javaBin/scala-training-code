package scalaexamples.intro

class Stuff {
  
  override def toString = "Stuff"
  
  val const = "This is a constant"
  var variable = "This is a variable"
  
  def sayHello(name: String) = "Hello " + name
  
  def printHello(name: String) {
    println("Hello " + name)
  }

}

object Stuff {
  
  def getString = "StuffObject"
  
}
