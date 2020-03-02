package neu.amanshah.connecteddevices.labs.module06;

import neu.amanshah.connecteddevices.labs.module06.*;

public class GatewayDataManager extends Thread {

	
	//declaring variables
	boolean enable= false;
	
	
	
	//overriding default run method from thread class
	@Override
	public void run() {
		try {
			while(true) {
				
			
			MqttClientConnector mqtt_obj = new MqttClientConnector();
			mqtt_obj.conection_mqtt();
			mqtt_obj.subscribing_to_mqtt();
			
			sleep(65000);
			
			 
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
}


