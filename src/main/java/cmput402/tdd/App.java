package cmput402.tdd;

import java.util.Scanner;
import cmput402.tdd.game.*;

/**
 * Hello world!
 *
 */
public class App 
{
    static User user;
    public static void main( String[] args )
    {
	user = new User();
	user.addBalance(100);
	int userSelection = 0;
	boolean playing = true;
	
	while(playing){
		promptUser(user);
		userSelection = getUserInput(new IntegerAsker(System.in, System.out));
		if(userSelection == 1){
			BlackJackGame game = new BlackJackGame();
			game.playGame();
		}
	
		if(userSelection == 2){
			playing = false;
		}
	}
	System.out.println("Have a great day! You left with " + user.getBalance() + " gp.");
    }

    public static void promptUser(User user){
	System.out.println("Welcome to the Scarlet Gate Casino! \nYour goal is to acquire as much wealth as possible!");
	System.out.println("Your current wealth:" + user.getBalance() + " gp");
	System.out.println("\nChoose a game to play:");
	System.out.println("1: BlackJack");
	System.out.println("2: Exit");
    }

    public static int getUserInput(IntegerAsker asker){
	    int input = asker.ask("Enter 1-2");
	    while (input < 1 || input > 2){
		    input = asker.ask("Only 1 or 2 is accepted");
	    }
	    return input;
    }
}
