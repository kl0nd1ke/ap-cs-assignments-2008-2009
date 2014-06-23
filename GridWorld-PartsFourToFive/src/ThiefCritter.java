import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/** This critter can perform the following actions (depending on the situation):
 * 
 * 1) It can "steal" the color of an adjacent critter (sets its own color to the stolen color
 * and sets the color of the adjacent critter to black. If there are multiple adjacent critters,
 * it chooses one at random from which to "steal" the color. If the color of the randomly selected
 * critter is black, the ThiefCritter will change its own color to a random color that it possesses.
 * 2) It can "steal" adjacent Flowers by removing them from the world. If the number of stolen Flowers 
 * reaches a set value, it "throws" the stolen Flowers to random empty grid locations a specified distance 
 * away until it is no longer carrying any, at which point it will resume its Flower-stealing actions 
 * when it acts next.
 * 3) It can "kill" an adjacent critter (by turning it into a red Flower) on rare occasions.
 * 
 * This critter is directionally challenged and thus cannot move diagonally. It also refuses to remove
 * itself from the grid (unless the secret code is entered); if its removeSelfFromGrid method is called, 
 * it gets angry and kills ALL adjacent critters (excluding other ThiefCritters). When there are no adjacent 
 * critters or flowers to it, the critter changes its color to a random color that it possesses.
 */
public class ThiefCritter extends Critter  {
	// The meaning of life
	private int secretCode = 42;
	
	// How many stolen flowers the critter can carry
	private int maxInventorySize;
	// The probability (0-100) that the critter will kill an adjacent critter when it acts
	private int killProbability;
	// How far the critter can "throw" stolen flowers
	private int maxThrowDistance;
	
	private ArrayList<Color> colors = new ArrayList<Color>();
	private ArrayList<Flower> stolenFlowers = new ArrayList<Flower>();
	private int currentInventorySize = 0;
	
	public ThiefCritter() {
		// Default values
		maxInventorySize = 3;
		killProbability = 5;
		maxThrowDistance = 5;
		colors.add(getColor());
	}
	// Sets the important values for the critter (and ensures that valid parameters are passed in)
	public ThiefCritter(int maxInvSize, int killProb, int maxThrowDist){
		maxInventorySize = Math.abs(maxInvSize);
		killProbability = Math.abs(killProb % 100);
		// 10 is a reasonable maximum throwing distance; anything over that is modulus-ed
		maxThrowDistance = Math.abs(maxThrowDist % 10);
		colors.add(getColor());
	}
	
	public void processActors(ArrayList<Actor> actors){
		ArrayList<Critter> critters = new ArrayList<Critter>();
		ArrayList<Flower> flowers = new ArrayList<Flower>();
		
		// Initialize critters (excludes other ThiefCritters) and flowers
		for(Actor a : actors){
			if(a instanceof Critter && !(a instanceof ThiefCritter)){
				critters.add((Critter) a);
			}
			else if(a instanceof Flower){
				flowers.add((Flower) a);
			}
		}
		
		if(critters.size() > 0){
			processCritters(critters);
		}
		if(flowers.size() > 0){
			processFlowers(flowers);
		}
		
		// If there are no critters or flowers to process, the critter will randomly change its color
		if(critters.size() == 0 && flowers.size() == 0){
			setColor(getRandomColor());
		}
	}
	public ArrayList<Location> getMoveLocations(){
		ArrayList<Location> emptyAdjLocs = getGrid().getEmptyAdjacentLocations(getLocation());
		ArrayList<Location> moveLocations = new ArrayList<Location>();
		
		// The critter cannot move diagonally
		for(Location loc : emptyAdjLocs){
			if(getLocation().getDirectionToward(loc) % 90 == 0){
				moveLocations.add(loc);
			}
		}
		
		return moveLocations;
	}
	/**
     * Turns towards the new location as it moves.
     */
    public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
	// The critter gets angry when something tries to remove it from the grid
	public void removeSelfFromGrid(){
		int oldKillProb = killProbability;
		
		killProbability = 100;
		act();
		setColor(Color.RED);
		
		killProbability = oldKillProb;
	}
	// The critter will only remove itself from the grid if the correct code is entered
	public void removeSelfFromGrid(int code){
		if(code == secretCode){
			super.removeSelfFromGrid();
		}
		else{
			removeSelfFromGrid();
		}
	}
	public void setColor(Color color){
		colors.add(color);
		
		super.setColor(color);
	}
	private void processCritters(ArrayList<Critter> critters){
		int randCritIndex = (int) (Math.random() * critters.size());
		
		/* Steals the color of a randomly selected Critter or sets its own color to a random color */
		if(critters.get(randCritIndex).getColor() != Color.BLACK){
			setColor(critters.get(randCritIndex).getColor());
			colors.add(critters.get(randCritIndex).getColor());
			critters.get(randCritIndex).setColor(Color.BLACK);
		}
		else{
			setColor(getRandomColor());
		}
		
		// Randomly kills Critters (occurs 5% of the time by default)
		for(Critter c : critters){
			int killProb = (int) (Math.random() * 100);
			Location tempLocation = c.getLocation();
			
			if(killProb <= killProbability){
				c.removeSelfFromGrid();
				(new Flower(Color.RED)).putSelfInGrid(getGrid(), tempLocation);
			}
		}
	}
	private void processFlowers(ArrayList<Flower> flowers){
		for(Flower f : flowers){
			/* Steals each flower if there is room in the Critter's inventory 
			/* (the size of which is 3 by default) */
			if(currentInventorySize < maxInventorySize){
				stolenFlowers.add(f);
				f.removeSelfFromGrid();
				currentInventorySize++;
			}
			/* If the Critter's inventory is full, it gets rid of all flowers therein
			/* by "throwing" them to random grid locations */ 
			else{
				while(stolenFlowers.size() > 0){
					Location loc = randLocGen();
					
					stolenFlowers.get(0).putSelfInGrid(getGrid(), loc);
					stolenFlowers.remove(0);
					currentInventorySize--;
				}
			}
		}
	}
	// Gets a random color from colors; if there are no colors, returns black
	private Color getRandomColor(){
		if(colors.size() > 0){
			int randIndex = (int) (Math.random() * colors.size());
			return colors.get(randIndex);
		}
		else{
			return Color.BLACK;
		}
	}
	private Location randLocGen(){
		Location loc;
		int randRowIndex;
		int randColIndex;
		int negOrPos;
		
		if(Math.random() < 0.5){
			negOrPos = -1;
		}
		else{
			negOrPos = 1;
		}
		
		randRowIndex = getLocation().getRow() + (int) (Math.random() * maxThrowDistance * negOrPos);
		randColIndex = getLocation().getCol() + (int) (Math.random() * maxThrowDistance * negOrPos);
		loc = new Location(randRowIndex, randColIndex);
		
		// Repeats the above until the location is valid and empty
		while(!getGrid().isValid(loc) || getGrid().get(loc) != null){
			if(Math.random() < 0.5){
				negOrPos = -1;
			}
			else{
				negOrPos = 1;
			}
			
			randRowIndex = getLocation().getRow() + (int) (Math.random() * maxThrowDistance * negOrPos);
			randColIndex = getLocation().getCol() + (int) (Math.random() * maxThrowDistance * negOrPos);
			loc = new Location(randRowIndex, randColIndex);
		}
		
		return loc;
	}
}
