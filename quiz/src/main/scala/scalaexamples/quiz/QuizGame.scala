package scalaexamples.quiz

import xml._

/**
 * Main class. Parse XML and start the quiz type of your choice.
 */
object QuizGame {
  
  def main(args: Array[String]) {
    val quiz = new XmlQuizProvider("quiz.xml").quiz
    new console.ConsoleGame(quiz)
    new swing.SwingGame(quiz)
  }

}
