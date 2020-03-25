//Referring to package
package neu.amanshah.connecteddevices.labs.module08;

import java.util.Random;

//Importing libraries
import neu.amanshah.connecteddevices.labs.module08.Ubidots_connector;;



/*
 *This class is a thread class for the MqttClientConnector class methods
 */
public class GatewayDataManager extends Thread {



	//Overriding run method of thread  by calling a static managing method that calls all api and mqttconnection
	@Override
	public void run() {
		
		managing();
	
	}
	
	
	
	public static void managing() {
	
	try {
		while (true) {


				Ubidots_connector ubi = new Ubidots_connector("industrial.ubidots.com", "BBFF-DDJefJiPLcbNPpQHcfbGDM8Z4vJWiU", "industrial.pem");
				Ubidots_connector mqtt = new Ubidots_connector();
				UbidotsApiConnector api = new UbidotsApiConnector();
				mqtt.ubidots_mqtt_connect();
				ubi.ubidots_mqtt_connect();
				
				api.publish(api.randomgenerator(15, 25));
				sleep(10000);
				ubi.ubidots_mqtt_subscribe();
				sleep(10000);
				
				
				mqtt.publishMessage("mqtt_topic", 2, Ubidots_connector.python_payload);
							

			
		}
	}
	
	//catch exception 
	catch (Exception e) {
		e.printStackTrace();
	}
}

}
