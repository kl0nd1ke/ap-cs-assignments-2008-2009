/* Deck.java
 * Vladimir Costescu
 * AP Computer Science AB
 * Assignment-1.4-cards (due 10/13/08)
 * This is the deck class.
 */

import java.util.ArrayList;
import java.util.Random;

public class Deck extends Queue {
	private int deckSize = 52;
	private static ArrayList<Card> UNSHUFFLED_CARDS = initCards();
	
	public Deck(){
		
	}
	public Deck(boolean shuffle){
		initCards();
		
		// If the passed boolean is true that means we want to shuffle the deck
		if(shuffle == true){
			this.shuffle();
		}
		
		for(int i = deckSize - 1; i >= 0; i--){
			add(shuffledCards[i]);
		}
	}
	
	public void shuffle(){
		Random randGen = new Random();
		int[] randomIntArray = new int[deckSize];
		
		// Generate an array of random numbers
		for(int i = 0; i < randomIntArray.length; i++){
			randomIntArray[i] = randGen.nextInt(deckSize);
		}
		
		// Eliminate any duplicate numbers so that the array contains only unique values
		for(int i = 0; i < randomIntArray.length; i++){
			for(int j = 0; j < randomIntArray.length; j++){
				if(randomIntArray[i] == randomIntArray[j] && i != j){
					randomIntArray[j] = randGen.nextInt(deckSize);
					i = 0;
				}
			}
		}
		
		
		// Use the randomIntArray to create a shuffled deck from the unshuffled deck
		for(int i = 0; i < randomIntArray.length; i++){
			shuffledCards[i] = unshuffledCards[randomIntArray[i]];
		}
	}
	// Initializes unshuffledCards and sets shuffledCards equal to unshuffledCards
	private static ArrayList<Card> initCards(){
		ArrayList<Card> tempCards = new ArrayList<Card>();
		
		// Outer loop makes sure that only enough cards to fill the deck are created
		for(int numberOfCardsCounter = 0; numberOfCardsCounter < deckSize;){
			
			// Middle loop goes through each number, from 1 to 13
			for(int cardNumberCounter = 1; cardNumberCounter < 14; cardNumberCounter++){
				
				// Inner loop creates four cards (one of each suit) for a given card number
				for(int cardSuitCounter = 1; cardSuitCounter < 5; cardSuitCounter++){
					switch(cardSuitCounter)
					{
					case 1:
						tempCards.add(new Card(Card.Suit.Hearts, cardNumberCounter));
						numberOfCardsCounter++;
						break;
					case 2:
						tempCards.add(new Card(Card.Suit.Diamonds, cardNumberCounter));
						numberOfCardsCounter++;
						break;
					case 3:
						tempCards.add(new Card(Card.Suit.Spades, cardNumberCounter));
						numberOfCardsCounter++;
						break;
					case 4:
						tempCards.add(new Card(Card.Suit.Clubs, cardNumberCounter));
						numberOfCardsCounter++;
						break;
					}
				}
			}
			
			return tempCards;
		}
		
		// The deck is initially unshuffled
		for(int i = 0; i < deckSize; i++){
			shuffledCards[i] = unshuffledCards[i];
		}
	}
	public void printDeck(){
		
		// Loop through to print the shuffled cards 
		// (if the cards are not shuffled, the cards printed will simply be in order)
		
		for(int j = 0; j < deckSize; j++){
			System.out.println(/*decks[i]*/shuffledCards[j].getName());
		}
	}
	public Card dealNextCard(){
		
		// Create a new card with the value of the first card in the deck and 
		// set the first card in the deck to null (because we removed it)
		Card nextCard = new Card(shuffledCards[0].getSuit(), shuffledCards[0].getNumber());
		shuffledCards[0] = null;
		
		// Shift cards up one slot
		for(int i = 0; i < (deckSize - 1); i++){
			shuffledCards[i] = shuffledCards[(i + 1)];
		}
		
		// Set the last card to null since we moved the cards up
		shuffledCards[(deckSize - 1)] = null;
		
		// Decrement the deck size since the deck now has one less card
		deckSize--;
		
		return nextCard;
	}
}
