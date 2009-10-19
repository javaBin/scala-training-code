package scalakurs.tictactoe

trait GameIO {

  def printWelcomeMessage: Unit
  def getBoardSize: (Int, Int)
  def createBoard(rows: Int, cols: Int): Board
  def createComputerPlayer: Player
  def createHumanPlayer: Player
  
}
