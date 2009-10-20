package scalaexamples.quiz

object QuizGame {
  
  def main(args: Array[String]) {
    val parsed = xml.XML.loadFile("src/main/resources/quiz.xml")
    println(parsed)
  }

}
