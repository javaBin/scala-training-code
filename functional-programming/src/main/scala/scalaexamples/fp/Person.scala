package scalaexamples.fp

case class Person(name: String, age: Int)

object Person {

  def getName: Person => String =
    (p: Person) => p.name

  def checkAgeLimit: (Int, Person) => Boolean =
    (ageLimit: Int, p: Person) => p.age >= ageLimit

}
