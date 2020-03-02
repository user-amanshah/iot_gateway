package neu.amanshah.connecteddevices.labs.module06;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;


import neu.amanshah.connecteddevices.labs.DataUtil;
import neu.amanshah.connecteddevices.labs.SensorData;

import java.util.Arrays;
import java.util.logging.*;


// mqtt client class implements interface and defines method working
public class MqttClientConnector implements MqttCallback {

	public String broker_add;
	public int port_no;
	public String id_client;
//	public String protocol;
	public String url;
	String topic="sensor_test_aman";
	public int QOS=2;
	public MqttClient mqtt_client;
	
	
	//constructor initialization
	public MqttClientConnector() {
		super();
		this.broker_add = "mqtt.eclipse.org";
		this.port_no = 1883;
		this.id_client = MqttClient.generateClientId();
		this.url = "tcp://broker.hivemq.com:1883";
		this.topic = "sensor_test_aman";
		this.QOS = 2;
//		this.mqtt_client = mqtt_client;
		Logger  loging_obj = Logger.getLogger("");
		loging_obj.info("client id used is :"+ this.id_client);
	}

	
	//method implemetation of interface
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		Logger logging_obj = Logger.getLogger("");
		// TODO Auto-generated method stub
		System.out.println("enter message method");
		logging_obj.info("enter arrive method");
		String json_message =message.toString();
		System.out.println("this is json string message recived");
		logging_obj.info("json recived");
		System.out.println(json_message);
		SensorData sensor_obj = new SensorData();
		DataUtil data_obj = new DataUtil();
		sensor_obj= data_obj.JsontoSensorData(json_message);
		logging_obj.info(json_message);
		
		
		String afterconversion = data_obj.sensorDataToJson(sensor_obj);
		logging_obj.info("The final json from sensor data is : /n"+"/n"+afterconversion);	
	}
	
	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		Logger logging_obj = Logger.getLogger("");
		logging_obj.warning("Connection is lost ");
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
		
		// This sample demonstrates asynchronous deliver, registering
		// a callback to be notified on each call to publish.
		//
		// The deliveryComplete method will also be called if
		// the callback is set on the client
		//
		// note that token.getTopics() returns an array so we convert to a string
		// before printing it on the console
		try {
			Logger logging_obj = Logger.getLogger("");
			logging_obj.info("Delivery complete callback: Publish Completed " + Arrays.toString(token.getTopics()));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	// method needed for unitttesting
	public boolean subscribing_to_mqtt() {
		Logger logging_obj = Logger.getLogger("");
		try {
			mqtt_client.subscribe("sensor_test_aman",2);
			
			logging_obj.info("subscribing to the the topic :"+ topic);
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logging_obj.warning("cannot subscribe to topic");
			return false;
		}
	}
	
	public  boolean conection_mqtt() {
		Logger logging_obj = Logger.getLogger("");
		if (mqtt_client==null) {
			try {
				mqtt_client= new MqttClient(this.url, this.id_client);
				
				MqttConnectOptions options_obj = new MqttConnectOptions();
				
				options_obj.setCleanSession(true);
				mqtt_client.connect(options_obj);
				return true;
				
			} catch (Exception e) {
				// TODO: handle exception
				logging_obj.warning("connection cannot be formed"+e);
				return false;
			}
		}
		return true;
		
	}
	
		//method needed for unittesting unsunscribe
	public boolean unsubscribe_topic() {
		try {
			
			mqtt_client.unsubscribe(this.topic);
			System.out.println("successfully disconnected");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}	
		
	}
	
 
	public boolean disconnect_session() {
		Logger logging_obj = Logger.getLogger("");
		try {
			mqtt_client.disconnect();
			System.out.println("successfully disconnect the session");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logging_obj.warning("cannot disconnect the session");
			return false;
		}
	}
	
	
	
	
}
