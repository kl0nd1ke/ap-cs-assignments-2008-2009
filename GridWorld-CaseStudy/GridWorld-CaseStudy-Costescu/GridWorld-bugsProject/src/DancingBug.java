
import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
    private int[] turns;
    private int currentTurnsValue;
    private int currentArrayIndex;

    /**
     * Constructs a bug that "dances" by turning different amounts based on an integer array input parameter
     * @param turns the integer array representing the number of turns
     */
    public DancingBug(int[] turnsArray)
    {
        turns = turnsArray;
        currentArrayIndex = 0;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
    	currentTurnsValue = turns[currentArrayIndex];
        
        for(int i = 0; i < currentTurnsValue; i++){
        	turn();
        }
        if(currentArrayIndex < (turns.length - 1)){
        	currentArrayIndex++;
        }
        else{
        	currentArrayIndex = 0;
        }
        
    	if (canMove())
        {
        	move();  
        }
        else
        {
            turn();
        }
    }
}