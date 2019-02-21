package cmput402.tdd.game;

import java.util.ArrayList;
import java.util.Random;

public class BlackJackGame extends Game{
	ArrayList<Integer> values=new ArrayList<Integer>();

	public void playGame(){
	}

	public ArrayList<Integer> getHand(){
		return values;
	}

	public void addCard(int card){
		values.add(card);
	}

	public void drawCard(){
		Random rand = new Random();
		int newCard = rand.nextInt(10)+1; // Returns 1-10
		values.add(newCard);
	}

	public void resetHand(){
	}

	public int getDealerHand(){
		return 0;
	}

	public int compareHands(){
		return 0;
	}
}
