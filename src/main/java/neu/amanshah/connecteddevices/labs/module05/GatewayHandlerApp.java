package neu.amanshah.connecteddevices.labs.module05;

import neu.amanshah.connecteddevices.labs.module05.*;

public class GatewayHandlerApp {
	// main class calling that drives 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GatewayDataManager GDM_obj = new GatewayDataManager();
		GDM_obj.enable=true;
		GDM_obj.start();
		
	}

}

/**
 * 
 * /
 */