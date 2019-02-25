package cmput402.tdd;

import cmput402.tdd.game.BlackJackGame;

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
			game.user = user;
			game.promptBet();
			game.playGame();
		}
	
		if(userSelection == 2){
			playing = false;
		}
		if (user.getBalance() == 0) {
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

	public static int getUserBet(IntegerAsker asker, User user) {
		int input = asker.ask("Please enter a bet");
		while (input < 0 || input > user.getBalance()) {
			input = asker.ask("Please enter a number greater than 0 and less than your balance");
		}
		System.out.println(input);
		return input;
	}
}
