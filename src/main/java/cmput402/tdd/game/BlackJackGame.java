package cmput402.tdd.game;

import java.util.ArrayList;
import java.util.Random;

public class BlackJackGame extends Game{
	ArrayList<Integer> playerHand = new ArrayList<Integer>();

	public void playGame(){
	}

	public ArrayList<Integer> getHand(){
		return playerHand;
	}
	
	public int getTotalHandValue(){
		return 0;
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
		int totalValue = 0;
		for(int i=0; i<playerHand.size();i++){
			totalValue += playerHand.get(i);
		}
		int dealerHand = getDealerHand();
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
