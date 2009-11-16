package scalaexamples.quiz.swing

import scala.swing._
import event._
import javax.swing.border.EmptyBorder

class SwingGame(quiz: Quiz) extends MainFrame {
  val qsize = quiz.questions.size
  assert(qsize > 0)
  
  private var currentQuestion = 0
  
  val panels = quiz.questions.map{q => 
    val buttons = q.answers.map {
      a => new RadioButton(a.text) {
        val answer = a
        reactions += {
          case b: ButtonClicked => handleRadioClick
        }
      }
    }
    new ButtonGroup(buttons: _*)
    new BoxPanel(Orientation.Vertical) {
        val allButtons = buttons
        contents += new Label(q.text)
    	contents.appendAll(buttons)
    }
  }

  val mainPanel = new BoxPanel(Orientation.Vertical) {
	  contents += panels(0)
  }

  val nextButton = new Button("Next") {
    enabled = false
	  reactions += {
	    case e: ButtonClicked =>  {
	      currentQuestion += 1
	      mainPanel.contents.remove(0)
	      mainPanel.contents.insert(0, panels(currentQuestion))
	      enabled = false
	      revalidate
	      SwingGame.this.repaint
        }
	  }
  }

  def handleRadioClick() {
    if (currentQuestion == qsize - 1) {
    	val correctAnswers = { 
    	  for {
    	    p <- panels
    		b <- p.allButtons
    		if(b.peer.isSelected && b.answer.correct)
    	} yield 0
       }.size
       resultLabel.text = "You got " + correctAnswers + " answers correct out of " + qsize
       repaint
    }
    else {
      nextButton.enabled = true
    }
  }
  
  val resultLabel = new Label(" ")
  mainPanel.contents += nextButton

  contents = new BoxPanel(Orientation.Vertical) {
    contents += mainPanel
    contents += resultLabel
    peer.setBorder(new EmptyBorder(10, 10, 10, 10))
  }
  
  setLocationRelativeTo(this)
  title = quiz.title
  visible = true
  
}
