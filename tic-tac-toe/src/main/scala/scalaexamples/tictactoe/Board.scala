package scalaexamples.tictactoe

abstract class Board(val rows: Int, val cols: Int) {

  protected val boardState = new Matrix[CellState](rows, cols, Empty)
  
  def update(x: Int, y: Int, state: CellState) {
    assert(boardState(x,y) == Empty)
    boardState(x,y) = state
  }
  
  def apply(x: Int, y: Int) = boardState(x,y)
  
  def showBoardState(): Unit

  def movePossible = true
}
