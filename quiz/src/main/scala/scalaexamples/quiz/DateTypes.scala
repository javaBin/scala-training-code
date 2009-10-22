package scalaexamples.quiz

case class Quiz(title: String, questions: List[Question])
case class Question(text: String, answers: List[Answer])
case class Answer(text: String, correct: Boolean)