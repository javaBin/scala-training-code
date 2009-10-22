package scalaexamples.quiz

/**
 * Only use this if you think you have spent too much time solving the XML parsing problem.
 */
object MockQuiz extends QuizProvider {

  val quiz =
             Quiz("The Example Quiz", 
                  List(Question("In which continent is the country Japan located?",
                                List(Answer("Asia",true), 
                                     Answer("Europe",false), 
                                     Answer("Africa",false), 
                                     Answer("America",false)
                                     )
                                ),
                       Question("Which one cannot swim?",
                                List(Answer("Tuna",true), 
                                     Answer("Cow",false), 
                                     Answer("Whale",false), 
                                     Answer("Lobster",false)
                                     )
                                )
                       )
             )
  
}
