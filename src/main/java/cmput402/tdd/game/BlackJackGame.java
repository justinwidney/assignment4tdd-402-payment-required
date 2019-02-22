package cmput402.tdd.game;

import java.util.ArrayList;
import java.util.Random;

import cmput402.tdd.App;
import cmput402.tdd.IntegerAsker;

public class BlackJackGame extends Game{
	ArrayList<Integer> playerHand = new ArrayList<Integer>();
	int winner = 0;

	public void playGame(){
		boolean playing = true;
		int userSelection;
		while(playing){	
			String playerCardsString = "";
			for(int i = 0; i<playerHand.size(); i++){
				playerCardsString += playerHand.get(i) + " ";
			}
			System.out.println("Current hand:" + playerCardsString);
			System.out.println("Total: " + getTotalHandValue());
			System.out.println("1: Draw a card");
			System.out.println("2: Stay");
			userSelection = App.getUserInput(new IntegerAsker(System.in, System.out));
			if(userSelection == 1){
				drawCard();
				if(getTotalHandValue() > 21){
					winner = compareHands();
					playing = false;
				}
			}
			if(userSelection == 2){
				winner = compareHands();
				playing = false;
			}
		}
		if(winner == 1){
			System.out.println("You won!");
		}
		if(winner == 0){
			System.out.println("Tie!");
		}
		if(winner == -1){
			System.out.println("You lost!");
		}
	}

	public ArrayList<Integer> getHand(){
		return playerHand;
	}
	
	public int getTotalHandValue(){
		int totalValue = 0;
		for(int i = 0; i < playerHand.size();i++){
			totalValue += playerHand.get(i);
		}
		return totalValue;
	}

	public void addCard(int card){
		playerHand.add(card);
	}

	public void drawCard(){
		Random rand = new Random();
		int newCard = rand.nextInt(10)+1; // Returns 1-10
		playerHand.add(newCard);
	}

	public void resetHand(){
		playerHand = new ArrayList<Integer>();
		drawCard();
		drawCard();
	}

	public int getDealerHand(){
		Random rand = new Random();
		int totalValue = rand.nextInt(6)+15; // Returns 15-21
		return totalValue;
	}

	public int compareHands(){
		int totalValue = getTotalHandValue();
		int dealerHand = getDealerHand();
		System.out.println("Your hand: " + totalValue);
		System.out.println("Dealer's hand: " + dealerHand);
		if(totalValue > 21){	// Bust
			return -1;
		}
		if(totalValue > dealerHand){
			return 1;
		}
		if(totalValue < dealerHand){
			return -1;
		}
		return 0;	//Tie
	}
}
