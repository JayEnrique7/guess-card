package cardGame;

import java.util.Scanner;


public class Chip extends Game{
	


	 int betChip_;
	 int playChip;


	public Chip(int playChip){
		
		this.playChip = playChip;
				
	}
	
	public static void shuffleDeck(){
		int nrOfCards = 52;
		
		for(int i = 0; i < nrOfCards; i++){
			int randomNum = 0 + (int)(Math.random()*51); 
			
			String temp = deckOfCards[randomNum];
			deckOfCards[randomNum] = deckOfCards[i];
			deckOfCards[i] = temp;
		}
		
	}
	


}
