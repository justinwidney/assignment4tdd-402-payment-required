package cmput402.tdd.game;

import cmput402.tdd.App;
import cmput402.tdd.User;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class GameTest {

    @Test
    public void testWinBet() {
        User user = new User();
        Game game = mock(Game.class);
        user.addBalance(100);
        game.user = user;
        game.placeBet(100);
        game.winBet();
        assertEquals(user.getBalance(), 200);
        assertEquals(game.getBet(), 0);
    }

    @Test
    public void testLoseBet() {
        User user = new User();
        Game game = mock(Game.class);
        user.addBalance(100);
        game.user = user;
        game.placeBet(100);
        game.loseBet();
        assertEquals(game.getBet(), 0);
    }

    @Test
    public void testPlaceBet() {
        User user = new User();
        user.addBalance(100);
        Game game = mock(Game.class);
        game.user = user;
        assertTrue(game.placeBet(10));
        assertEquals(game.getBet(), 10);
    }

    @Test
    public void testFailedBetReturnsFalse() {
        User user = new User();
        user.addBalance(10);
        Game game = mock(Game.class);
        game.user = user;
        assertFalse(game.placeBet(20));
        assertEquals(game.getBet(), 0);
    }

    @Test
    public void testPromptBet() {
        User user = new User();
        user.addBalance(100);
        App app = new App();
        Game game = mock(Game.class);
        game.user = user;
        String input = "50";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        game.promptBet();
        int bet = game.getBet();
        assertEquals(bet, 50);
    }

    @Test
    public void testInvalidPromptBet() {
        User user = new User();
        user.addBalance(100);
        App app = new App();
        Game game = mock(Game.class);
        game.user = user;
        String input = "-100\n10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        game.promptBet();
        int bet = game.getBet();
        assertEquals(bet, 10);

    }
}
