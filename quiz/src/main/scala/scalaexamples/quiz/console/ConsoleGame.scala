package scalaexamples.quiz.console

class ConsoleGame(quiz: Quiz) {

  println("Welcome to our faboulus quiz called '" + quiz.title + "'")
  var correctAnswer = 0
  for (q <- quiz.questions) {
    println("\n" + q.text)
    q.answers.zipWithIndex.foreach{case (a, i) => println(i + 1 + ". " + a.text)}

    correctAnswer += { 
      if (readAnswer(q).correct) {
        println("Correct")
        1
      }
      else {
        println("Incorrect")
        0
      }
     }
  }
  println("\nYou got " + correctAnswer + " correct of " + quiz.questions.length + " possible")
  
  private def readAnswer(q: Question) = {
    var answer: Answer = null
    while (answer == null) {
      answer = try { 
        println("Enter you answer:")
        val res = readLine.toInt - 1
        q.answers(res)
      }
      catch {
        case e => println("Incorrect answer"); null 
      }
     }
    answer
  }
  
}
