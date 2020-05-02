import java.util.ArrayList;
import java.util.Scanner;

public class NumGame {


	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		ArrayList<Guess> list = new ArrayList<Guess>();
		boolean answerGuessed = false;
		System.out.println(
				"Welcome to the game! Enter a sequence of 3 numbers seperated by spaces to try to guess the rule. Type 'answer' to enter your answer or 'previous' to see previous answers.");

		while (!answerGuessed) {
			String choice = kb.nextLine();
			
			if(choice.contains("answer")){
				System.out.println("Enter the rule: ");
				kb.nextLine();
				System.out.println("The rule is that each number is greater than the one before. Thanks for playing.");
				answerGuessed = true;
			}
			
			else if(choice.contains("previous")){
				for(int x = 0; x < list.size(); x++ )
					System.out.println(list.get(x));
			}
			
			else {
				try{
					String[] guess = choice.split("[ ]+");
					
					if(guess.length > 3){
						throw new TooManyNumbers();
					}
					
					else if(guess.length < 3){
						throw new TooFewNumbers();
					}
					
					int i1 = Integer.parseInt(guess[0]);
					int i2 = Integer.parseInt(guess[1]);
					int i3 = Integer.parseInt(guess[2]);
					
					
					boolean f = true;
					if(i1 < i2 && i2 < i3){
						Guess g =  new Guess(i1,i2,i3, f);
						list.add(g);
						System.out.println("This follows the rule.");
					}
					else{
						Guess g = new Guess(i1, i2, i3, !f);
						list.add(g);
						System.out.println("Sorry, this doesn't follow the rule.");
					}
				}
				 catch (TooManyNumbers ex){
						System.out.println("Too many numbers. Please enter only 3 numbers.");
					}
				catch (TooFewNumbers ex2){
					System.out.println("Not enough numbers, please enter 3 numbers");
				}
				catch (Exception ex4){
				    System.out.println("Whoops! Something went wrong. Try again!");
				}
				
				
				
			}
			
		}
	}
}




