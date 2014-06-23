import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class QuickCrab extends CrabCritter {
	public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        
        int[] dirs =
        { Location.LEFT, Location.RIGHT };
    
        for (int d : dirs)
        {
        	// Tests both locations for each direction
            Location nLoc1 = loc.getAdjacentLocation(getDirection() + d);
            Location nLoc2 = nLoc1.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(nLoc1) && gr.get(nLoc1) == null && gr.isValid(nLoc2) && gr.get(nLoc2) == null)
                locs.add(nLoc2);
        }
        
        // If the locations two spaces away in either direction are unavailable, move like a CrabCritter
        if(locs.size() == 0){
        	return super.getMoveLocations();
        }
        
        return locs;
    } 
}
