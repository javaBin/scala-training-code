package scalaexamples.higherorderfunctions

class PersonTransformer {

  def transformPersons[A](persons: List[Person], f: Person => A): List[A] =
    persons match {
      case p :: rest => f(p) :: transformPersons(rest, f)
      case _ => Nil
    }
  
}
