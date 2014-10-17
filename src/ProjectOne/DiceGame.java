package ProjectOne;

// import java.util.Scanner;

import boundaryToMatador.GUI;

public class DiceGame {

	int playerOnePoints = 0;
	int playerTwoPoints = 0; //Here each players points are stored as a variable int

	boolean playerOne = true;
	boolean playerTwo = false; // these two variables are used to determine which players turn it is


	boolean chanceToWinOne = false;
	boolean chanceToWinTwo = false;

	boolean confirmVicOne = false;
	boolean confirmVicTwo = false;

	boolean firstRollOne = true;
	boolean firstRollTwo = true;
	
	boolean wasLastRollDoubleSix = false;

	boolean game = true; //This variable is used to determine whether or not the game is still active

	long duration = 0;
	long duration2 = 0;
	
	public void game() {
		System.out.println("This is a game, roll the dice if you are Player One");
		//Scanner CS = new Scanner(System.in); // the scanner is activated for TUI

		Die newDice = new Die(); //a new instance of the class Die is initialized
	
		GUI.addPlayer("Player Two", playerTwoPoints); // Creates player 2 on the board
		GUI.addPlayer("Player One", playerOnePoints); // Creates player 1 on the board
		

		while(game){

			System.out.println("Write 'Roll Dice' to roll. \nWrite 'end' to end game and view score.");
			String i = "";
			i = GUI.getUserButtonPressed(null, "Roll Dice"); // used for GUI. Returns the string "Roll Dice"
			isPlayer(playerOne,playerTwo);
			//i = CS.nextLine(); // used for TUI
			int dieOne = newDice.rollDice(); //integer is created to represent faceValue of die
			int dieTwo = newDice.rollDice();

			gameLogic(i, dieOne, dieTwo);
			//z++;
		}

		checkForWinner();
	}




	public void checkForWinner() {
		if (game != true)
		{
			long startTime2 = System.currentTimeMillis();
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
				GUI.addPlayer("Player Two is the Winner!!!!", playerTwoPoints);
			}
			if(playerOnePoints == playerTwoPoints && confirmVicOne == true && confirmVicTwo == true )
			{
				System.out.println("Draw");
				GUI.showMessage("Draw!!");
				GUI.addPlayer("The game was a Draw!!", playerOnePoints);
			}
			long endTime2 = System.currentTimeMillis();
			duration2 = (endTime2 - startTime2);
			System.out.println("That took " + duration2 + " milliseconds");
		}
	}




	public void gameLogic(String i, int diceOne, int diceTwo) {
		long startTime = System.currentTimeMillis();
		if(i.equals("end")){
			System.out.println(playerOnePoints);
			System.out.println(playerTwoPoints);
			game = false;
			//break; 

		}else if(i.equals("Roll Dice")){
			System.out.println("rolling the dice");
			
			GUI.setDice(diceOne, diceTwo);

			System.out.println("First Die: "+ diceOne + " Second Die: " + diceTwo);


			if(playerOne){
				if(diceOne == diceTwo && playerOnePoints >= 40 && diceOne!=1){
					if (firstRollOne){
					confirmVicOne = true;
					}
					
					isPair(diceOne, diceTwo); //isPair is called to give player another turn
				}
				else if(diceOne == diceTwo && playerOnePoints < 40){
					isPair(diceOne, diceTwo);
				}
				else{
					if (confirmVicTwo){
						game = false;
					}
					playerTwo = true;
					playerOne = false;
				}

				if(diceOne == diceTwo && diceOne == 1){
					confirmVicOne = false;
					playerOnePoints = 0;
					playerOne = true;
					playerTwo = false;
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
							game = false;
						}
					}
					else{
						chanceToWinOne = true;
						isPair(diceOne, diceTwo);
					}

				}
				firstRollTwo = true;
			}
			else if(playerTwo){
				if(diceOne == diceTwo && playerTwoPoints >= 40 && diceOne!=1){
					if (firstRollTwo){
					confirmVicTwo = true;
					}
					isPair(diceOne, diceTwo);
				}
				else if(diceOne == diceTwo && playerTwoPoints < 40){
					isPair(diceOne, diceTwo);
				}
				else{
					if (confirmVicOne){
						game = false;
					}
					playerOne = true;
					playerTwo = false;
				}

				if(diceOne == diceTwo && diceOne == 1){
					playerTwoPoints = 0;
					confirmVicTwo = false;
					playerOne = false;
					playerTwo = true;
				}
				else{
					playerTwoPoints = playerTwoPoints + diceOne+diceTwo;
					GUI.setBalance("Player Two", playerTwoPoints);

				}
				if(diceOne == diceTwo && diceOne == 6){
					if(chanceToWinTwo){
						confirmVicTwo = true;
						if (confirmVicOne == true){
							game = false;
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
				firstRollOne = true;
			}
			System.out.println("Player One Points: "+ playerOnePoints);
			System.out.println("Player Two Points: "+ playerTwoPoints);
		}
		else{
			System.out.println("Not a valid input! Either Roll Dice or end.");
		}
		long endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("That took " + duration + " milliseconds");
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


	public void isPair(int a, int b){
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











