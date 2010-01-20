package scalaexamples.quiz.console

import scalaexamples.quiz.{Answer, Question, Quiz}

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
    var answer: Option[Answer] = None
    while (answer == None) {
      answer = try { 
        println("What is your answer:")
        val res = readLine.toInt - 1

        // Because q.anwers.apply(0) is implemented with drop(n).head it allows negative indices.
        // Must check for range.
        if (q.answers.isDefinedAt(res)) Some(q.answers(res))
        else {
          println("Incorrect answer, not in range");
          None
        }
      }
      catch {
        case e => println("Incorrect answer"); None
      }
     }
    answer.get
  }
  
}
