package ProjectOne;

import java.util.Scanner;

public class DiceGame {

	static int playerOnePoints = 0;
	static int playerTwoPoints = 0; //Here each players points are stored as a variable int

	static boolean playerOne = true;
	static boolean playerTwo = false; // these two variables are used to determine which players turn it is

	static boolean wasLastRollDoubleSix = false;

	static boolean Game = true; /*This variable is used to determine whether or not the game is 
	still active*/

	
	//her starter det hele
	
	public static void main(String[] args) {
		System.out.println("This is a game, roll the dice if you are player one");

		Scanner CS = new Scanner(System.in); // the scanner is activated. 

		Die newDice = new Die(); //a new instance of the class Die is initialized


		while(Game){
			System.out.println("Write 'roll' to roll. \nWrite 'end' to end game and view score.");
			isPlayer(playerOne,playerTwo);
			String i = CS.nextLine();

			if(i.equals("end")){
				System.out.println(playerOnePoints);
				System.out.println(playerTwoPoints);
				Game = false;
				//break; 

			}else if(i.equals("roll")){
				System.out.println("rolling the dice");
				int DiceOne = newDice.rollDice();
				int DiceTwo = newDice.rollDice();
				System.out.println("First Die: "+ DiceOne + " Second Die: " + DiceTwo);

				if(playerOne){
					if(DiceOne == DiceTwo){
						isPair(DiceOne, DiceTwo);
					}else{
						playerTwo = true;
						playerOne = false;
					}

					if(DiceOne == DiceTwo && DiceOne == 1){
						playerOnePoints = 0;
					}else{
						playerOnePoints = playerOnePoints + DiceOne+DiceTwo;
					}
				}
				else if(playerTwo){
					if(DiceOne == DiceTwo){
						isPair(DiceOne, DiceTwo);
					}else{
						playerOne = true;
						playerTwo = false;
					}

					if(DiceOne == DiceTwo && DiceOne == 1){
						playerTwoPoints = 0;
					}else{
						playerTwoPoints = playerTwoPoints + DiceOne+DiceTwo;

					}


				}
				System.out.println("playerOnePoints: "+ playerOnePoints);
				System.out.println("playerTwoPoints: "+ playerTwoPoints);
			}
			else{
				System.out.println("Not a valid input! Either roll or end.");
			}
		}
	}




	public static void isPlayer(boolean a, boolean b){
		if(a){
			System.out.println("Player ones turn.");
		}
		if(b){
			System.out.println("Player twos turn.");
		}
	}


	public static void isPair(int a, int b){
		if(playerOne){
			if(a == b)
				playerOne = true;
			playerTwo = false;
		}
		/*if(a == 1){
					playerOnePoints = 0;
				}*/
		else if(a == 6){
			if(wasLastRollDoubleSix){
				System.out.println("Player One has won!!!!!1111ELEVEN");
				Game = false;

			}
			wasLastRollDoubleSix = true;
		}
		if(playerTwo){
			if(a == b){
				playerTwo = true;
				playerOne = false;
			}
			/*if(a == 1){
					playerTwoPoints = 0;
				}*/
			else if( a == 6){
				if(wasLastRollDoubleSix){
					System.out.println("Player One has won!!!!!1111ELEVEN");
					Game = false;

				}
				//fejl ved 66666666 - rettes senere
				wasLastRollDoubleSix = true;
			}
		}

	}

}












