package ProjectOne;

public class Tests {

	public static void main(String[] args) {
		
		DiceGame newgame = new DiceGame();
		
		int z = 0;
		
		int[] array1 = {2,2,6,4,5,5,5,5,5,5,5,5,5};
		int[] array2 = {3,2,6,6,4,4,4,4,4,4,4,4,4};
		
		
		for(int i = array1.length; i>z;i--){
		newgame.gameLogic("roll", array1[z], array2[z]);
		z++;
		}
		
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
