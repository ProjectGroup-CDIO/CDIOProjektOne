package ProjectOne;

// import java.util.Scanner;

import boundaryToMatador.GUI;

public class DiceGame {

	int playerOnePoints = 0;
	int playerTwoPoints = 0; //Here each players points are stored as a variable int

	boolean playerOne = true;
	boolean playerTwo = false; // these two variables are used to determine which players turn it is

	//Variables which are meant to set a player in winning-condition.
	boolean chanceToWinOne = false;
	boolean chanceToWinTwo = false;

	//Variables which are meant to set a player to win, if chanceToWin == true
	boolean confirmVicOne = false;
	boolean confirmVicTwo = false;

	//Check if its the first roll in the turn
	boolean firstRollOne = true;
	boolean firstRollTwo = true;
	
	//Chech if the game is still running
	boolean game = true; //This variable is used to determine whether or not the game is still active

	
	//This is the game
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
			//i = CS.nextLine(); // used when only using TUI
			int dieOne = newDice.rollDice(); //integer is created to represent faceValue of die
			int dieTwo = newDice.rollDice();
			gameLogic(i, dieOne, dieTwo); //Runs the game
			isPlayer(playerOne,playerTwo);
		}
		checkForWinner();//When the game ends. It checks which player have won
	}




	public void checkForWinner() {
		long startTime2 = System.currentTimeMillis();
		if (game != true)
		{
			//PlayerOne won
			System.out.println("Resolving which player which wins");
			if( confirmVicOne  && !confirmVicTwo || (playerTwoPoints < playerOnePoints && confirmVicOne))
			{
				System.out.println("PlayerOne Won");
			GUI.showMessage("PlayerOne Won");
			GUI.addPlayer("Player One is the Winner!!!!", playerOnePoints);
				
			}
			//PlayerTwo won
			if((confirmVicTwo && !confirmVicOne ) || (playerOnePoints < playerTwoPoints && confirmVicTwo))
			{
				System.out.println("PlayerTwo Won");
			GUI.showMessage("PlayerTwo Won");
			GUI.addPlayer("Player Two is the Winner!!!!", playerTwoPoints);
			}
			//PlayerOne and PlayerTwo both won and have equal points
			if(playerOnePoints == playerTwoPoints && confirmVicOne == true && confirmVicTwo == true )
			{
				System.out.println("Draw");
			GUI.showMessage("Draw!!");
			GUI.addPlayer("The game was a Draw!!", playerOnePoints);
			}
			
		}
		long endTime2 = System.currentTimeMillis(); //Endtime
		System.out.println("End game Check took " + (endTime2 - startTime2)  + " milliseconds");
	}




	public void gameLogic(String i, int dieOne, int dieTwo) {
		long startTime = System.currentTimeMillis();//Starttime
		if(i.equals("end")){
			System.out.println(playerOnePoints);
			System.out.println(playerTwoPoints);
			game = false;
			//break; 

		}else if(i.equals("Roll Dice")){
			System.out.println("rolling the dice");
			
			GUI.setDice(dieOne, dieTwo);

			System.out.println("First Die: "+ dieOne + " Second Die: " + dieTwo);


			if(playerOne){
				if(dieOne == dieTwo && playerOnePoints >= 40 && dieOne!=1){
					if (firstRollOne){
					confirmVicOne = true;//Player is set to win
					}
					
					isPair(dieOne, dieTwo); //isPair is called to give player another turn
				}
				else if(dieOne == dieTwo && playerOnePoints < 40){
					isPair(dieOne, dieTwo);
				}
				else{
					if (confirmVicTwo){
						game = false;//If the playerTwo have won, the game ends
					}
					playerTwo = true;//Player turn switches
					playerOne = false;
				}

				if(dieOne == dieTwo && dieOne == 1){
					confirmVicOne = false;//If the player was about to win. Then it is no longer the case
					playerOnePoints = 0;//Reset points
					playerOne = true;
					playerTwo = false;
				}
				else{

					playerOnePoints = playerOnePoints + dieOne+dieTwo;//Summation of points
					GUI.setBalance("Player One", playerOnePoints);

				}
				if(dieOne == dieTwo && dieOne == 6){
					if(chanceToWinOne){
						confirmVicOne = true;//If previously in winning conditions. The player have won
						playerTwo = true;
						playerOne = false;
						//first pair of 6s sets the player in winning condition
						if (confirmVicTwo == true){
							game = false;
						}
					}
					else{
						chanceToWinOne = true;
						isPair(dieOne, dieTwo);
					}

				}
				firstRollTwo = true;//PlayerTwo gets firtroll
			}
			else if(playerTwo){
				if(dieOne == dieTwo && playerTwoPoints >= 40 && dieOne!=1){
					if (firstRollTwo){
					confirmVicTwo = true;
					}
					isPair(dieOne, dieTwo);
				}
				else if(dieOne == dieTwo && playerTwoPoints < 40){
					isPair(dieOne, dieTwo);
				}
				else{
					if (confirmVicOne){
						game = false;
					}
					playerOne = true;
					playerTwo = false;
				}

				if(dieOne == dieTwo && dieOne == 1){
					playerTwoPoints = 0;
					confirmVicTwo = false;
					playerOne = false;
					playerTwo = true;
				}
				else{
					playerTwoPoints = playerTwoPoints + dieOne+dieTwo;
					GUI.setBalance("Player Two", playerTwoPoints);

				}
				if(dieOne == dieTwo && dieOne == 6){
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
						isPair(dieOne, dieTwo);
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
		long endTime = System.currentTimeMillis();//Endtime
		System.out.println("Game logic took " +(endTime - startTime)  + " milliseconds");
	}
		



	public static void isPlayer(boolean a, boolean b){
		long startTime = System.currentTimeMillis();
		//Shows turn in GUI
		if(a){
			System.out.println("Player ones turn.");
			GUI.showMessage("Player ones turn");
			
		}
		if(b){
			System.out.println("Player twos turn.");
			GUI.showMessage("Player twos turn");
			
		}
		long endTime = System.currentTimeMillis();
		System.out.println("isPlayer took " + (endTime - startTime) + " milliseconds");
	}


	public void isPair(int a, int b){
		long startTime = System.currentTimeMillis();
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
		long endTime = System.currentTimeMillis();
		System.out.println("isPair took " + (endTime - startTime) + " milliseconds");
	}
}