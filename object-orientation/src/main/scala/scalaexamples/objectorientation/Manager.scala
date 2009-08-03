package scalaexamples.objectorientation

class Manager(name: String, baseSalary: Int, bonus: Int) extends Employee(name, baseSalary) {

  /* Override salary method to add bonus to base salary */
  override def salary = super.salary + bonus
  
}
