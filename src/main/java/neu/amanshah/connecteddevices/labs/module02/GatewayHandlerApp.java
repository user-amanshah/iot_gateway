package neu.amanshah.connecteddevices.labs.module02;

import neu.amanshah.connecteddevices.labs.ConfigUtil;

public class GatewayHandlerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//calling the adaptor class that calls other function to log in the temperature data
		TempEmulatorAdaptor obj = new TempEmulatorAdaptor();
		obj.adapter();
		
		
//		ConfigUtil oj = new ConfigUtil();
//		System.out.println(oj.loadconfig());
	}

}
