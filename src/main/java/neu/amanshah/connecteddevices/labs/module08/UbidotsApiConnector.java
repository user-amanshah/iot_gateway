package neu.amanshah.connecteddevices.labs.module08;

import java.util.Random;
import java.util.logging.Logger;

import com.ubidots.*;

public class UbidotsApiConnector {
	
	ApiClient api = new ApiClient("BBFF-c368cfaf91acf15d183943d50366ca8ca40");
	DataSource datasource = api.getDataSource("5e77f8b01d8472273d5b9fa9");
	Variable tempsensor = api.getVariable("5e77fb131d84722ba62f7427");
	private static  Logger logging = Logger.getLogger("");
	public UbidotsApiConnector() {
		super();
	}

	
	public double randomgenerator(double min, double max) {
		Random r = new Random();
		double random = min + r.nextFloat() * (max - min);
		logging.info("Temperature generated is  : " + Double.toString(random));
		return random;
	}
	
	
	
	public void publish( double sampledata) {
		double temperat = randomgenerator(15.0, 30.0);
		tempsensor.saveValue(sampledata);
		logging.info("generated temperature is published: "+ sampledata);
	}


}