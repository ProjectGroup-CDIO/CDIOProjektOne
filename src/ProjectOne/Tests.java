package ProjectOne;

public class Tests {

	public static void main(String[] args) {
		
		DiceGame newgame = new DiceGame();
		
		
		
		//test one double pair 6
		int[] array1 = {2,2,6,6,4,2};
		int[] array2 = {3,2,6,6,3,3};
		for(int i = 0; i<array1.length;i++){
		newgame.gameLogic("roll", array1[i], array2[i]);
		if(!newgame.Game){
			break;
		}
		}
		newgame.gameEndCheck();
		System.out.println("Test one completed expected player to win - confirmed?");
		
		

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
