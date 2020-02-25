package neu.amanshah.connecteddevices.labs.module05;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import neu.amanshah.connecteddevices.common.*;
import neu.amanshah.connecteddevices.labs.ActuatorData;
import neu.amanshah.connecteddevices.labs.DataUtil;
import neu.amanshah.connecteddevices.labs.SensorData;
import neu.amanshah.connecteddevices.labs.SensordataListener;

public class PersistenceUtil {

	Jedis jedis_obj = new Jedis("redis-13207.c12.us-east-1-4.ec2.cloud.redislabs.com:13207");
	ActuatordataListener actuatorlisten_obj = new ActuatordataListener();
	SensordataListener sensorlistener_obj = new SensordataListener();
	DataUtil data_obj = new DataUtil();
	
	
	
	//creating method for notification when listening
	
	public void registorSensorDbListener(SensorData sensordatarecieverd) {
		sensorlistener_obj.onMessage(sensordatarecieverd);
		
	}
	
	
	
	public void registorActuatorDbListener() {
		actuatorlisten_obj.onMessage();
	}
	
	//write actuator object values on redis
	public void writeActuatoronDb(ActuatorData actuatorvalues) {
		//declare string to write actuation data
		String actuatordataString="";
		jedis_obj.auth("connected");
		
		actuatordataString = data_obj.actuatorTojson(actuatorvalues);
		jedis_obj.publish("actautorchannel", actuatordataString);
		
		registorActuatorDbListener();
		jedis_obj.close();
		
	}
	
	//subscribe channel of sensor to listen from python
	
	public void writesensorDatatoDB() {
		jedis_obj.auth("connected");
		jedis_obj.subscribe(new JedisPubSub() {
			SensorData sensor_obj = new SensorData();
			@Override
			public void onMessage(String channel,String message) {
			sensor_obj = data_obj.JsontoSensorData(message);
			registorSensorDbListener(sensor_obj);
			if(channel.equals("sensorchannel")) {
				unsubscribe(channel);
			}
		}
		}, "sensorchannel");
		
		jedis_obj.close();
		
	}
	
	
	
	
}
