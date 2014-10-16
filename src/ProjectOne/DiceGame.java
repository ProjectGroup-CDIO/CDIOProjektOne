package ProjectOne;

import java.util.Scanner;

import boundaryToMatador.GUI;

public class DiceGame {

	static int playerOnePoints = 0;
	static int playerTwoPoints = 0; //Here each players points are stored as a variable int

	static boolean playerOne = true;
	static boolean playerTwo = false; // these two variables are used to determine which players turn it is


	static boolean chanceToWinOne = false;
	static boolean chanceToWinTwo = false;

	static boolean confirmVicOne = false;
	static boolean confirmVicTwo = false;

	static boolean wasLastRollDoubleSix = false;

	static boolean Game = true; //This variable is used to determine whether or not the game is still active


	public static void main(String[] args) {
		System.out.println("This is a game, roll the dice if you are Player One");

		Scanner CS = new Scanner(System.in); // the scanner is activated. 

		Die newDice = new Die(); //a new instance of the class Die is initialized

		GUI.addPlayer("Player Two", playerOnePoints); // Opretter spiller 2 p� br�ttet
		GUI.addPlayer("Player One", playerOnePoints); // Opr�tter spiller 1 p� br�ttet


		while(Game){

			System.out.println("Write 'r' to roll. \nWrite 'end' to end game and view score.");
			//	GUI.getUserButtonPressed(" ", "Throw"); // Opretter kaste-knap
			isPlayer(playerOne,playerTwo);
			String i = CS.nextLine();

			if(i.equals("end")){
				System.out.println(playerOnePoints);
				System.out.println(playerTwoPoints);
				Game = false;
				//break; 

			}else if(i.equals("r")){
				System.out.println("Rolling the dices");
				int DiceOne = newDice.rollDice();
				int DiceTwo = newDice.rollDice();

				GUI.setDice(DiceOne, DiceTwo);

				/*
				int[] array1 = {2,2,6,4,5,5,5,5,5,5,5,5,5};
				int[] array2 = {3,2,6,6,4,4,4,4,4,4,4,4,4};
				int DiceOne = array1[z];
				int DiceTwo = array2[z];
				 */

				System.out.println("First Die: "+ DiceOne + " Second Die: " + DiceTwo);

				if(playerOne){
					if(DiceOne == DiceTwo && playerOnePoints >= 40 && DiceOne!=1){
						confirmVicOne = true;
						isPair(DiceOne, DiceTwo);
					}
					else if(DiceOne == DiceTwo && playerOnePoints < 40){
						isPair(DiceOne, DiceTwo);
					}
					else{
						if (confirmVicTwo){
							Game = false;
						}
						playerTwo = true;
						playerOne = false;
					}

					if(DiceOne == DiceTwo && DiceOne == 1){
						confirmVicOne = false;
						playerOnePoints = 0;
					}
					else{
						playerOnePoints = playerOnePoints + DiceOne+DiceTwo;

						GUI.setBalance("Player One", playerOnePoints);

					}
					if(DiceOne == DiceTwo && DiceOne == 6){
						if(chanceToWinOne){
							confirmVicOne = true;
							playerTwo = true;
							playerOne = false;
							if (confirmVicTwo == true){
								Game = false;
							}
						}
						else{
							chanceToWinOne = true;
							isPair(DiceOne, DiceTwo);
						}

					}
				}
				else if(playerTwo){
					if(DiceOne == DiceTwo && playerTwoPoints >= 40 && DiceOne!=1){
						confirmVicTwo = true;
						isPair(DiceOne, DiceTwo);
					}
					else if(DiceOne == DiceTwo && playerTwoPoints < 40){
						isPair(DiceOne, DiceTwo);
					}
					else{
						if (confirmVicOne){
							Game = false;
						}
						playerOne = true;
						playerTwo = false;
					}

					if(DiceOne == DiceTwo && DiceOne == 1){
						playerTwoPoints = 0;
						confirmVicTwo = false;
					}else{
						playerTwoPoints = playerTwoPoints + DiceOne+DiceTwo;
						GUI.setBalance("Player Two", playerTwoPoints);
					}
					if(DiceOne == DiceTwo && DiceOne == 6){
						if(chanceToWinTwo){
							confirmVicTwo = true;
							if (confirmVicOne == true){
								Game = false;
							}
							playerTwo = false;
							playerOne = true;
						}
						else
						{
							chanceToWinTwo = true;
							isPair(DiceOne, DiceTwo);
						}
					}
				}
				System.out.println("Player One Points: "+ playerOnePoints);
				System.out.println("Player Two Points: "+ playerTwoPoints);
			}
			else{
				System.out.println("Not a valid input! Either r or end.");
			}
			//z++;
		}

		if (Game != true)
		{
			System.out.println("Resolving which player which wins");
			if( confirmVicOne  && !confirmVicTwo || (playerTwoPoints < playerOnePoints && confirmVicOne))
			{
				System.out.println("PlayerOne Won");
			}
			if((confirmVicTwo && !confirmVicOne ) || (playerOnePoints < playerTwoPoints && confirmVicTwo))
			{
				System.out.println("PlayerTwo Won");
			}
			if(playerOnePoints == playerTwoPoints && confirmVicOne == true && confirmVicTwo == true )
			{
				System.out.println("Draw");
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

		if(playerTwo){
			if(a == b){
				playerTwo = true;
				playerOne = false;
			}

		}

	}

}











