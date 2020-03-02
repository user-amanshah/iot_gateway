package neu.amanshah.connecteddevices.labs;

import com.google.gson.Gson;

public class DataUtil {

	
	public String sensorDataToJson(SensorData sensorData)
	{
	String jsonData = null;
	if (sensorData != null) {
	Gson gson = new Gson();
	jsonData = gson.toJson(sensorData);
	}
	return jsonData;
	}
	
	
	
	
	public ActuatorData jsonToActuatorData(String jsonData)
	{
	ActuatorData actuatorData = null;
	if (jsonData != null && jsonData.trim().length() > 0) {
	Gson gson = new Gson();
	actuatorData = gson.fromJson(jsonData, ActuatorData.class);
	}
	return actuatorData;
	}
	
	
	
	
	public SensorData JsontoSensorData(String json_sensor ) {
		SensorData sensor_obj = null;
		if (json_sensor !=null && json_sensor.trim().length()>0) {
			Gson gson = new Gson();
			sensor_obj = gson.fromJson(json_sensor, SensorData.class);
					
		}
return sensor_obj;

}
	public String actuatorTojson(ActuatorData actuatordataobj) {
		String json_actuator="";
		if(actuatordataobj!=null) {
			Gson gson = new Gson();
			json_actuator= gson.toJson(actuatordataobj);
			
		}
	return json_actuator;
	}
	
	
	
	
}



	