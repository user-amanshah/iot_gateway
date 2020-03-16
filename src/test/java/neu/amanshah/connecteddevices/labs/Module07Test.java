/**
 * 
 */
package neu.amanshah.connecteddevices.labs;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import neu.amanshah.connecteddevices.labs.module07.CoapServerManager;

/**
 * Test class for all requisite Module07 functionality.
 * 
 * Instructions:
 * 1) Rename 'testSomething()' method such that 'Something' is specific to your needs; add others as needed, beginning each method with 'test...()'.
 * 2) Add the '@Test' annotation to each new 'test...()' method you add.
 * 3) Import the relevant modules and classes to support your tests.
 * 4) Run this class as unit test app.
 * 5) Include a screen shot of the report when you submit your assignment.
 * 
 * Please note: While some example test cases may be provided, you must write your own for the class.
 */
public class Module07Test
{
	// setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}
	// test methods
	/**
	 * Unit Test Method to check the functioning of start server method
	 */
	@Test
	public void test_server_start()
	{
		CoapServerManager coap_mang = new CoapServerManager();
		coap_mang.start();
		assertTrue(CoapServerManager.flag_variable_start);
		coap_mang.stop();
	}
	/**
	 * Unit Test Method to check the functioning of addendpoints method
	 */
	@Test
	public void test_addendpoints()
	{
		CoapServerManager coap_mang = new CoapServerManager();
		coap_mang.start();
		assertTrue(CoapServerManager.flag_variable_add);
		coap_mang.stop();
	}
	
}
