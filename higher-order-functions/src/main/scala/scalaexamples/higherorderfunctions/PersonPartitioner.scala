package scalaexamples.higherorderfunctions

class PersonPartitioner {

  def partition(persons: List[Person], f: Person => Boolean): (List[Person], List[Person]) =
    persons match {
      case p :: rest =>
        val (ftrue, ffalse) = partition(rest, f)
        if (f(p)) (p :: ftrue, ffalse) else (ftrue, p::ffalse)
      case Nil => (Nil, Nil)
    }

}
