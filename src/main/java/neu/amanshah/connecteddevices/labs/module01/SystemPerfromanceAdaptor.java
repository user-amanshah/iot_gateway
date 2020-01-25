package neu.amanshah.connecteddevices.labs.module01;

import java.util.logging.Level;
import java.util.logging.Logger;

import neu.amanshah.connecteddevices.labs.module01.SystemCpuUtiltask;
import neu.amanshah.connecteddevices.labs.module01.SystemMemUtilTask;

//import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;



public class SystemPerfromanceAdaptor {
	/*
	 * setting global parameters and along with it getters and setters
	 * 
	 */
	private double dataCpu=0;
	private double dataMem=0;
	
	
	public double getDataCpu() { 	// getter
		return dataCpu;
	}


	public void setDataCpu(double dataCpu) { //setter
		this.dataCpu = dataCpu;
	}


	public double getDataMem() { 	// getter
		return dataMem;
	}


	public void setDataMem(double dataMem) { //setter
		this.dataMem = dataMem;
	}


	public  void adapter() {   // method that calculates cpu util
		
		/*
		 * We instantiate all the class objects to be required we need to call static
		 * functions from system memutil and system cpuuti
		 * 
		 * 
		 */
		
		
		SystemPerfromanceAdaptor obj = new SystemPerfromanceAdaptor();

		SystemCpuUtiltask sysCpuUtil=new SystemCpuUtiltask(); 
		SystemMemUtilTask sysMemUtil=new SystemMemUtilTask(); 
		
//		Loop for displaying the log info  
		for(int count =0 ;count <15 ;count++) {
			
			
			/*
			 * the cpu util class neeeds certain time to calculate the utilization hence we
			 * make use of sleep function to allow it to compute
			 */
			
			
			try {
				Logger logger=Logger.getLogger(""); // we dont pass any string as of yet
				String format="%1$tF %1$tT %4$-4s %5$s %n";  // expression for the format to be used
				
				System.setProperty("java.util.logging.SimpleFormatter.format", format );
		
				// set the data values using setters
								
			    obj.setDataCpu(sysCpuUtil.getCpuUtil());
			    obj.setDataMem(sysMemUtil.memoryutil());
			    
			
//				 print the log using getters and print at INFO level
				logger.log(Level.INFO,"CPU UTILIZATION="+obj.getDataCpu());
				logger.log(Level.INFO,"MEMORY  UTILIZATION="+obj.getDataMem());
				
				Thread.sleep(2000); 			// make the thread sleep so that cpu utilization can get enough time to claculate
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
		}
		
		
		
	}
	
}
