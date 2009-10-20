package scalaexamples.quiz

import xml._

object QuizGame {
  
  def main(args: Array[String]) {
    val quiz = new XmlQuizProvider("src/main/resources/quiz.xml").quiz
    new console.ConsoleGame(quiz)
  }

}
