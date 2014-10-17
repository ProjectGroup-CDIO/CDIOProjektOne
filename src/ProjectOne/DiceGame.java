package ProjectOne;

import java.util.Scanner;

public class DiceGame {

	int playerOnePoints = 0;
	int playerTwoPoints = 0; //Here each players points are stored as a variable int

	boolean playerOne = true;
	boolean playerTwo = false; // these two variables are used to determine which players turn it is

	boolean chanceToWinOne = false;
	boolean chanceToWinTwo = false;

	boolean confirmVicOne = false;
	boolean confirmVicTwo = false;

	boolean wasLastRollDoubleSix = false;

	boolean Game = true; /*This variable is used to determine whether or not the game is 
	still active*/

	public  void game() {
		System.out.println("This is a game, roll the dice if you are player one");

		Scanner CS = new Scanner(System.in); // the scanner is activated. 

		Die newDice = new Die(); //a new instance of the class Die is initialized

		//int z = 0;

		while(Game){
			System.out.println("Write 'roll' to roll. \nWrite 'end' to end game and view score.");

			String i = CS.nextLine();
			int DiceOne = newDice.rollDice();
			int DiceTwo = newDice.rollDice();
			gameLogic(i, DiceOne, DiceTwo);
			//z++;
		}

		gameEndCheck();
	}




	public void gameEndCheck() {
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




	public void gameLogic(String i, int DiceOne, int DiceTwo) {
		isPlayer(playerOne,playerTwo);
		if(i.equals("end")){
			System.out.println(playerOnePoints);
			System.out.println(playerTwoPoints);
			Game = false;
			//break; 

		}else if(i.equals("roll")){
			System.out.println("rolling the dice");
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
			System.out.println("playerOnePoints: "+ playerOnePoints);
			System.out.println("playerTwoPoints: "+ playerTwoPoints);
		}
		else{
			System.out.println("Not a valid input! Either roll or end.");
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











