/*
 * TicTacToeRunner.java
 * This class is the entry point for our program. It initializes the two players as well as a GameRunner object and starts the game.
 * 
 * Drausin Wulsin
 * AP Computer Science AB
 * Assignment 3.4
 * Landon School, 2009
 * 
 */
 
public class TicTacToeRunner {

	public static void main(String[] args){
		
		GameStateI myGame = new TicTacToeState(-1);
		Player player1 = new User("SB",-1,"Enter your move (e.g. a1): ",System.out);
		
		HeurWeights w = new HeurWeights();
		Player player2 = new AIBot("Compy 386", 1, w, 1, 6);
		
		GameRunner myRun = new GameRunner(player1, player2, myGame, System.out, "Wecome to Tic Tac Toe!");
		
		myRun.start();
		
	}
}
