//Referring to package
package neu.amanshah.connecteddevices.labs.module07;

import org.eclipse.californium.core.CoapServer;

public class GatewayHandlerApp{
	/*
	 *This public Class is used to run the thread defined in gateway manager 
	 * 
	 */

	//Main Method which starts the thread in GatewayDataManager class
//	public static void main(String[] args) {
//
//		GatewayDataManager gateway_manager = new GatewayDataManager();
//		gateway_manager.enableEmulator=true;
//		gateway_manager.start();
//	}
	public static void main(String[] args)
	 {
	 GatewayHandlerApp _App = new GatewayHandlerApp();
	 try {
		 _App.start();
	 } catch (Exception e) {
		 e.printStackTrace();
	 	}
	 }
	 // private var's
	 private CoapServerManager _coapServer;
	 
	 // constructors
	 public GatewayHandlerApp() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	// public methods
	 public void start()
	 {
		 _coapServer = new CoapServerManager();
		 _coapServer.start();
	 }
		

}
