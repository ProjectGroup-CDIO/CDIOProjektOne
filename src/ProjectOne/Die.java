package ProjectOne;

import java.util.Random;

public class Die {

	Random rand = new Random();

	//+1 for else it would be 0 - 5

	public int rollDice(){
		int dice = rand.nextInt(6) + 1; 
		return dice;
	}
}
