package scalakurs.tictactoe

object TicTacToeGame {

  def main(args: Array[String]) {
    val game = new console.ConsoleGame
    game.printWelcomeMessage
    
    val (rows, cols) = game.getBoardSize
    val board = game.createBoard(rows, cols)

    board.showBoardState()
  }
  
}
