package scalaexamples

sealed abstract class MyCaseClass
case class FirstSubClass(value: Int) extends MyCaseClass
case class SecondSubClass(value: String)extends MyCaseClass
case class ThirdSubClass(value: String, elements: List[Int]) extends MyCaseClass
case class FourthSubClass(value: String, element: FirstSubClass) extends MyCaseClass
