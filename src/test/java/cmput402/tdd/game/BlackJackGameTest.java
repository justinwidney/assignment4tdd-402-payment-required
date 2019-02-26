package cmput402.tdd.game;

import cmput402.tdd.User;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

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
		assert(fakeHand.get(2) <= 10);
	}

	@Test
	public void testDrawCardBust(){
		ArrayList<Integer> fakeHand = new ArrayList<Integer>();

		BlackJackGame game = new BlackJackGame();
		game.user = new User();

		game.addCard(10);
		game.addCard(9);
		game.addCard(2);
		game.drawCard();
		fakeHand = game.getHand();

		assert(fakeHand.get(0) == 10);
		assert(fakeHand.get(1) == 9);
		assert(fakeHand.get(2) == 2);
		assert(fakeHand.size() == 4);
		assert(fakeHand.get(3) > 0);
		assert(fakeHand.get(3) <= 10);
		
		int winner = game.compareHands();
		assert(winner == -1);
	}

	@Test
	public void testStartingHand(){
		BlackJackGame game = new BlackJackGame();
		ArrayList<Integer> fakeHand = new ArrayList<Integer>();
		game.resetHand();
		fakeHand = game.getHand();
		assert(fakeHand.size() == 2);
	}

	@Test
	public void testGetTotalHandValue(){
		BlackJackGame game = new BlackJackGame();

		game.addCard(10);
		game.addCard(9);
		game.addCard(2);
		int totalHandValue = game.getTotalHandValue();

		assert(totalHandValue == 21);
	}

	@Test
	public void testRestartHand(){
		BlackJackGame game = new BlackJackGame();
		game.resetHand();
		assert(game.getHand().size() == 2);

		game.addCard(3);
		assert(game.getHand().size() == 3);

		game.resetHand();
		assert(game.getHand().size() == 2);
	}

	@Test
	public void testWinCompareHands(){
		BlackJackGame game = spy(new BlackJackGame());
		game.user = new User();
		game.addCard(10);
		game.addCard(8);
		when(game.getDealerHand()).thenReturn(17);
		int winner = game.compareHands();
		verify(game).getDealerHand();
		assert(winner == 1);
	}

	@Test
	public void testTieCompareHands(){
		BlackJackGame game = spy(new BlackJackGame());
		game.addCard(10);
		game.addCard(7);
		when(game.getDealerHand()).thenReturn(17);
		int winner = game.compareHands();
		verify(game).getDealerHand();
		assert(winner == 0);
	}

	@Test
	public void testLoseCompareHands(){
		BlackJackGame game = spy(new BlackJackGame());
		game.addCard(10);
		game.addCard(6);
		when(game.getDealerHand()).thenReturn(17);
		int winner = game.compareHands();
		verify(game).getDealerHand();
		assert(winner == -1);
	}
	
	@Test
    	public void testPlayGameStayAndWin(){
		String input = "2";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		BlackJackGame game = spy(new BlackJackGame());
		game.user = new User();
		game.addCard(10);
		game.addCard(6);
		game.addCard(5);
		when(game.getDealerHand()).thenReturn(17);

		game.playGame();
	}

	@Test
    	public void testPlayGameStayAndTie(){
		String input = "2";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		BlackJackGame game = spy(new BlackJackGame());
		game.addCard(10);
		game.addCard(7);
		when(game.getDealerHand()).thenReturn(17);

		game.playGame();
	}


	@Test
    	public void testPlayGameDrawOver21(){
		String input = "1";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		BlackJackGame game = spy(new BlackJackGame());
		game.addCard(10);
		game.addCard(6);
		game.addCard(5);
		when(game.getDealerHand()).thenReturn(17);

		game.playGame();
	}

}
