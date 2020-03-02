package neu.amanshah.connecteddevices.labs.module05;
import  neu.amanshah.connecteddevices.labs.*;

import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TempSensorEmulator {
	Random rand = new Random();
	
	public void demo() {
		
		
		SensorData obj = new SensorData();
		for(int i=0;i<10;i++) {
			
			double max=30.0;
			double min= 20.0;
			double randomvalue = Math.random()*1;
			System.out.println(randomvalue);
			obj.demo((int) randomvalue);
		}
		
		
		//System.out.println(current+"kjhhj");
	
//			double count=(double) obj.getCount();
//			double average = obj.getAvg();
//			double total = obj.getTotal();
//			double maxtemp= obj.getMax();
//			double mintemp = obj.getMin();
//			Date datetime= obj.getTime2();
//			double current= obj.getCurrent_vale();
//			
//			
//			
//			try {
				//Logger logger=Logger.getLogger(""); // we dont pass any string as of yet
				//String format="%1$tF %1$tT %4$-4s %5$s %n";  // expression for the format to be used
				
				//System.setProperty("java.util.logging.SimpleFormatter.format", format );
		
//String message="Temperature \n\t time:"+datetime+"\n\t current:"+current+"\n\t Average:"+average+"\n\tMin:"+mintemp+"\n\t max: "+maxtemp;
			    
			
////				 print the log using getters and print at INFO level
//				logger.log(Level.INFO,"CPU UTILIZATION="+obj.getDataCpu());
//				logger.log(Level.INFO,"MEMORY  UTILIZATION="+obj.getDataMem());
			//logger.log(Level.INFO,message);
			
//				
//				Thread.sleep(100); 			// make the thread sleep so that cpu utilization can get enough time to claculate
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
			
			
			
		}
		
		
		
	}
	
	

