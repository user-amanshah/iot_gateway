package neu.amanshah.connecteddevices.labs.module02;

import java.util.logging.Level;
import java.util.logging.Logger;

import neu.amanshah.connecteddevices.labs.module01.SystemCpuUtiltask;
import neu.amanshah.connecteddevices.labs.module01.SystemMemUtilTask;

//import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;



public class TempEmulatorAdaptor {
	double avg;
	double current;
	
	
	public double getAvg() {
		return avg;
	}


	public void setAvg(double avg) {
		this.avg = avg;
	}


	public double getCurrent() {
		return current;
	}


	public void setCurrent(double current) {
		this.current = current;
	}


	public  void adapter() {   // method that calculates cpu util
		
			
			TempSensorEmulator emulator = new TempSensorEmulator();	

		
//		Loop for displaying the log info 

// call emulator task to get temp parameters
		for(int count =0 ;count <10 ;count++) {
			
			emulator.demo();
			/*
			 * 
			 */
			setAvg(emulator.getAvgtemp());
			setCurrent(emulator.getCurrent());
			
//			double avg=emulator.getAvgtemp();
//			double current = emulator.getCurrent();
	// check if sudden spike or fall in temp values
			// if true send email
			if( Math.abs(getAvg()-getCurrent())>2.0) {
				
				String messagestring="Temperatur\n\t time: "+ emulator.getDate() +"\n\t current:"+emulator.getCurrent()+"\n\tAverage:"+emulator.getAvgtemp()+"\n \t Samples: 10"+"\n\t Min:"+emulator.getMintemp()+"\n\t max: "+emulator.getMaxtemp();
			    				
///String messagestring="The temperature has suddenly changed to high percent value from average "+getAvg()+"to a sudden change of "+getCurrent()+"This is an auto generated email";
			                
				SmtpClientConnector.mailing(messagestring);
			}
			
			
			
			// display output using logger at INFO mode
			// surround with try catch for error handling
			try {
				
				
				
				Logger logger=Logger.getLogger(""); // we dont pass any string as of yet
//				String format="%1$tF %1$tT %4$-4s %5$s %n";  // expression for the format to be used
//				
//				System.setProperty("java.util.logging.SimpleFormatter.format", format );
	//		
			String message="Temperatur\n\t time: "+ emulator.getDate() +"\n\t current:"+emulator.getCurrent()+"\n\tAverage:"+emulator.getAvgtemp()+"\n \t Samples: 10"+"\n\t Min:"+emulator.getMintemp()+"\n\t max: "+emulator.getMaxtemp();
			    
			

			logger.log(Level.INFO,message);
				
				Thread.sleep(100); 			// make the thread sleep so that cpu utilization can get enough time to claculate
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
		}
		
		
		
	}
	
}
