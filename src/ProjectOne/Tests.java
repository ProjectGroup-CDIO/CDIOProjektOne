package ProjectOne;

public class Tests {

	public static void main(String[] args) {
		
		DiceGame newgame = new DiceGame();
		
		
		newgame.diceChecks(6, 6);
		newgame.winCheckOneAndTwo();
		newgame.diceChecks(6, 6);
		newgame.winCheckOneAndTwo();
		
	}

}
