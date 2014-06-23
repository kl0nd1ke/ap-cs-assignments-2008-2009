import info.gridworld.actor.Bug;

public class ZBug extends Bug {
	private int steps;
    private int sideLength;
    private int totalDistanceTraveled;
    /**
     * Constructs a ZBug that moves in a Z shape of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        setDirection(90);
    }
    /**
     * Moves to the next location of the Z shape, or stops if an obstruction or the end of the Z is reached.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
            totalDistanceTraveled++;
        }
        else if(canMove() && totalDistanceTraveled < (sideLength * 3))
        {
            turn();
            turn();
            turn();
            if(totalDistanceTraveled >= (sideLength * 2)){
            	turn();
            	turn();
            }
            steps = 0;
        }
        else{
        	
        }
    }
}
