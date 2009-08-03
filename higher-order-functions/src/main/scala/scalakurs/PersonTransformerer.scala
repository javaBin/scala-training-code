package scalakurs

class PersonTransformerer {

  def transformerPersoner[A](l: List[Person], f: Person => A): List[A] = {
    l match {
      case p :: rest => f(p) :: transformerPersoner(rest, f)
      case _ => Nil
    }
  }
  
}
