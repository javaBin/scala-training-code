package scalakurs.tictactoe

object TicTacToeGame {

  def main(args: Array[String]) {
    println("""Welcome to Tic Tac Toe
    		      |
              |Enter number of columns""".stripMargin)
    val cols = readLine().toInt
    println("Enter number of rows:")
    val rows = readLine().toInt
    val board = new console.ConsoleBoard(rows, cols)
    println(board)
  }
  
}
