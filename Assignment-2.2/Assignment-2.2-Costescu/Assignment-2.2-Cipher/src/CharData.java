/*
 * CharData.java
 * This simple class provides a wrapper for a specific character and its frequency
 * 
 * D. Wulsin
 * AP Computer Science
 * Assignment 2.2
 * Fall 2008
 */
public class CharData {
	
	private char ch;
	private double freq;
	
	public CharData(char aCh, double aFreq){
		ch = aCh;
		freq = aFreq;
	}
	
	public char getChar(){
		return ch;
	}
	
	public double getFreq(){
		return freq;
	}
	
	public String getFreqStr(){
		return String.format("%.4f",freq);
	}
}
