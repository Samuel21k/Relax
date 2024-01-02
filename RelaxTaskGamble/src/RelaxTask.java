import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class RelaxTask {

	public static void main(String[] args) {
		
		System.out.println("First Game");
		
		Random random = new Random (); 
		
		
		List <Integer> all_wins = new ArrayList<Integer>(); //List to place all wins
		int wins = 0;					//used to keep record of wins
		int win = 1;
		int loss = -1;
		int count = 0;					//counting how many rounds until reaching 1000000
		int roll = 0;					//counter for how many rolls has there been (max 4)
		double rounds = 1000000;		
		
		while (count != rounds) {
			
			int x = random.nextInt(6)+1; //rolling dice
		
			if (x == 6) {				// if win then add, print and add wins to list 
										
				wins+=1 ;				
				
				System.out.println("$"+ wins +"(+1)");
				
				all_wins.add(win);
				count+=1;
				roll = 0;
										//resetting the value of wins to keep adding to the list
				continue;				//if win then start next loop
				
		} 
			else if (roll == 4){		// if there has been 4 rolls start next iteration of game
				
				count +=1;
				roll = 0;
				
				continue;
			
			
		} 	else {						//add 1 to the counter of rolls
			wins-=1;
			
			System.out.println("$"+ wins +"(-1)");
			all_wins.add(loss);
				roll+=1;
		}
		
		} //GAME ENDS
		
		/// CALCULATING MEAN, VARIANCE and STANDARD DEVIATION ///
		
		double sum = 0;							
		int size = all_wins.size();
		
		for(int i = 0; i < size; i++) 			//getting sum of values from list
		    sum += all_wins.get(i);
		
		double mean = sum/rounds; 				//getting the mean
		
		double variance = 0;
		double SD = 0; 							//standard deviation
		
		for(int i = 0; i < size; i++) 			//first steps to get variance 
		    variance += Math.pow(all_wins.get(i) - mean, 2);
		
		variance /= rounds;  					//getting the variance
		SD = Math.sqrt(variance);
		
		
		
		
		/// Printing statistics ///

			
		System.out.println('\n' + "The mean is: " + mean);
		System.out.println('\n' + "The variance is: " +variance);
		System.out.println('\n' + "The Standard Deviation is: " +SD);
		
	
		}}
