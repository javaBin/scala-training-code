package scalaexamples.higherorderfunctions

class PersonFilter {

  def filterPersons(l: List[Person], f: Person => Boolean): List[Person] = {
    l match {
      case p :: rest if f(p) => p :: filterPersons(rest, f)
      case p :: rest => filterPersons(rest, f)
      case _ => Nil
    }
  }
  
}
