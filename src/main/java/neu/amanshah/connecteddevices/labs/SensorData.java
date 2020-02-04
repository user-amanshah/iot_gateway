package neu.amanshah.connecteddevices.labs;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.databind.deser.ValueInstantiator.Gettable;

public class SensorData {
	
//	The class variable declaration for all sensor type atttributes regarding temperature
//	
	private double min=20;
	private double max=0;
	private double count=0;
	private double avg;
	private String datetime;
	private double current;
	private double total;
	
	//declaring getters and setters to store and fetch values
	
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public double getCurrent() {
		return current;
	}
	public void setCurrent(double current) {
		this.current = current;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	// operations on input temperature value
	// get count sum and max,min values 
	
	public void demo(double newvalue) {
		setCount(getCount()+1);
		setCurrent(newvalue);
		setTotal(getTotal()+newvalue);
		
		if(newvalue< getMin()) {
			setMin(newvalue);
		}
		if(newvalue>getMax()) {
			setMax(newvalue);
		}
		
		if(getCount()>1) {
			setAvg(getTotal() /getCount());
			//System.out.println(getAvg());
		}
		// set date time stamp on the sensor data generated
		OffsetDateTime now = OffsetDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		setDatetime(formatter.format(now));
		
	}
	
}