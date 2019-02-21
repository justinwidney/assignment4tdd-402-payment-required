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
		userSelection = promptUser();
	
		if(userSelection == 1){
			BlackJackGame game = new BlackJackGame();
//			game.play();
		}
	
		if(userSelection == 2){
			playing = false;
		}
	}
	System.out.println("Have a great day! You left with " + user.getBalance() + " gp.");
    }

    public static int promptUser(){
	int userSelection = 0;
	while (userSelection == 0){
		System.out.println("Welcome to the Scarlet Gate Casino! \nYour goal is to acquire as much wealth as possible!");
		System.out.println("Your current wealth:" + user.getBalance() + " gp");
		System.out.println("\nChoose a game to play:");
		System.out.println("1: BlackJack");
		System.out.println("2: Exit");
		
		Scanner input = new Scanner(System.in);
		if(input.hasNextInt()){
			userSelection = input.nextInt();
		}
	}
	return userSelection;
    }
}
