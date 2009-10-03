package scalaexamples.higherorderfunctions

class PersonFilter {

  // Return a new list of persons containing the elements from the original
  // list that satisfy the filter method (f == true)
  def filterPersons(persons: List[Person], f: Person => Boolean): List[Person] =
    persons match {
      case p :: rest if f(p) => p :: filterPersons(rest, f)
      case p :: rest => filterPersons(rest, f)
      case _ => Nil
    }
  
}
