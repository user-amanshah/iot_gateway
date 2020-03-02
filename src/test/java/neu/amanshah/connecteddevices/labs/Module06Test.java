
/**
 * 
 */

package neu.amanshah.connecteddevices.labs;
import neu.amanshah.connecteddevices.labs.module06.MqttClientConnector;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import neu.amanshah.connecteddevices.labs.module06.MqttClientConnector;

/**
 * Test class for all requisite Module06 functionality.
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
public class Module06Test
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
	
	
	@Test
	public void test_connection()
	
	{
		//checking if connection to broker is successfull
		MqttClientConnector mqtt_obj = new MqttClientConnector();
		assertTrue(mqtt_obj.conection_mqtt());
		
	}
	
	@Test
	public void test_subscribing()
	{
		//checking if sunscribing to topic is successfull
		MqttClientConnector mqtt_obj = new MqttClientConnector();
		assertTrue(mqtt_obj.subscribing_to_mqtt());
		
	}

	
	@Test
	public void test_unsubscribing()
	
	{
		//checking if unsunscribing to topic is successfull
		MqttClientConnector mqtt_obj = new MqttClientConnector();
		assertTrue(mqtt_obj.unsubscribe_topic());
		
	}
	
	@Test
	public void test_disconnecting()
	
	{
		//checking if disconnection to topic is successfull
		MqttClientConnector mqtt_obj = new MqttClientConnector();
		assertTrue(mqtt_obj.disconnect_session());
		
	}
	
}
