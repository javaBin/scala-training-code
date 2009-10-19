package scalaexamples.tictactoe.console

class ConsoleGame extends GameIO {

  def printWelcomeMessage {
	  println("Welcome to Tic Tac Toe!")
    
  }
  def getBoardSize: (Int, Int) = {
    println("Enter number of columns:")
    val cols = readLine().toInt
    println("Enter number of rows:")
    val rows = readLine().toInt
    (cols, rows)
  }
  
  def createBoard(rows: Int, cols: Int) = new ConsoleBoard(rows, cols)
  
  def createComputerPlayer = new RandomComputerPlayer(X)
  def createHumanPlayer = new ConsolePlayer

  
}
