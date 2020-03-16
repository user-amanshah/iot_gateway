package neu.amanshah.connecteddevices.labs.module07;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.core.network.EndpointManager;


public class CoapServerManager {
	// initializing flags
	public static boolean flag_variable_start=false;
	public static boolean flag_variable_add=false;
	
	
	// static initialization of variables
	private static final Logger _Logger = Logger.getLogger(CoapServerManager.class.getName());
	// private variables declaration
	private CoapServer _coapServer;
	private int port;
	// constructors
	public CoapServerManager() {
		super();
		this.port=5683;
	}
	// public methods to add resource to coap object
	public void addResource(CoapResource resource)
	{
		if (resource != null) {
			_coapServer.add(resource);
		}
	}
	
	//method to start the coap server
	
	public void start()
	{
		if (_coapServer == null) {
			_Logger.info("Creating CoAP server instance and 'temp' handler...");
			_coapServer = new CoapServer();
			
			// NOTE: you must implement TempResourceHandler yourself
			TempResourceHandler tempHandler = new TempResourceHandler("temperature");
			addendpoints();
			_coapServer.add(tempHandler);
			flag_variable_start=true;
		}
		_Logger.info("Starting CoAP server...");
		_coapServer.start();
	
	}
	
	// method to stop the coap server
	public void stop()
	{
		_Logger.info("Stopping CoAP server...");
		_coapServer.stop();
	}
	
	
	//method to add end points to the socket
	public void addendpoints() {
		for(InetAddress inet_add : EndpointManager.getEndpointManager().getNetworkInterfaces()) {
			if(inet_add.isLoopbackAddress()) {
				InetSocketAddress addr = new InetSocketAddress(inet_add, port);
				_coapServer.addEndpoint(new CoapEndpoint(addr));
			}
			flag_variable_add=true;
		}
	}
}
