package cmput402.tdd.game;

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
		fakeHand.add(4);
		fakeHand.add(7);

		BlackJackGame mockGame = mock(BlackJackGame.class);
		when(mockGame.getHand()).thenReturn(fakeHand);

		mockGame.drawCard();

		assert(fakeHand.get(0) == 4);
		assert(fakeHand.get(1) == 7);
		assert(fakeHand.size() == 3);
		assert(fakeHand.get(2) > 0);
		assert(fakeHand.get(2) < 10);
		verify(mockGame).getHand();
	}

	@Test
	public void testStartingHand(){
	}
}
