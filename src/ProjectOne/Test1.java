package ProjectOne;

public class Test1 {

	public static void main(String[] args) {
		
		Die newDice = new Die();
		
		int ones = 0;
		int twoes = 0;
		int threes = 0;
		int fours = 0;
		int fivers = 0;
		int sixers = 0;
		int faceValue;
		for(int i = 0; i < 10000000; i++){
			faceValue = newDice.rollDice();
			
			if(faceValue == 1){
				ones = ones + 1;
			}
			if(faceValue == 2){
				twoes= twoes + 1;
			}
			if(faceValue == 3){
				threes = threes + 1;
			}
			if(faceValue == 4){
				fours = fours + 1;
			}
			if(faceValue == 5){
				fivers = fivers + 1;
			}
			if(faceValue == 6){
				sixers = sixers + 1;
			}
		}
		System.out.println("Nr of 1 rolled: " +ones);
		System.out.println("Nr of 2 rolled: "+twoes);
		System.out.println("Nr of 3 rolled: "+threes);
		System.out.println("Nr of 4 rolled: "+fours);
		System.out.println("Nr of 5 rolled: "+fivers);
		System.out.println("Nr of 6 rolled: "+sixers);
	}
	
	
}
