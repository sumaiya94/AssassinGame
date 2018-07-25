import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class AssassinMain {

	public static void main(String[] args) throws FileNotFoundException
	{
		// Open file that contains names of players
		java.io.File file = new java.io.File("Names.txt");
		
		// Create scanner to read names from file
		Scanner s = new Scanner(file);
				
		// Node for the players in the game
		LinkedList<String> alive = new LinkedList<String>();
		 
		// Variable to read names from file
		String content;
		
		// Read names from file
		while (s.hasNext())
		{
			content = s.nextLine();
			alive.add(content);			
		}

		// Close the file
		s.close();
				
		// Scanner for user input 
		Scanner scanner = new Scanner(System. in);		
			
		// Stack for dead players
		Stack<String> dead = new Stack<String>();
		
		// Play game until one person is left
		while (alive.size() != 1)
		{
			// Print players
			System.out.println("Alive: " + alive);
						
			
			// Prompt user to kill a person
			System.out.print("Who do you want to kill? ");
			String kill = scanner.nextLine();
			
			// Name of user input matches name of a person alive
			if (alive.remove(kill))
			{
				// Add the player to the dead list
				dead.add(kill);
				
				System.out.println(); // Blank line
				
				// Print dead list
				System.out.println("Dead: " + dead);				
			}
			// User enters wrong name
			else
			{
				System.out.println("Name not in the list.");
				System.out.println(); // Blank line
			}
		}
		
		String win;
		
		// Position of winner in the linked list
		win = alive.get(0);
		
		// Create stack
		Stack<String> winner = new Stack<String>();
		
		// Add the winner to the stack
		winner.push(win);
		
		// Display the winner
		System.out.println("Winner: " + winner.peek());
		
	}

}
