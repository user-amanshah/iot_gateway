/**
 * 
 */
package neu.amanshah.connecteddevices.labs;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import neu.amanshah.connecteddevices.labs.module01.SystemCpuUtiltask;
import neu.amanshah.connecteddevices.labs.module01.SystemMemUtilTask;

/**
 * Test class for all requisite Module01 functionality.
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
public class Module01Test
{
	// setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	
	
	@Test
	public void checkcpuUTILrange() 
	
	// we will check if the utilization is between range of 0 to 100 since its the percent value
	
	{
		
		try {
			//instantiate class
			SystemCpuUtiltask objcpu = new SystemCpuUtiltask();
			 // compare the condition <0 and <100
			assertTrue(0.0 < objcpu.getCpuUtil() && objcpu.getCpuUtil() <= 100.0 );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void Memcheckrange() 
	{  
		// we will check if the utilization is between range of 0 to 100 since its the percent value
		
		
		
		
			try {
				SystemMemUtilTask objMem = new SystemMemUtilTask();
				//Thread.sleep(900);
				assertTrue(0.0 < objMem.memoryutil() && objMem.memoryutil() <= 100.0 );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			
			
		
		
		
	}
	
	
	
}
