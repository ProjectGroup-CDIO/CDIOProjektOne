package ProjectOne;

import java.util.Scanner;

import boundaryToMatador.GUI;

public class DiceGame {

	static int playerOnePoints = 0;
	static int playerTwoPoints = 0; //Here each players points are stored as a variable int

	static boolean playerOne = true;
	static boolean playerTwo = false; // these two variables are used to determine which players turn it is

	static boolean wasLastRollDoubleSix = false;

	static boolean Game = true; /*This variable is used to determine whether or not the game is 
	still active*/


		
	public static void main(String[] args) {
		System.out.println("This is a game, roll the dice if you are player one");

		Scanner CS = new Scanner(System.in); // the scanner is activated. 


		Die newDice = new Die(); //a new instance of the class Die is initialized
	
		GUI.addPlayer("Player Two", playerTwoPoints);
		GUI.addPlayer("Player One", playerOnePoints);
	

		while(Game){
		
		
			System.out.println("Write 'roll' to roll. \nWrite 'end' to end game and view score.");

			
			isPlayer(playerOne,playerTwo);//isPlayer method is called which determines whose turn it is
			String i = GUI.getUserButtonPressed("","Roll Dice");

			if(i.equals("end")){
				System.out.println(playerOnePoints);
				System.out.println(playerTwoPoints);
				Game = false;
				//break; //

			}else if(i.equals("Roll Dice")){
		
				System.out.println("rolling the dice");

				int diceOne = newDice.rollDice();//two integers are created to store faceValue
				int diceTwo = newDice.rollDice();
				GUI.setDice(diceOne, diceTwo);
				System.out.println("First Die: "+ diceOne + " Second Die: " + diceTwo);


				if(playerOne){
					if(diceOne == diceTwo){
						isPair(diceOne, diceTwo); //isPair method is called
					}else{
						playerTwo = true;
						playerOne = false; //if player one rolls a pair, player will get another turn
					}

					if(diceOne == diceTwo && diceOne == 1){
						playerOnePoints = 0; //resets score if player rolls a pair of ones
					}else{

						playerOnePoints = playerOnePoints + diceOne+diceTwo;
						GUI.setBalance("Player One", playerOnePoints);

					}
				}
				else if(playerTwo){
					if(diceOne == diceTwo){
						isPair(diceOne, diceTwo);
					}else{
						playerOne = true;
						playerTwo = false;
					}

					if(diceOne == diceTwo && diceOne == 1){
						playerTwoPoints = 0;
					}else{

						playerTwoPoints = playerTwoPoints + diceOne+diceTwo;
						GUI.setBalance("Player Two", playerTwoPoints);


			

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










