package neu.amanshah.connecteddevices.labs.module07;

import java.util.logging.Logger;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.server.resources.CoapExchange;


//class to declare all serving methods like get,post,delete etc
public class TempResourceHandler extends CoapResource
{
	//initialix=ze logger to print
	private static final Logger _Logger = Logger.getLogger(TempResourceHandler.class.getName());
	public TempResourceHandler(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	
	public TempResourceHandler(String name, boolean visible) {
		super(name, visible);
		}
	
	
	//method for get
	@Override
	public void handleGET(CoapExchange exchange) {
		exchange.respond(ResponseCode.VALID, "Get resource ");
		_Logger.info("Get request：" + super.getName());
	}

	
	// method for the post 
	@Override
	public void handlePOST(CoapExchange exchange) {
		exchange.respond(ResponseCode.CREATED, "Post resource ");
		_Logger.info("Post request：" + exchange.getRequestText());
	}

	// method for put
	@Override
	public void handlePUT(CoapExchange exchange) {
		exchange.respond(ResponseCode.CHANGED, "Put resource");
		_Logger.info("Put request：" + exchange.getRequestText());
	}

	// to complete the delete function when get the request from the client
	@Override
	public void handleDELETE(CoapExchange exchange) {
		exchange.respond(ResponseCode.DELETED, "Delete resource");
		_Logger.info("Delete request：" + super.getName());
	}

}
