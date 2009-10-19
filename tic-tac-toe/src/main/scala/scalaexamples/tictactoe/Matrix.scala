package scalaexamples.tictactoe

class Matrix[T](rows: Int, cols: Int, defaultValue: T) {
  private val contents = new Array[T](rows * cols)
  for(x <- 0 to contents.length - 1) contents(x) = defaultValue
  
  def apply(x: Int, y: Int) = contents(getPos(x,y))
  def update(x: Int, y: Int, value: T) {
    contents(getPos(x,y)) = value
  }
  private def getPos(x: Int, y: Int) = x + y * cols
  
  def emptySlots = contents.find(_ == defaultValue).isDefined
}