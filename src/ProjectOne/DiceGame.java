package ProjectOne;

import java.util.Random;
import java.util.Scanner;

public class DiceGame {

	public static void main(String[] args) {
		System.out.println("This is a game, roll the dice if you are player one");
		int playerOnePoints = 0;
		int playerTwoPoints = 0;
		boolean playerOne = true;
		boolean playerTwo = false;
		boolean Game = true;
		Scanner CS = new Scanner(System.in);
		RollDice newDice = new RollDice();
	
		while(Game){
			String i = CS.nextLine();
			if(i.equals("end")){
				System.out.println(playerOnePoints);
				System.out.println(playerTwoPoints);
			}else if(i.equals("roll")){
				System.out.println("rolling the dice");
				int DiceOne = rollDice();
				int DiceTwo = rollDice();
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

	public static int rollDice(){
		Random rand = new Random();
		//+1 for else it would be 0 - 5
		int dice = rand.nextInt(6) +1; 
		return dice;
	}
}
