/*
 * Encoder.java
 * This class has the capability to read in a plain-text file, 
 * generate a random substitution cipher, and print the encoded
 * text to a file.
 * 
 * D. Wulsin
 * AP Computer Science
 * Assignment 2.2
 * Fall 2008
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class Encoder {

	// the original lines
	private ArrayList<String> origLines = new ArrayList<String>();
	
	// the array containing our substitution cipher
	private char[] charMatches = new char[256];
	
	/*
	 * The constructor reads in the text from the original filepath
	 * and stores it in origLines ArrayList
	 */
	public Encoder(String origFilepath){
		
		File encF = new File(origFilepath);
		Scanner sc = null;
		
		try{
			sc = new Scanner(encF);
		}
		catch(FileNotFoundException ex){
			System.out.println("Cannot find the file " + origFilepath);
			System.exit(1);
		}
		
		while(sc.hasNext()){
			String line = sc.nextLine();
			origLines.add(line);
			//System.out.println(line);
		}
		
	}
	
	/*
	 * This method generates a random cipher for alphabet characters
	 * (and their upper-case analogs) and stores it in the charMatches
	 * array
	 */
	public void makeRandCipher(){
		
		for(int c = 0; c < charMatches.length; c++){
			charMatches[c] = (char)c;
		}
		
		Random rand = new Random();
		char a = 'a', z = 'z';
		int range = z - a + 1;
		
		// the code in this loop took me about an hour to get right
		for(char c = 'a'; c <= 'z'; c++){
			char temp = charMatches[c];
			char randCh = (char)(rand.nextInt(range) + a);
			
			charMatches[c] = charMatches[randCh];
			charMatches[randCh] = temp;
			charMatches[Character.toUpperCase(c)] = Character.toUpperCase(charMatches[c]);
			charMatches[Character.toUpperCase(randCh)] = Character.toUpperCase(charMatches[randCh]);
			
		}
		
		for(char c = 'a'; c <= 'z'; c++){
			System.out.println(c + " --> " + charMatches[c]);
			//System.out.println(Character.toUpperCase(c) + " --> " + charMatches[Character.toUpperCase(c)]);
		}
	}
	
	/* use the charMatches array to encode the plain text into
	 * encoded text and write that encoded text to a file
	 */
	public void encodeText(String filepath){
		
		File f = new File(filepath);
		
		PrintWriter out = null;
		
		try{
			out = new PrintWriter(f);
		}
		catch(FileNotFoundException ex){
			System.out.println("Cannot create file " + filepath);
			System.exit(1);
		}
		
		
		for(String line: origLines){
			char[] lineAr = line.toCharArray();
			String decLine = "";
			for(char ch: lineAr){
				char decChar = charMatches[(int)ch];
				decLine += decChar;
			}
			
			out.println(decLine);
			//System.out.println(decLine);
		}
		
		out.close();
	}
}
