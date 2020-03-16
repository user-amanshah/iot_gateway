//Referring to package
package neu.amanshah.connecteddevices.labs.module07;

import org.eclipse.californium.core.CoapServer;


//Main Method class which starts  in server 
public class GatewayHandlerApp{
	
	

// main method
	public static void main(String[] args)
	 {
	 GatewayHandlerApp _App = new GatewayHandlerApp();
	 try {
		 _App.start();
	 } catch (Exception e) {
		 e.printStackTrace();
	 	}
	 }
	
	 // private variable for server
	 private CoapServerManager _coapServer;
	 
	 // constructors
	 public GatewayHandlerApp() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	// public methods to start coap server
	 public void start()
	 {
		 _coapServer = new CoapServerManager();
		 _coapServer.start();
	 }
		

}
