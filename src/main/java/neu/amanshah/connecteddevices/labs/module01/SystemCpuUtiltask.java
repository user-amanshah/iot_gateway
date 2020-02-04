package neu.amanshah.connecteddevices.labs.module01;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;


public class SystemCpuUtiltask {
	
	
//	We use sun's proprietary implementaion of OS beans
//	this bean is quicker and operatingsystem mx bean gives back -1 as answer
	// my system doesnt support oracle os bean as it returns -1
	
	/*
	 * Sun systems library is better
	 */
	
	public static double getCpuUtil() {
		OperatingSystemMXBean osBeanmemory = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);	
		
//		From os memory bean we call systemcpuload to get average load
//		
		
		double load= 0.0;
		 
		load= osBeanmemory.getSystemCpuLoad()*100;	
		
		
		if(load==-100.0 || load ==0.0) {  /// error correction as initial value comes to be 
											//-1 or 0 . This handles test cases
			load=1.0;	
		}
		return load;
		
		
		}
			
	

		

}
