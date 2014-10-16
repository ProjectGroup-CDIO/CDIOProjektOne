package ProjectOne;

// import java.util.Scanner;

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


		//Scanner CS = new Scanner(System.in); // the scanner is activated for TUI

		Die newDice = new Die(); //a new instance of the class Die is initialized
		
		
		GUI.addPlayer("Player Two", playerTwoPoints);
		GUI.addPlayer("Player One", playerOnePoints);

		GUI.addPlayer("Player Two", playerOnePoints); // Opretter spiller 2 på brættet
		GUI.addPlayer("Player One", playerOnePoints); // Oprætter spiller 1 på brættet
		

		while(Game){

			System.out.println("Write 'roll' to roll. \nWrite 'end' to end game and view score.");
			String i = "";
			i = GUI.getUserButtonPressed(null, "Roll Dice"); // used for GUI. Returns the string "Roll Dice"
			isPlayer(playerOne,playerTwo);
			//i = CS.nextLine(); // used for TUI


			if(i.equals("end")){
				System.out.println(playerOnePoints);
				System.out.println(playerTwoPoints);
				Game = false;
				//break; 

			}else if(i.equals("Roll Dice")){
				System.out.println("rolling the dice");
				int diceOne = newDice.rollDice(); //integer is created to represent faceValue of die
				int diceTwo = newDice.rollDice();
				GUI.setDice(diceOne, diceTwo);

				/*
				int[] array1 = {2,2,6,4,5,5,5,5,5,5,5,5,5};
				int[] array2 = {3,2,6,6,4,4,4,4,4,4,4,4,4};
				int DiceOne = array1[z];
				int DiceTwo = array2[z];
<<<<<<< HEAD
				*/
				System.out.println("First Die: "+ diceOne + " Second Die: " + diceTwo);


				if(playerOne){
					if(diceOne == diceTwo && playerOnePoints >= 40 && diceOne!=1){
						confirmVicOne = true;
						isPair(diceOne, diceTwo); //isPair is called to give player another turn
					}
					else if(diceOne == diceTwo && playerOnePoints < 40){
						isPair(diceOne, diceTwo);
					}
					else{
						if (confirmVicTwo){
							Game = false;
						}
						playerTwo = true;
						playerOne = false;
					}

					if(diceOne == diceTwo && diceOne == 1){
						confirmVicOne = false;
						playerOnePoints = 0;
						isPair(diceOne, diceTwo);
					}
					else{

						playerOnePoints = playerOnePoints + diceOne+diceTwo;
						GUI.setBalance("Player One", playerOnePoints);

					}
					if(diceOne == diceTwo && diceOne == 6){
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
							isPair(diceOne, diceTwo);
						}

					}
				}
				else if(playerTwo){
					if(diceOne == diceTwo && playerTwoPoints >= 40 && diceOne!=1){
						confirmVicTwo = true;
						isPair(diceOne, diceTwo);
					}
					else if(diceOne == diceTwo && playerTwoPoints < 40){
						isPair(diceOne, diceTwo);
					}
					else{
						if (confirmVicOne){
							Game = false;
						}
						playerOne = true;
						playerTwo = false;
					}

					if(diceOne == diceTwo && diceOne == 1){
						playerTwoPoints = 0;
						confirmVicTwo = false;
						isPair(diceOne, diceTwo);
					}
					else{
						playerTwoPoints = playerTwoPoints + diceOne+diceTwo;
						GUI.setBalance("Player Two", playerTwoPoints);

					}
					if(diceOne == diceTwo && diceOne == 6){
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
							isPair(diceOne, diceTwo);
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
				GUI.showMessage("PlayerOne Won");
				GUI.addPlayer("Player One is the Winner!!!!", playerOnePoints);
				
			}
			if((confirmVicTwo && !confirmVicOne ) || (playerOnePoints < playerTwoPoints && confirmVicTwo))
			{
				System.out.println("PlayerTwo Won");
				GUI.showMessage("PlayerTwo Won");
				GUI.addPlayer("Player Two is the Winner!!!!", playerOnePoints);
			}
			if(playerOnePoints == playerTwoPoints && confirmVicOne == true && confirmVicTwo == true )
			{
				System.out.println("Draw");
				GUI.showMessage("Draw!!");
				GUI.addPlayer("The game was a Draw!!", playerOnePoints);
			}

		}
	}
		



	public static void isPlayer(boolean a, boolean b){
		if(a){
			System.out.println("Player ones turn.");
			GUI.showMessage("Player ones turn");
			
		}
		if(b){
			System.out.println("Player twos turn.");
			GUI.showMessage("Player twos turn");
			
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











