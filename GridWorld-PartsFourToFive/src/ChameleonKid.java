import info.gridworld.actor.Actor;

import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter {
	public ArrayList<Actor> getActors(){
		ArrayList<Actor> neighbors = getGrid().getNeighbors(getLocation());
		
		for(int i = 0; i < neighbors.size(); i++){
			int direction = getLocation().getDirectionToward(neighbors.get(i).getLocation());
			
			// If the neighbor isn't directly in front of or behind the ChameleonKid, remove it from neighbors
			if(direction != getDirection() && direction != (getDirection() + 180) % 360){
				neighbors.remove(neighbors.get(i));
				i--;
			}
		}
		return neighbors;
	}
}
