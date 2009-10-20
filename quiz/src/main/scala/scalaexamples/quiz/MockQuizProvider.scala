package scalaexamples.quiz

object MockQuiz extends QuizProvider {

  val quiz =
	  		Quiz("The Example Quiz", 
                  List(Question("In which continent is the country Japan located?",
                                List(Answer("Asia",true), 
                                     Answer("Europe",false), 
                                     Answer("Africa",false), 
                                     Answer("America",false)
                                	)
                  				)
                       	)
                 )
  
}
