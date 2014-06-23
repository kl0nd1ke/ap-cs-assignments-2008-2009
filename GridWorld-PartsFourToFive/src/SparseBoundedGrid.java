import java.util.ArrayList;
import java.util.LinkedList;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

public class SparseBoundedGrid<E> extends AbstractGrid<E> {
	private int rows;
	private int cols;
	
	private ArrayList<LinkedList<OccupantInCol<E>>> sparseGrid;
	
	public SparseBoundedGrid(int rows, int cols){
		if(rows <= 0){
			throw new IllegalArgumentException("rows <= 0");
		}
		if(cols <= 0){
			throw new IllegalArgumentException("cols <= 0");
		}
		
		this.rows = rows;
		this.cols = cols;
		
		sparseGrid = new ArrayList<LinkedList<OccupantInCol<E>>>(rows);
		for(int i = 0; i < rows; i++){
			sparseGrid.add(null);
		}
	}
	
	public E get(Location loc) {
		if(!isValid(loc)){
			throw new IllegalArgumentException("Location " + loc + " is not valid");
		}
		
		int row = loc.getRow();
		int col = loc.getCol();
		
		// If the row is empty, the location is empty
		if(sparseGrid.get(row) == null){
			return null;
		}
		else{
			// Loops through each occupant (wrapper for each element)
			for(OccupantInCol<E> occupant : sparseGrid.get(row)){
				if(occupant.getCol() == col){
					return occupant.get();
				}
			}

			return null;
		}
	}
	public int getNumCols() {
		return cols;
	}
	public int getNumRows() {
		return rows;
	}
	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> occupiedLocations = new ArrayList<Location>();
		
		// Loops through each row
		for(int row = 0; row < rows; row++){
			LinkedList<OccupantInCol<E>> curRow = sparseGrid.get(row);
			// Tests non-empty rows
			if(curRow != null){
				// Loops through each element in the row
				for(OccupantInCol<E> o : curRow){
					occupiedLocations.add(new Location(row, o.getCol()));
				}
			}
		}
		
		return occupiedLocations;
	}
	public boolean isValid(Location loc) {
		return (loc.getRow() >= 0 && loc.getRow() < rows) && (loc.getCol() >= 0 && loc.getCol() < cols);
	}
	public E put(Location loc, E element) {
		if(!isValid(loc)){
			throw new IllegalArgumentException("Location " + loc + " is not valid");
		}
		if(element == null){
			throw new NullPointerException("obj == null");
		}
		
		int row = loc.getRow();
		int col = loc.getCol();
		LinkedList<OccupantInCol<E>> curRow = sparseGrid.get(row);
		
		// If the row is empty, create a new row and add the element to it
		if(curRow == null){
			curRow = new LinkedList<OccupantInCol<E>>();
			curRow.add(new OccupantInCol<E>(col, element));
			sparseGrid.set(row, curRow);
			
			return null;
		}
		else{
			// Loop through each element in the row
			for(OccupantInCol<E> occupant : curRow){
				// If an element exists at the location, replace it and return it
				if(occupant.getCol() == col){
					E oldElement = occupant.get();
					int index = curRow.indexOf(occupant);
					
					curRow.set(index, new OccupantInCol<E>(col, element));
					
					return oldElement;
				}
			}
			// If an element doesn't exist at the location, add the new element to the row
			curRow.add(new OccupantInCol<E>(col, element));
			
			return null;
		}
	}
	public E remove(Location loc) {
		if(!isValid(loc)){
			throw new IllegalArgumentException("Location " + loc + " is not valid");
		}
		
		E element = get(loc);
		
		// Remove the element if it exists
		if(element != null){
			int row = loc.getRow();
			int col = loc.getCol();
			LinkedList<OccupantInCol<E>> curRow = sparseGrid.get(row);
			OccupantInCol<E> occupant = new OccupantInCol<E>(col);
			
			// Finds the occupant to remove
			for(OccupantInCol<E> o : curRow){
				if(o.getCol() == col){
					occupant = o;
				}
			}
			
			// Removes the occupant (if it is the only one left, sets the row to null)
			if(curRow.size() > 1){
				curRow.remove(occupant);
			}
			else{
				sparseGrid.set(row, null);
			}
		}
		
		return element;
	}
}
