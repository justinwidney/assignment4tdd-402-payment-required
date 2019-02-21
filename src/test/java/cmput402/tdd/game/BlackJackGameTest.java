package cmput402.tdd.game;

import cmput402.tdd.game.BlackJackGame;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

public class BlackJackGameTest{

	@Test
	public void testDrawCard(){
		ArrayList<Integer> fakeHand = new ArrayList<Integer>();

		BlackJackGame game = new BlackJackGame();

		game.addCard(4);
		game.addCard(7);
		game.drawCard();
		fakeHand = game.getHand();

		assert(fakeHand.get(0) == 4);
		assert(fakeHand.get(1) == 7);
		assert(fakeHand.size() == 3);
		assert(fakeHand.get(2) > 0);
		assert(fakeHand.get(2) < 10);
	}

	@Test
	public void testStartingHand(){
	}
}
