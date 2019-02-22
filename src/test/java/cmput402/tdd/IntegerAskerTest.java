package cmput402.tdd;

import cmput402.tdd.game.Game;
import org.junit.Test;

import java.util.Scanner;
import java.io.PrintStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class IntegerAskerTest {

    @Test
    public void testIntegerAsker() {
	IntegerAsker intAsker = mock(IntegerAsker.class);
	when(intAsker.ask("")).thenReturn(5);
	int result = intAsker.ask("");
	assert(result == 5);
    }
}
