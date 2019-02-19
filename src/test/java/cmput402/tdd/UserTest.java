package cmput402.tdd;

import cmput402.tdd.game.Game;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class UserTest {

    @Test
    public void checkBalanceUpdateTest() {
        User user = new User();
        int balance = user.getBalance();
        assertEquals(balance, 0);
        user.addBalance(10);
        assertEquals(user.getBalance(), 10);
    }

    @Test
    public void changeGameTest() {
        Game mock = mock(Game.class);
        User user = new User();
        user.setCurrentGame(mock);
        assertEquals(user.getCurrentGame(), mock);
    }

    @Test
    public void placeBetWorks() {
        User user = new User();
        user.addBalance(100);
        user.placeBet(90);
        assertEquals(user.getBalance(), 10);
    }

    @Test
    public void userCantBetMoreThaTheyHave() {
        Game game = mock(Game.class);
        User user = new User();
        user.addBalance(10);
        assertFalse(user.placeBet(20));
        assertEquals(user.getBalance(), 10);
    }
}
