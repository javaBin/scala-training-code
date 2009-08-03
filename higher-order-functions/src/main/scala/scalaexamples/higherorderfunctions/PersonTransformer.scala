package scalaexamples.higherorderfunctions

class PersonTransformer {

  def transformPersons[A](l: List[Person], f: Person => A): List[A] = {
    l match {
      case p :: rest => f(p) :: transformPersons(rest, f)
      case _ => Nil
    }
  }
  
}
