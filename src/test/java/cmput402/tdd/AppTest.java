package cmput402.tdd;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	
	Util util = new Util();
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testGetUserInput() {
    	IntegerAsker asker = mock(IntegerAsker.class);
	when(asker.ask("Enter 1-2")).thenReturn(3);
	when(asker.ask("Only 1 or 2 is accepted")).thenReturn(2);
	assertEquals(App.getUserInput(asker), 2);
	verify(asker).ask("Only 1 or 2 is accepted");
    }
   
    public void testPromptUser() {
	App app = new App();
	User user = mock(User.class);
	when(user.getBalance()).thenReturn(50);
	app.promptUser(user);
	verify(user).getBalance();
    }

    public void testMainExit(){
	String input = "2";
	System.setIn(new ByteArrayInputStream(input.getBytes()));

	String[] args = {};
	App.main(args);
    }

    public void testGetUserBet() {
        IntegerAsker asker = mock(IntegerAsker.class);
        User user = new User();
        user.addBalance(100);
        when(asker.ask("Please enter a bet")).thenReturn(50);
        assertEquals(App.getUserBet(asker, user), 50);
    }


}
