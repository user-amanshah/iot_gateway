package neu.amanshah.connecteddevices.labs.module01;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.MemoryUsage;

public class SystemMemUtilTask {

	public  double memoryutil() {
		
		/*
		 * We will use memorymxbean which holds all the memory bean attributs like heap
		 * storage and nonheap
		 */
		
		MemoryMXBean obj = ManagementFactory.getMemoryMXBean();
		
		MemoryUsage obj2 = obj.getHeapMemoryUsage();
		// System.out.println(obj2.getClass());
		double memusage = 0.0;
		double total = 0.0;

		

		/*
		 * we will use heap storage for memory utilized by jvm instead of calculating
		 * entire physical memory
		 */
		memusage = obj.getHeapMemoryUsage().getUsed(); 	//get currently used memory in bytes
		total = obj.getHeapMemoryUsage().getMax(); // get total mem in bytes

		double percent = (memusage / total) * 100.0; //calculate in %
		//System.out.println(percent);

		return percent;
	}

}