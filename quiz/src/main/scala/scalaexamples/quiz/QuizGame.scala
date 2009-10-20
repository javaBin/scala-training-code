package scalaexamples.quiz

import xml._

object QuizGame {
  
  def main(args: Array[String]) {
    val xmlFromFile = xml.XML.loadFile("src/main/resources/quiz.xml")
    val quiz = parseXml(xmlFromFile)
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
  }
  
  def readAnswer(q: Question) = {
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
  
  def parseXml(xml: Elem): Quiz = {
    val title = (xml \ "title").text
    val items = (xml \\ "item")
    val questions = items.map(parseElement)
    
    Quiz(title, questions.toList)
  }
  
  def parseElement(node: NodeSeq) = {
    val text = (node \ "question").text
    val answers = (node \ "option").map(option => Answer(option.text, option.attribute("correct").map(_ == "y").getOrElse(false)))
    Question(text, answers.toList)
  }

}

case class Quiz(title: String, questions: List[Question])
case class Question(text: String, answers: List[Answer])
case class Answer(text: String, correct: Boolean)