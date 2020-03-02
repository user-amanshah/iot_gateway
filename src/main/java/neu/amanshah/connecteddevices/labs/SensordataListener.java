package neu.amanshah.connecteddevices.labs;

public class SensordataListener {

	
	public void onMessage(SensorData sensor_values) {
		
		DataUtil data_obj = new DataUtil();
		String sensorstring=data_obj.sensorDataToJson(sensor_values);
		System.out.println("sensor values are"+ sensorstring);
	}
}
