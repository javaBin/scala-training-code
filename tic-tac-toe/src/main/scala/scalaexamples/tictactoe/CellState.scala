package scalaexamples.tictactoe

sealed abstract class CellState

case object Empty extends CellState {
  override def toString = " "
}
case object X extends CellState
case object O extends CellState

