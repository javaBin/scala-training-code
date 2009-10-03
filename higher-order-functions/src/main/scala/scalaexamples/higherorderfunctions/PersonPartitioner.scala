package scalaexamples.higherorderfunctions

class PersonPartitioner {

  // Return two lists of persons. The first list should contain the elements
  // of the original list that satisfy the filter function (f == true) while
  // the second list should contain the elements where f == false
  def partition(persons: List[Person], f: Person => Boolean): (List[Person], List[Person]) =
    persons match {
      case p :: rest =>
        val (ftrue, ffalse) = partition(rest, f)
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
