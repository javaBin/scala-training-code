package scalaexamples.quiz.swing

import scala.swing._
import event._
import scalaexamples.quiz.Quiz


class SwingGame(quiz: Quiz) extends MainFrame {

  // TODO: Implement quiz game UI and logic
  
  size = (300, 200)
  setLocationRelativeTo(this)
  title = quiz.title
  visible = true
  
}
