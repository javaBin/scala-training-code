package scalaexamples.higherorderfunctions

class PersonPartitioner {

  // Implement the method partitionPersons that takes in
  // a list of persons and a function from Person to Boolean,
  // applies the function to each Person and
  // returns two new lists, one with the persons for which the function returns true
  // and one with the persons for which the function returns false
  def partitionPersons(persons: List[Person], f: Person => Boolean): (List[Person], List[Person]) =
    persons match {
      case p :: rest =>
        val (ftrue, ffalse) = partitionPersons(rest, f)
        if (f(p)) (p :: ftrue, ffalse) else (ftrue, p::ffalse)
      case Nil => (Nil, Nil)
    }

  def tailPartition[A](l: List[A], f: A => Boolean): (List[A], List[A]) = {
    def helper(l: List[A], f: A => Boolean, ftrue: List[A], ffalse: List[A]): (List[A], List[A]) = {
      if (l.isEmpty) {
        return (ftrue.reverse, ffalse.reverse)
      }
      val h = l.head
      val (ftrue2, ffalse2) = if (f(h)) (h :: ftrue, ffalse) else (ftrue, h :: ffalse)
      helper(l.tail, f, ftrue2, ffalse2)
    }

    helper(l, f, Nil, Nil)
  }

}
