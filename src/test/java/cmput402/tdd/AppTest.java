package cmput402.tdd;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;

import cmput402.tdd.service.Search;
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

    public void testSample() {
    	
    	assert(2==2);
    }
    public void testCountAverageScore() {
    	Search mockSearch= mock(Search.class);
    	HashMap<String, ArrayList<Integer>> fakeList
    						=new HashMap <String, ArrayList<Integer>>();
    	ArrayList<Integer> values=new ArrayList<Integer>();
    	values.add(100);//number of matches
    	values.add(200);//number of goals
    	fakeList.put("Messi", values);
    
    	values=new ArrayList<Integer>();
    	values.add(90);//number of matches
    	values.add(135);//number of goals
    	fakeList.put("Ronaldo", values);
    	
    	values=new ArrayList<Integer>();
    	values.add(50);//number of matches
    	values.add(100);//number of goals
    	fakeList.put("Neymar", values);
    	when(mockSearch.returnAll()).thenReturn(fakeList);
    	
    	 HashMap<String, Float> result=util.countAverageScore(mockSearch);
    	 
    	 assert(2==result.get("Messi"));
    	 assert(1.5==result.get("Ronaldo"));
    	 assert(2==result.get("Neymar"));
    	 verify(mockSearch).returnAll();
    }
    
    public void testfindTopScorer() {
    	Search mockSearch= mock(Search.class);
    	HashMap<String, ArrayList<Integer>> fakeList
    						=new HashMap <String, ArrayList<Integer>>();
    	ArrayList<Integer> values=new ArrayList<Integer>();
    	values.add(100);//number of matches
    	values.add(200);//number of goals
    	fakeList.put("Messi", values);
    
    	values=new ArrayList<Integer>();
    	values.add(90);//number of matches
    	values.add(135);//number of goals
    	fakeList.put("Ronaldo", values);
    	
    	values=new ArrayList<Integer>();
    	values.add(50);//number of matches
    	values.add(100);//number of goals
    	fakeList.put("Neymar", values);
    	when(mockSearch.returnAll()).thenReturn(fakeList);
    	
    	 String result= util.findTopScorer(mockSearch);
    	 
    	 assert("Messi"==result);
    	 verify(mockSearch).returnAll();
    }
    
}
