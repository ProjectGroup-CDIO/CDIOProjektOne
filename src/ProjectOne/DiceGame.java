package ProjectOne;

import java.util.Random;
import java.util.Scanner;

public class DiceGame {

	public static void main(String[] args) {
		System.out.println("This is a game, roll the dice if you are player one");
		//Here each players points are stored as a variable int
		int playerOnePoints = 0;
		int playerTwoPoints = 0;
		// these two variables are used to determine which players turn it is
		boolean playerOne = true;
		boolean playerTwo = false;
		//This variable is used to determine wether or not the game is 
		//still active
		boolean Game = true;
		// the scanner is activated. 
		Scanner CS = new Scanner(System.in);
		//a new instance of the class Die is initiallized
		Die newDice = new Die();
		
		//ABC ABC ABCC CIKAJSJDLKJALKSJDLKJAKL
		//ajslkdjajsdlas
		while(Game){
			String i = CS.nextLine();
			if(i.equals("end")){
				System.out.println(playerOnePoints);
				System.out.println(playerTwoPoints);
			}else if(i.equals("roll")){
				System.out.println("rolling the dice");
				int DiceOne = newDice.rollDice();
				int DiceTwo = newDice.rollDice();
				System.out.println("First Die: "+ DiceOne + " Second Die: " + DiceTwo);
				if(playerOne){
					playerOnePoints =playerOnePoints + DiceOne+DiceTwo;
					playerTwo = true;
					playerOne = false;
					}else if(playerTwo){
						playerTwoPoints = playerTwoPoints + DiceOne+DiceTwo;
						playerOne = true;
						playerTwo = false;
						newDice.rollDice();
				}
				
			System.out.println("playerOnePoints: "+ playerOnePoints);
			System.out.println("playerTwoPoints: "+ playerTwoPoints);
			}
			else{
				System.out.println("Not a valid input! Either roll or end.");
			}
		
		}
	}
}
	

