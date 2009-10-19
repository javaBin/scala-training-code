package scalaexamples.tictactoe.console

class ConsolePlayer extends Player {
	val character = O
	
	def move(board: Board) = {
	  println("""What is your next move?
			    |Enter row:""".stripMargin)
      val row = readLine().toInt
      println("Enter column: ")
	  val col = readLine().toInt
      (row, col)
	}
}
