package cmput402.tdd.game;

import cmput402.tdd.App;
import cmput402.tdd.IntegerAsker;
import cmput402.tdd.User;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    @Test
    public void testWinBet() {
        User user = new User();
        Game game = mock(Game.class);
        user.addBalance(100);
        game.placeBet(user, 100);
        game.winBet(user);
        assertEquals(user.getBalance(), 200);
        assertEquals(game.getBet(), 0);
    }

    @Test
    public void testPlaceBet() {
        User user = new User();
        user.addBalance(100);
        Game game = mock(Game.class);
        assertTrue(game.placeBet(user, 10));
        assertEquals(game.getBet(), 10);
    }

    @Test
    public void testFailedBetReturnsFalse() {
        User user = new User();
        user.addBalance(10);
        Game game = mock(Game.class);
        assertFalse(game.placeBet(user, 20));
        assertEquals(game.getBet(), 0);
    }

    @Test
    public void testPromptBet() {
        User user = new User();
        user.addBalance(100);
        App app = new App();
        Game game = mock(Game.class);
        IntegerAsker asker = mock(IntegerAsker.class);
        when(asker.ask("Enter a bet")).thenReturn(50);
        game.promptBet();
        int bet = game.getBet();
        assertEquals(bet, 50);
    }
}
