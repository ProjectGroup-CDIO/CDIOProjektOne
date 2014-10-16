package ProjectOne;

public class Tests {

	public static void main(String[] args) {
		
		DiceGame newgame = new DiceGame();
		
		int z = 0;
		
		int[] array1 = {2,2,6,4,5,5,5,5,5,5,5,5,5};
		int[] array2 = {3,2,6,6,4,4,4,4,4,4,4,4,4};
		int DiceOne = array1[z];
		int DiceTwo = array2[z];
		
		newgame.gameLogic("roll", DiceOne, DiceTwo);
		
		
		
		/*
		newgame.diceChecks(6, 6);
		System.out.println("playerOnePoints: "+ newgame.playerOnePoints);
		System.out.println("playerTwoPoints: "+ newgame.playerTwoPoints);
		newgame.diceChecks(6, 6);
		System.out.println("playerOnePoints: "+ newgame.playerOnePoints);
		System.out.println("playerTwoPoints: "+ newgame.playerTwoPoints);
		*/
	}
}
