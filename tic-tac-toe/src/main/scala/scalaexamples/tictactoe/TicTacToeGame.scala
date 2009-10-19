package scalaexamples.tictactoe

object TicTacToeGame {

  def main(args: Array[String]) {
    val game = new console.ConsoleGame
    game.printWelcomeMessage
    
    val (rows, cols) = game.getBoardSize
    val board = game.createBoard(rows, cols)

    val playerList = game.createComputerPlayer :: game.createHumanPlayer :: Nil
    
    var player = 0
    while(board.movePossible) {
    	  board.showBoardState()
      val current = playerList(player)
      val (row, column) = current.move(board)
      board(row, column) = current.character
      player = 1 - player 
    }
  }
  
}
