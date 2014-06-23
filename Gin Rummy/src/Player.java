import java.util.ArrayList;


public class Player {
	private String name;
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public Player(String aName){
		name = aName;
	}
	public Player(String aName, ArrayList<Card> aHand){
		this(aName);
		hand = aHand;
	}
	
	public String getName(){
		return name;
	}
	public ArrayList<Card> getHand(){
		return hand;
	}
	public void addToHand(Card aCard){
		
	}
}
