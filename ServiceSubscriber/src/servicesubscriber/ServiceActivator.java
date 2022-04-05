package servicesubscriber;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import servicepublisher.CustomerServicePublish;

public class ServiceActivator implements BundleActivator {
	
	String word = "";
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	ServiceReference serviceReference;

	@Override
	public void start(BundleContext context) throws Exception {
		
		serviceReference = context.getServiceReference(CustomerServicePublish.class.getName());
		CustomerServicePublish servicePublish = (CustomerServicePublish) context.getService(serviceReference);
		System.out.println(servicePublish.checkName(word));
		
		System.out.println("Start Subscriber Service");
		
		servicePublish.entercus();
//		
//		try
//        {
//            System.out.println("Enter a blank line to exit.");
//            String word = "";
//            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//            // Loop endlessly.
//            while (true)
//            {
//                // Ask the user to enter a word.
//                System.out.print("Enter word: ");
//                word = in.readLine();
//
//
//                // If the user entered a blank line, then
//                // exit the loop.
//                if (word.length() == 0)
//                {
//                    break;
//                }
//                // If there is no dictionary, then say so.
//                
//                // Otherwise print whether the word is correct or not.
//                else if (servicePublish.checkWord(word))
//                {
//                    System.out.println("Correct.");
//                }
//                else
//                {
//                    System.out.println("Incorrect.");
//                }
//            }
//        } catch (Exception ex) { }
        
       
        
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye!!!");
		context.ungetService(serviceReference);
	}

}
