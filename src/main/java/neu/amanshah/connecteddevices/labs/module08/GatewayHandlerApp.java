//Referring to package
package neu.amanshah.connecteddevices.labs.module08;

//Importing libraries
import neu.amanshah.connecteddevices.labs.module08.GatewayDataManager;


// main class that drives the flow of the entire application
public class GatewayHandlerApp{


	//Main Method which starts the thread in GatewayDataManager class
	public static void main(String[] args) {

		GatewayDataManager gateway_manager = new GatewayDataManager();
		gateway_manager.run();
	}

}
