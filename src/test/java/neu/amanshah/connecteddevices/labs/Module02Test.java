/**
 * 
 */
package neu.amanshah.connecteddevices.labs;




import static org.junit.Assert.assertTrue;
import neu.amanshah.connecteddevices.labs.module02.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import neu.amanshah.connecteddevices.labs.module02.TempEmulatorAdaptor;
//import neu.amanshah.connecteddevices.labs.module02.TempSensorEmulator;

/**
 * Test class for all requisite Module02 functionality.
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
public class Module02Test
{
	// setup methods
	
	
	TempSensorEmulator emulator = new TempSensorEmulator();
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void checkconf()
	{
		// check if the file exists or not
		
		ConfigUtil conf_obj = new ConfigUtil();
		
		// check if the values are getting returned from the config file
		//check all neccessary smtp parameters
		boolean flag=conf_obj.loadconfig();
		assertTrue(flag==true);
		assertTrue(conf_obj.getvalue("smtp.cloud", "port") != null);
		assertTrue(conf_obj.getvalue("smtp.cloud", "host") != null);
		assertTrue(conf_obj.getvalue("smtp.cloud", "fromAddr") != null);
		assertTrue(conf_obj.getvalue("smtp.cloud", "toAddr") != null);
		assertTrue(conf_obj.getvalue("smtp.cloud", "password") != null);
		
		
	}

	
	@Test
	public void initialize()
	{
		
		assertTrue(emulator.getCurrent() <100.0);
		
		assertTrue(emulator.getAvgtemp() <100.0);
		assertTrue(emulator.getMaxtemp() <100.0);
		
		 // it follows that if avg and current values are in range , the max and min values are in range
				//check if the function returns valid smtp parameters


		
	}




}
