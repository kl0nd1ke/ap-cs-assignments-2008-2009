/*
 * AIBot.java
 * This is a generalized class for getting a move from an AI, which queries a game tree
 * to a certain depth to determine the best move.
 * 
 * Drausin Wulsin
 * AP Computer Science AB
 * Assignment 3.4
 * Landon School, 2009
 * 
 */

public class AIBot extends Player {
	
	protected HeurWeights theWeights;
	protected int startDepth;
	protected int endDepth;
		
	public AIBot(String aName, int aPlayerCode, HeurWeights someWeights){
		
		name = aName;
		playerCode = aPlayerCode;
		
		theWeights = someWeights;
	}
	
	public AIBot(String aName, int aPlayerCode, HeurWeights someWeights, int aStartDepth, int anEndDepth){
	
		this(aName, aPlayerCode, someWeights);
		
		startDepth = aStartDepth;
		endDepth = anEndDepth;
	}
	
	public String getMove(GameStateI curGameState){
		
		int bestMove = -1;
		GameNodeI root;
		
		for(int depth = startDepth; depth <= endDepth; depth++){
			
			/*
			 * ALERT: serious compromise of encapsulation here.
			 * A specific implementation of a GameNodeI must be used.
			 * If you have any better suggestions, I'm all ears.
			 */
			root = new TicTacToeNode(playerCode, -1, ((TicTacToeState)curGameState).getBoard());
			
			root.getHeurVal(depth, playerCode);
			bestMove = root.getBestMove();
			
			// comment out the following 2 lines if you like
			//System.out.println("Best Move at Depth " + depth + " : " + bestMove + ", " + 
			//					curGameState.moveToString(bestMove) + " (" + root.getHeurVal(depth, playerCode) + ")");
		}
		
		
		return curGameState.moveToString(bestMove);
	}

}
