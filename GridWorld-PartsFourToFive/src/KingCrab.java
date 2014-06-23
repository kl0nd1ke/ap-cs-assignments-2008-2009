import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;


public class KingCrab extends CrabCritter {
	public void processActors(ArrayList<Actor> actors){
		int direction;
		Location locToMove;
		
		for(Actor a : actors){
			direction = this.getLocation().getDirectionToward(a.getLocation());
			locToMove = a.getLocation().getAdjacentLocation(direction);
			/*
			System.out.println("location : (" + getLocation().getRow() + ", " + getLocation().getCol() + ")");
			System.out.println("locToMove : (" + locToMove.getRow() + ", " + locToMove.getCol() + ")");
			*/
			
			// If the actor can move away, make it move away
			if(getGrid().isValid(locToMove) && getGrid().get(locToMove) == null){
				a.moveTo(locToMove);
			}
			// If the actor cannot move away, "kill" it (remove it from the grid)
			else{
				a.removeSelfFromGrid();
			}
		}
	}
}
