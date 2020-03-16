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
	
	public static boolean flag_variable_start=false;
	public static boolean flag_variable_add=false;
	
	
	// static
	private static final Logger _Logger = Logger.getLogger(CoapServerManager.class.getName());
	// private var's
	private CoapServer _coapServer;
	private int port;
	// constructors
	public CoapServerManager() {
		super();
		this.port=5683;
	}
	// public methods
	public void addResource(CoapResource resource)
	{
		if (resource != null) {
			_coapServer.add(resource);
		}
	}
	
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
//		try {
//			TimeUnit.SECONDS.sleep(2);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		_coapServer.stop();
	}
	public void stop()
	{
		_Logger.info("Stopping CoAP server...");
		_coapServer.stop();
	}
	
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
