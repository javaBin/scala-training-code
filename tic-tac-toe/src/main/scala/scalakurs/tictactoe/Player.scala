package scalakurs.tictactoe

trait Player {

  val character: CellState
  def move(board: Board): (Int, Int)

}
