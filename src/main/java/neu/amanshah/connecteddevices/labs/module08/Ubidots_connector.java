//Referring the package
package neu.amanshah.connecteddevices.labs.module08;

//Importing libraries
import neu.amanshah.connecteddevices.labs.DataUtil;
import neu.amanshah.connecteddevices.labs.SensorData;

import java.util.logging.Level;
import java.util.logging.Logger;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;





/*
 *  eclipse paho library for Java is used for writting all mqtt related methods
 *  like subscribing and publishing to the channel
 *  publish to ubidots 
 */

public class Ubidots_connector implements MqttCallback {

	// Declaring Variables and iniatiling topics and connetion var
	private static final Logger logging = Logger.getLogger("");
	private MqttClient mqttClient;
	private String protocol;
	private int port;
	private String client_id;
	private String broker_address;
	private String server_url;
	private String host_name;
	private String auth_token;
	private String pem_path;
	private String pem_file;
	private boolean tls_flag = false;
	private String ubidots_topic = "/v1.6/devices/asign8/tempactuator/lv";
	String topic = "mqtt_topic";
	public static byte[] python_payload;
	int qos = 2;
	int ubi_qos=1;

	//  Constructor
	public Ubidots_connector() {
		super();
		this.protocol = "tcp";
		this.broker_address = "mqtt.eclipse.org";
		this.port = 1883;
		this.client_id = MqttClient.generateClientId();
		this.server_url = protocol + "://" + broker_address + ":" + port;

		// showing the information of clientID and broker address
		logging.info("Using client ID for broker conn: " + client_id);
	}

	
	// constructor overloading
	public Ubidots_connector(String host_name, String auth_token, String pem_path) {
		super();
		this.host_name = host_name;
		this.auth_token = auth_token;
		this.pem_file = pem_path;
		this.protocol = "ssl";
		this.port = 8883;
		this.tls_flag=true;
		this.server_url = protocol + "://" + host_name + ":" + port;
		this.client_id = MqttClient.generateClientId();
		// showing the information of clientID and broker address
		logging.info("Using client ID for broker conn: " + client_id);
	}

	// Method to connect to MQTT broker
	public boolean ubidots_mqtt_connect() {
		if (mqttClient == null) {
			try {
				mqttClient = new MqttClient(server_url, client_id);

				// connect to Mqtt connect options
				MqttConnectOptions conn_opt = new MqttConnectOptions();

				if (tls_flag == true) {
					try {
						SSLContext sslContext = SSLContext.getInstance("SSL");
						TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
						KeyStore keyStore = readKeyStore();
						trustManagerFactory.init(keyStore);
						sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
						conn_opt.setSocketFactory(sslContext.getSocketFactory());

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				conn_opt.setCleanSession(true);
				if(auth_token!=null) {
					conn_opt.setUserName(auth_token);
				}
				mqttClient.setCallback(this);
				mqttClient.connect(conn_opt);
				return true;
			} catch (MqttException e) {
				logging.log(Level.SEVERE, "Failed to connect to broker: " + server_url, e);
			}
		}
		return false;
	}

	
	// function to enable ssl and security certificate
	private KeyStore readKeyStore() throws CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException {
		KeyStore keystoreobj = KeyStore.getInstance(KeyStore.getDefaultType());
		FileInputStream fis = new FileInputStream(pem_file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		keystoreobj.load(null);
		while (bis.available() > 0) {
			Certificate cert = cf.generateCertificate(bis);
			keystoreobj.setCertificateEntry("jy_store" + bis.available(), cert);
		}
		return keystoreobj;
	}
	
	// Callback method to notify about the lost connection
	public void connectionLost(Throwable cause) {
		logging.log(Level.WARNING, "Connection to broker lost");
	}

	// Method to check and disconnect from the MQTT broker
	public boolean ubidot_mqtt_disconnect_method() {
		try {
			mqttClient.disconnect();
			logging.info("Disconnected from broker: " + broker_address);
			return true;
		} catch (MqttException e) {
			logging.log(Level.SEVERE, "Failed to disconnect from broker: " + broker_address, e);
			return false;
		}

	}

	
	// Callback method to notify about the arrival of message
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		logging.info("Message arrived.........");
		logging.info("Json Received:" + message.toString());
		
		python_payload=message.getPayload();


	}
	
	
	
	// Method to Subscribe to Topic
	public boolean ubidots_mqtt_subscribe() {
		try {
			mqttClient.subscribe(ubidots_topic, ubi_qos);
			logging.info("Subscribed to Topic:  " + ubidots_topic);
			
			return true;
		} catch (MqttException e) {
			logging.log(Level.WARNING, "Failed to subscribe topics.", e);
		}
		return false;
	}

	
	//Method to Publish to the Topic
	public boolean publishMessage(String topic, int qos, byte[] payload) {
		boolean success = false;
		try {
			logging.info("Publishing message to topic: " + topic);
			// set the payload of the message
			MqttMessage message = new MqttMessage();
			//payload=22.0;
			message.setPayload(payload);
			// set  the qos level 
			message.setQos(qos);
			// link to the topic
			mqttClient.publish(topic, message);
			logging.info("Published Success!  MqttMessageID:" + message.getId());
			success = true;
		} catch (MqttException e) {
			logging.log(Level.SEVERE, "Failed to publish MQTT message: " + e.getMessage());
		}

		return success;

	}

	
	
	
	// Method to Unsubscribe from Topic
	public boolean mqtt_unsubscribe() {
		try {
			mqttClient.unsubscribe(topic);
			return true;
		} catch (MqttException e) {
			e.printStackTrace();
		}
		return false;

	}




	


	// Callback method to notify about the completion of delivery of message
	public void deliveryComplete(IMqttDeliveryToken token) {
		try {
			logging.info("Delivery complete: ID = " + token.getMessageId());
		} catch (Exception e) {
			logging.log(Level.SEVERE, "Failed to retrieve message from token", e);
		}
	}

}
