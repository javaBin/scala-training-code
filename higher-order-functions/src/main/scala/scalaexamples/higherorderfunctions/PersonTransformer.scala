package scalaexamples.higherorderfunctions

class PersonTransformer {

  // Return a new list which contains the results of applying the
  // transformation function 'f' to all the elements of the original list
  def transformPersons[A](persons: List[Person], f: Person => A): List[A] =
    persons match {
      case p :: rest => f(p) :: transformPersons(rest, f)
      case _ => Nil
    }
  
}
