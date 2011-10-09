package scalaexamples.quiz

import xml._

/**
 * This class parses the xml from a file.
 */
class XmlQuizProvider(file: String) extends QuizProvider {

  def quiz = {
     val xmlFromFile = XML.load(getClass.getClassLoader.getResourceAsStream(file))
     parseXml(xmlFromFile)
  } 

  /**
   * TODO: Implement parsing of the XML into a Quiz object with questions and answers
   */
  private def parseXml(xml: Elem): Quiz = sys.error("Not implemented")
  
}
