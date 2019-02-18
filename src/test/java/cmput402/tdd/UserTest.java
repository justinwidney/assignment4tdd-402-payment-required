package cmput402.tdd;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import junit.framework.TestCase;
import org.junit.Test;

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
}
