import java.util.ArrayList;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter {
	private int courage = 0;
	
	public BlusterCritter(int c){
		courage = c;
	}
	
	public ArrayList<Actor> getActors(){
		Location curLoc = this.getLocation();
		ArrayList<Actor> actors = new ArrayList<Actor>();
		Actor tempActor;
		
		// Loop through the locations adjacent to the BlusterCritter
		for(Location loc : getGrid().getValidAdjacentLocations(curLoc)){
			/*
			System.out.println("&&&&&&&&&&&");
			System.out.println("loc : (" + loc.getRow() + ", " + loc.getCol() + ")");
			System.out.println("-----------");
			*/
			// Loop through the locations adjacent to each location adjacent to the BlusterCritter
			for(Location l : getGrid().getValidAdjacentLocations(loc)){
				//System.out.println("l : (" + l.getRow() + ", " + l.getCol() + ")");
				tempActor = getGrid().get(l);
				
				// Add the actor only if it is not this BlusterCritter, is a Critter, 
				// and doesn't already exist in actors
				if(tempActor != null && !tempActor.equals(this) && tempActor instanceof Critter && !actors.contains(tempActor)){
					actors.add(tempActor);
				}
			}
		}
		/*
		System.out.println("actors.size() = " + actors.size());
		System.out.println("location : (" + getLocation().getRow() + ", " + getLocation().getCol() + ")");
		*/
		
		return actors;
	}
	public void processActors(ArrayList<Actor> actors){
		// If there are fewer critters than courage, the BlusterCritter gets brighter
		if(actors.size() == 0 || actors.size() < courage){
			this.setColor(this.getColor().brighter());
		}
		// Otherwise, the BlusterCritter gets darker
		else{
			this.setColor(this.getColor().darker());
		}
	}
}
