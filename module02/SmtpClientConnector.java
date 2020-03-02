package neu.amanshah.connecteddevices.labs.module02;
import neu.amanshah.connecteddevices.labs.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
//import all mail libraries

public class SmtpClientConnector {
		
	// we usee javaxmail to send out emai
	// we extract mail parameters from config util

	    public static void mailing(String messagestring) {
	    	//public SmtpClientConnector = new SmtpClientConnector();
	    	
	    	 ConfigUtil obj = new ConfigUtil();
	    	
	    	//get key value pair from configUtil class
	    	 
	    	final String host=obj.getvalue("smtp.cloud", "host");
//	    	System.out.println(host);
	    	final String username=obj.getvalue("smtp.cloud", "fromAddr");
//	    	System.out.println(username);
	    	final String password=obj.getvalue("smtp.cloud", "password");
//	    	System.out.println(password);
	    	final String port=obj.getvalue("smtp.cloud", "port");
//	    	System.out.println(port);
	    	final String auth=obj.getvalue("smtp.cloud", "enableAuth");
//	    	System.out.println(auth);
//	    	
	    	
	    	// we need to wrap the tls info in property type object
	    	
	    	Properties prop = new Properties();
			prop.put("mail.smtp.host", host);		// smtp google as host 
	        prop.put("mail.smtp.port", port);
	        prop.put("mail.smtp.auth", auth);
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS mode set to true
	        
	  //tls unthentication for sending out emails
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });
	        
	        
	        // SENDINg email and wrap in try catch block for error handling
	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(username));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse("aman.shah96.as@gmail.com")
	            );
	            message.setSubject("Sudden change in temperature");
	            
	            message.setText(messagestring);

	            Transport.send(message);

	            System.out.println("Done");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    

	}
}


