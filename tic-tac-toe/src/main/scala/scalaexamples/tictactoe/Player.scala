package scalaexamples.tictactoe

trait Player {

  val character: CellState
  val playerName: String
  def move(board: Board): (Int, Int)

}
