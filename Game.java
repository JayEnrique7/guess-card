package cardGame;

import java.util.Scanner;

public class Game {
	static String[] names = new String[2];
	static Scanner scanner = new Scanner(System.in);
	static String chosenCard;
	static String[] deckOfCards = {"Ah", "2h","3h", "4h","5h", "6h","7h", "8h", "9h", "10h","Jh", "Qh","Kh",
			"Ad", "2d","3d", "4d","5d", "6d","7d", "8d", "9d", "10d","Jd", "Qd","Kd",
			"Ac", "2c","3c", "4c","5c", "6c","7c", "8c", "9c", "10c","Jc", "Qc","Kc",
			"As", "2s","3s", "4s","5s", "6s","7s", "8s", "9s", "10s","Js", "Qs","Ks"};
	static boolean running = true;
	static int bet;
	static int counter = 1;
	
	static Chip playerOneChip = new Chip(500);
	static Chip playerTwoChip = new Chip(500);
	
	public static void main(String[] args) {
		
		for(int i = 1; i <= 2; i++){
			System.out.println("Player "+i+" whats your name?: ");
			names[i-1] = scanner.nextLine();
		}
		
		Chip.shuffleDeck();
		
		while(running){
			printChips();
			play();
			bet();
			assignCard();
			counter++;
			if(playerOneChip.playChip == 1000){
				System.out.println(names[0] +" wins, game over!");
				running = false;
			}
			else if(playerOneChip.playChip == 1000){
				System.out.println(names[1] +" wins, game over!");
				running = false;
			}
		}
		

	}
	public static void printChips(){
			System.out.println(names[0] +" chips: "+playerOneChip.playChip);
			System.out.println(names[1] +" chips: "+playerTwoChip.playChip);
	}
	
	public static void play(){
		if(counter % 2 == 0){
			System.out.println(names[0]+", choose a card (Ad/Qh): ");
			chosenCard = scanner.nextLine();	
		}
		else {
			System.out.println(names[1]+", choose a card (Ad/Qh): ");
			chosenCard = scanner.nextLine();
			
		}
		
	}
	public static void bet(){
		System.out.println("Choose bet(25/50/100)");
		String tempBet;
		tempBet = scanner.nextLine();
		bet = Integer.parseInt(tempBet);
		//if(bet != 25 || bet != 50|| bet!=100){
		//	System.out.println("Invalid betsize, choose again");
		//	bet();
		//}
		if(playerOneChip.playChip < bet){
			System.out.println(names[0]+" doesn't have enough chips");
			bet();
		}
		else if(playerTwoChip.playChip < bet){
			System.out.println(names[1]+" doesn't have enough chips");
			bet();
		}
	}
	
	
	public static void assignCard(){
		for(int i = 0; i <= 51; i++){
			int tempPlayer;
			if(i % 2 == 0){
				tempPlayer = 0;
			}
			else{
				tempPlayer = 1;
			}
			System.out.println(names[tempPlayer]+": "+deckOfCards[i]);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(deckOfCards[i].equals(chosenCard)){
				if(i % 2 == 0){
					System.out.println(names[0] + " wins");
					playerTwoChip.playChip -= bet;
					playerOneChip.playChip += bet;
					return;
					}
				else{
					System.out.println(names[1] + " wins");
					playerOneChip.playChip -= bet;
					playerTwoChip.playChip += bet;
					return;
				}
			}
			
		}
	}
	
	
	
	
	
	
	

}