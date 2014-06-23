
/** Wrapper class to be used with SparseBoundedGrid. **/
public class OccupantInCol<E> {
	private E occupant;
	private int col;
	
	public OccupantInCol(int col){
		this.col = col;
		occupant = null;
	}
	public OccupantInCol(int col, E occupant){
		this(col);
		this.occupant = occupant;
	}
	
	public E get(){
		return occupant;
	}
	public int getCol(){
		return col;
	}
}
