package scalaexamples.quiz.swing

import scala.swing._

class SwingGame(quiz: Quiz) extends MainFrame {

  size = (500, 600)
  setLocationRelativeTo(this)
  title = quiz.title
  visible = true
  
}
