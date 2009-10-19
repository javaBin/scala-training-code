package scalakurs.tictactoe

class Board(rows: Int, cols: Int) {

  private val boardState = new Matrix[CellState](rows, cols, Empty)
  
  def this() = this(3,3)

  override def toString = {
    val res = new StringBuilder
    for (y <- 0 to rows - 1) {
      if (y > 0) {
        res.append("---+" * (cols-1)).append("---\n")
      }
      for (x <- 0 to cols - 1) {
        if (x > 0) res.append("|")
        val cell = boardState(x, y)
        res.append(' ').append(cell.toString).append(' ')
      }
      res.append('\n')
    }
    res.toString
  }
  
}

class Matrix[T](rows: Int, cols: Int, defaultValue: T) {
  private val contents = new Array[T](rows * cols)
  for(x <- 0 to contents.length - 1) contents(x) = defaultValue
  
  def apply(x: Int, y: Int) = contents(getPos(x,y))
  def update(x: Int, y: Int, value: T) {
    contents(getPos(x,y)) = value
  }
  private def getPos(x: Int, y: Int) = x + y * cols
}

sealed abstract class CellState

case object Empty extends CellState {
  override def toString = " "
}
case object X extends CellState
case object O extends CellState

