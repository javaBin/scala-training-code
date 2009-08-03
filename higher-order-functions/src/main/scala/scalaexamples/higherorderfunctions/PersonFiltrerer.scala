package scalaexamples.higherorderfunctions

class PersonFiltrerer {

  def filtrerPersoner(l: List[Person], f: Person => Boolean): List[Person] = {
    l match {
      case p :: rest if f(p) => p :: filtrerPersoner(rest, f)
      case p :: rest => filtrerPersoner(rest, f)
      case _ => Nil
    }
  }
  
}
