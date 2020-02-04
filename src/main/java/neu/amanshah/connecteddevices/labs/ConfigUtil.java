package neu.amanshah.connecteddevices.labs;



import org.ini4j.Wini;


import java.io.File;
import java.io.IOException;
import neu.amanshah.connecteddevices.labs.*;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;


public class ConfigUtil {
		
	// we use ini4j jar file to get values from prop file extension
	
	// we convert it in ini file as it is simpler in java that way
	
	// declare absolute path of the props file
	String filename="A:\\git-repos\\workspace\\iot-gateway\\config\\ConnectedDevicesConfig.props ";
	
	
	// method to find if file exists in directory
	// returns true if file is not corrupt or wrong directory
	
		public boolean loadconfig() {
			
		// TODO Auto-generated method stub
		
		File fileobj1 = new File(this.filename);
		boolean fileexist = fileobj1.isFile();		//checks if object is a file type
		return fileexist;
	}

		
		// method to extract key and value parameters from section in props file
		// returns the value of the smtp parameters
		
	public String getvalue(String key,String value) {
		Wini ini=null;			// ini object instantiated
		try {
			ini = new Wini(new File(this.filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String confdata= ini.get(key, value);
		return confdata;
	}
	
	 
}