import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;

public class Jumper extends Bug {
	public void move(){
		Grid<Actor> gr = getGrid();
		if(gr == null)
			return;
		Location loc = getLocation();
		Location next1 = loc.getAdjacentLocation(getDirection());
		Location next2 = next1.getAdjacentLocation(getDirection());
		if(canMove(next2))
			moveTo(next2);
		else{
			if(canMove(next1))
				moveTo(next1);
			else{
				removeSelfFromGrid();	
			}
		}
	}
	public boolean canMove(){
		Location loc = getLocation();
		Location next1 = loc.getAdjacentLocation(getDirection());
		Location next2 = next1.getAdjacentLocation(getDirection());
		
		if(!canMove(next2)){
			if(!canMove(next1)){
				return false;
			}
			else{
				return true;
			}
		}
		else{
			return true;
		}
	}
	public boolean canMove(Location loc){
		Grid<Actor> gr = getGrid();
		if(gr == null)
			return false;
		if(!gr.isValid(loc))
			return false;
		Actor neighbor = gr.get(loc);
		return (neighbor == null) || (neighbor instanceof Flower);
	}
}
