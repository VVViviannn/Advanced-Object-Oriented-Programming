package application;

import java.util.Scanner;
import implementation.Counter;

public class CounterApp {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Initial value of counter?");
		int v = input.nextInt();
		input.nextLine(); 
		try {
			Counter c = new Counter(v); 
			int counterValue = c.getValue();
		    System.out.println("Counter value starts with " + counterValue);
			boolean userWantsToContinue = true;
			while (userWantsToContinue) {
				System.out.println("Type I for increment, D for decrement, or anything else to exit:");
				String action = input.nextLine();
				if(action.equals("I")) {
					try {
						c.increment();
						System.out.println("Counter value is now " + c.getValue());
					}
					catch(IllegalArgumentException e) {
						System.out.println("Error: too large to increment!");
					}
				}
				else if(action.equals("D")) {
					try {
						c.decrement();
						System.out.println("Counter value is now " + c.getValue());
					}
					catch(IllegalArgumentException e) {
						System.out.println("Error: too small to decrement!");
					}
				}
				else {
					userWantsToContinue = false;
					System.out.println("Bye!");
				}
			}
		}
		catch (IllegalArgumentException e) {
			System.out.print("Error: initial value too large!");
		}
		input.close();
	}
}
