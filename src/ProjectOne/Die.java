package ProjectOne;

import java.util.Random;

public class Die {

	Random rand = new Random();
	//+1 for else it would be 0 - 5

	int dice;
	
	public int rollDice(){
		dice = rand.nextInt(6) + 1; 
		return dice;
	}
}
