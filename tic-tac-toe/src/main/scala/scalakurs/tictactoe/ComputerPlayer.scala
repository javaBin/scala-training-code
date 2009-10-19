package scalakurs.tictactoe

import Math.random

class RandomComputerPlayer(val character: CellState) extends Player {
  
  def move(board: Board): (Int, Int) = {
	  while(true) {
	   val x = (random * board.cols).toInt
	   val y = (random * board.rows).toInt
	   if(board(x,y) == Empty) return (x,y)
	  }
	  (-1, -1)
  }
  
}

