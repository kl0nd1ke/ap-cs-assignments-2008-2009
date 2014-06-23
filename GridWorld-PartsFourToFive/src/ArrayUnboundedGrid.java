import java.util.ArrayList;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

public class ArrayUnboundedGrid<E> extends AbstractGrid<E> {
	private Object[][] occupantArray;
	// midRow and midCol keep track of where (0, 0) is for the user of the grid
	private int midRow;
	private int midCol;
	
	public ArrayUnboundedGrid(){
		occupantArray = new Object[16][16];
		midRow = occupantArray.length / 2;
		midCol = occupantArray[0].length / 2;
	}
	
	public E get(Location loc) {
		int row = loc.getRow();
		int col = loc.getCol();
		int rowIndex = row + midRow;
		int colIndex = col + midCol;
		
		// If the location is contained in the array, return what is at that location
		if((rowIndex >= 0 && rowIndex < occupantArray.length) && (colIndex >= 0 && colIndex < occupantArray[0].length)){
			return (E) occupantArray[rowIndex][colIndex];
		}
		else{
			return null;
		}
	}
	public int getNumCols() {
		return -1;
	}
	public int getNumRows() {
		return -1;
	}
	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> locs = new ArrayList<Location>();
		int locRow;
		int locCol;
		
		for(int row = 0; row < occupantArray.length; row++){
			locRow = row - midRow;
			
			for(int col = 0; col < occupantArray[0].length; col++){
				locCol = col - midCol;
				
				if(occupantArray[row][col] != null){
					locs.add(new Location(locRow, locCol));
				}
			}
		}
		
		return locs;
	}
	// All locations are valid in an unbounded grid
	public boolean isValid(Location loc) {
		return true;
	}
	public E put(Location loc, E element) {
		// Convert row and col to index values
		int row = loc.getRow();
		int col = loc.getCol();
		int rowIndex = row + midRow;
		int colIndex = col + midCol;
		
		// Keep resizing the grid until the element can be added to the desired location
		while((rowIndex < 0 || rowIndex >= occupantArray.length) || (colIndex < 0 || colIndex >= occupantArray[0].length)){
			resizeGrid();
			rowIndex = row + midRow;
			colIndex = col + midCol;
		}
		
		E oldElement = (E) occupantArray[rowIndex][colIndex];
		occupantArray[rowIndex][colIndex] = (Object) element;
		return oldElement;
	}
	public E remove(Location loc) {
		int row = loc.getRow();
		int col = loc.getCol();
		int rowIndex = row + midRow;
		int colIndex = col + midCol;
		
		E oldElement = (E) occupantArray[rowIndex][colIndex];
		occupantArray[rowIndex][colIndex] = null;
		return oldElement;
	}
	private void resizeGrid(){
		// The new array is twice as large in both directions
		Object[][] newOccupantArray = new Object[occupantArray.length * 2][occupantArray[0].length * 2];
		for(int row = 0; row < occupantArray.length; row++){
			for(int col = 0; col < occupantArray[0].length; col++){
				// Adjusts for the larger size of the new array
				newOccupantArray[row + occupantArray.length / 2][col + occupantArray[0].length / 2] = occupantArray[row][col];
			}
		}
		// Resets midRow and midCol to be accurate for the new array
		midRow += occupantArray.length / 2;
		midCol += occupantArray[0].length / 2;
		
		occupantArray = newOccupantArray;
	}
}
