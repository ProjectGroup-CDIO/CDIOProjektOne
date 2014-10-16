package ProjectOne;

import java.util.Scanner;

public class DiceGame {

	static int playerOnePoints = 0;
	static int playerTwoPoints = 0; //Here each players points are stored as a variable int

	static boolean playerOne = true;
	static boolean playerTwo = false; // these two variables are used to determine which players turn it is
	static boolean chanceToWinOne = false;
	static boolean chanceToWinTwo = false;
	static boolean confirmVicOne = false;
	static boolean confirmVicTwo = false;
	static boolean firstRollOne = true;
	static boolean firstRollTwo = true;
	
	
	static boolean wasLastRollDoubleSix = false;

	static boolean Game = true; /*This variable is used to determine whether or not the game is 
	still active*/

	public static void main(String[] args) {
		System.out.println("This is a game, roll the dice if you are player one");

		Scanner CS = new Scanner(System.in); // the scanner is activated. 

		Die newDice = new Die(); //a new instance of the class Die is initialized

		int z = 0;
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
				/*
				int[] array1 = {2,2,6,5,5,5,5,5,5,5,5,5,5};
				int[] array2 = {2,2,5,4,5,4,4,4,4,4,4,4,2};
				int DiceOne = array1[z];
				int DiceTwo = array2[z];
				*/
				System.out.println("First Die: "+ DiceOne + " Second Die: " + DiceTwo);

				if(playerOne){
					if(DiceOne == DiceTwo && playerOnePoints >= 40 && DiceOne!=1){
						if (firstRollOne){
							confirmVicOne = true;
						}
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
					firstRollOne = false;
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
					firstRollTwo = true;
				}
				else if(playerTwo){
					if(DiceOne == DiceTwo && playerTwoPoints >= 40 && DiceOne!=1){
						if (firstRollTwo){
							confirmVicTwo = true;
						}
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
					firstRollTwo = false;
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
					firstRollOne = true;
				}
				System.out.println("playerOnePoints: "+ playerOnePoints);
				System.out.println("playerTwoPoints: "+ playerTwoPoints);
			}
			else{
				System.out.println("Not a valid input! Either roll or end.");
			}
		z++;
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












