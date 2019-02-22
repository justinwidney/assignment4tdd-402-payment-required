package cmput402.tdd;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;

import java.util.ArrayList;
import java.util.HashMap;

import cmput402.tdd.service.Search;
import cmput402.tdd.App;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
	when(asker.ask(anyString())).thenReturn(2);
	assertEquals(App.getUserInput(asker), 2);
    }
   
    public void testPromptUser() {
	    App app = new App();
	    User user = mock(User.class);
	    when(user.getBalance()).thenReturn(50);
	    app.promptUser(user);
	    verify(user).getBalance();
    }
}
