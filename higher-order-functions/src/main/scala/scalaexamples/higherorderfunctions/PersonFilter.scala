package scalaexamples.higherorderfunctions

class PersonFilter {

  // Implement the method filterPersons that takes in
  // a list of persons and a function from Person to Boolean,
  // applies the function to each Person and
  // returns a new list of the persons for which the function returns true
  def filterPersons(persons: List[Person], f: Person => Boolean): List[Person] =
    persons match {
      case p :: rest if f(p) => p :: filterPersons(rest, f)
      case p :: rest => filterPersons(rest, f)
      case _ => Nil
    }
  
}
