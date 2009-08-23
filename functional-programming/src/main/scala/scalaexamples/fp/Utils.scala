package scalaexamples.fp

object Utils {
  
    def partitionByAge(persons: List[Person], ageLimit: Int) = persons partition (_.age < ageLimit)

    def getNames(persons: List[Person]) = persons map (_.name)
    
}
