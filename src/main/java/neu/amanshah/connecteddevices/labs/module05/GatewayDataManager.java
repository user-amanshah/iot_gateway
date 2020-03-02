package neu.amanshah.connecteddevices.labs.module05;

import neu.amanshah.connecteddevices.labs.ActuatorData;

public class GatewayDataManager extends Thread {

	
	//declaring variables
	boolean enable= false;
	
	
	
	//overriding default run method from thread class
	@Override
	public void run() {
		try {
			while (true) {
				
				if (enable) {
					// call all the neccessary functions to run 
					runningapp();
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}	

	public static void runningapp() {

		PersistenceUtil persistence_obj = new PersistenceUtil();
		ActuatorData actuator_data = new ActuatorData();
		persistence_obj.writesensorDatatoDB();
		persistence_obj.writeActuatoronDb(actuator_data);
		
	}
	
	
}
