package servicepublisher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CustomerServicePublishImpl implements CustomerServicePublish{

	@Override
	public String publishService() {
		return "Execute the publish service of ServicePublisher";
	}
	
	// The set of words contained in the dictionary.
    String[][] CusName = { {"jaith", "osada", "sliit",  "homagama"},{"nimal", "perera", "sliit",  "maharagama"},{"kamal", "gunasiri", "sliit",  "nugegoda"} };

    
    
    public int checkName(String name){
    	name = name.toLowerCase();

        for (int i = 0; i < CusName.length; i++)
        {
            if (CusName[i][0].equals(name))
            {
                return i;
            }
        }
        return -99;
    }
    
	public void entercus() {
		

		try
        {
            System.out.println("Enter a blank line to exit.");
            String name = "";
            String profile = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            // Loop endlessly.
            while (true)
            {
                // Ask the user to enter a word.
                System.out.print("Enter Customer Name: ");
                name = in.readLine();


                // If the user entered a blank line, then
                // exit the loop.
                if (name.length() == 0)
                {
                    break;
                }
                // If there is no dictionary, then say so.
                
                // Otherwise print whether the word is correct or not.
                else if (checkName(name)!=-99)
                {
                	int i;
                	i = checkName(name);
                    System.out.println("Correct.");
                    System.out.println("");
                    System.out.print("If you want to see customer profile (Y/N): ");
                    profile = in.readLine();

                    if (profile.equals("y"))
                    {
                    	System.out.print("Name : ");
                        System.out.println(CusName[i][0]);
                        System.out.print("surname : ");
                        System.out.println(CusName[i][1]);;
                        System.out.print("campus : ");
                        System.out.println(CusName[i][2]);
                        System.out.print("Home Town : ");
                        System.out.println(CusName[i][3]);

                    }
  
                }
                else
                {
                    System.out.println("Incorrect.");
                }
            }
        } catch (Exception ex) { }
	}

	

	
    
}
