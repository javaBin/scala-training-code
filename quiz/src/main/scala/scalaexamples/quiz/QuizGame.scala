package scalaexamples.quiz

import xml._

object QuizGame {
  
  def main(args: Array[String]) {
    val xmlFromFile = xml.XML.loadFile("src/main/resources/quiz.xml")
    val quiz = parseXml(xmlFromFile)
    println(quiz)
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

case class Quiz(title: String, questions: Seq[Question])
case class Question(text: String, answers: Seq[Answer])
case class Answer(text: String, correct: Boolean)