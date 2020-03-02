package neu.amanshah.connecteddevices.labs.module02;
import  neu.amanshah.connecteddevices.labs.*;

import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																		
public class TempSensorEmulator {
	// set paramters that are obtained from sensordata class
	
	
	public double maxtemp;
	public double mintemp;
	public double current;
	public double avgtemp;
	public String date;
	
	
	// instantiate class objects that are required
	Random rand = new Random();
	SensorData obj = new SensorData();
	

	// generate getters and ssetters that can be used when called by other class
	// we will call this class in adaptor class
	
	
	public double getMaxtemp() {
		return maxtemp;
	}
	public void setMaxtemp(double maxtemp) {
		this.maxtemp = maxtemp;
	}
	public double getMintemp() {
		return mintemp;
	}
	public void setMintemp(double mintemp) {
		this.mintemp = mintemp;
	}
	public double getCurrent() {
		return current;
	}
	public void setCurrent(double current) {
		this.current = current;
	}
	public double getAvgtemp() {
		return avgtemp;
	}
	public void setAvgtemp(double avgtemp) {
		this.avgtemp = avgtemp;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

	// method that calls sensor data 10 times to get sample data
	// here random function is used to generate random data between 20 and 30 only
	
	public void demo() {
		
		
		
		for(int i=0;i<10;i++) {
			double max=30.0;
			double min= 20.0;
			Random r = new Random();
			double newvalue = min + (max - min) * r.nextDouble();
			//System.out.println(randomvalue);
			obj.demo(newvalue);
		}
		
		
//		System.out.println(obj.getMin()+"min");
//		System.out.println(obj.getMax()+"max");
//		System.out.println(obj.getCurrent()+"current");
//		System.out.println(obj.getDatetime()+"date");
//		System.out.println(obj.getAvg()+"avg");
//		System.out.println(obj.getTotal()+"sum");
		
		
		
		setAvgtemp(obj.getAvg());
		setCurrent(obj.getCurrent());
		setDate(obj.getDatetime());
		setMintemp(obj.getMin());
		setMaxtemp(obj.getMax());
			
	
			
			
			
		}
		
		
		
	}
	
	

