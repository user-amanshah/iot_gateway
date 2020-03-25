/**
 * 
 */
package neu.amanshah.connecteddevices.labs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import neu.amanshah.connecteddevices.labs.module08.UbidotsApiConnector;
import neu.amanshah.connecteddevices.labs.module08.Ubidots_connector;

/**
 * Test class for all requisite Module08 functionality.
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
public class Module08Test
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
	 * 
	 */
	
	
	// test to sset up dummy temp value, connection to ubidots
	@Test
	public void test_UbidotsApi()
	{
		double testTemp = 15.0;
		
		UbidotsApiConnector api = new UbidotsApiConnector();
		api.publish(testTemp);
		

	}
	
	@Test
	public void testUbidots_Clientconnector_method() 
	{
		// api token of ubidots
		String testToken = "BBFF-DDJefJiPLcbNPpQHcfbGDM8Z4vJWiU";
		
		Ubidots_connector ubi = new Ubidots_connector("industrial.api.ubidots.com",testToken,"industrial.pem");
		ubi.ubidots_mqtt_connect();
		ubi.ubidots_mqtt_subscribe();
		
	}
	
	
	// test to run simulated test to send data
	@Test
	public void test_publishing()
	{
		int i= 10;
		while(i!=0)
		{
		String testData = "testing data ";
		byte[] testPayload = testData.getBytes();
		Ubidots_connector mqtt = new Ubidots_connector();
		mqtt.ubidots_mqtt_connect();
		mqtt.publishMessage("mqtt_topic", 2, testPayload);
		i--;
		}
	}
	
}
