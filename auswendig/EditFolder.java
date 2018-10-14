/* Copyright (C) Septemeber 2018, Marius Evans, All Rights Reserved
 * This file is part of project Auswendig
 * Reproduction, sale and commerical distribution of this material is strictly forbidden unless prior written permission is obtained from Marius Evans
 * Written by Marius Evans (mariusevans@outlook.com)
 */

package auswendig;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EditFolder 
{
    public File[] listOfFiles;
    List<String> listOfFileNames = new ArrayList<>();
    String[] values;
    
    Calendar calendar = Calendar.getInstance(); //varaible for the current time/date
    
    public EditFolder()
    {
        System.out.println("Running EditFolder.");
    }
    
    public void readFileNames()
    {
        File folder = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Folders\\");
		
	if(folder.isDirectory())
        {
            if(folder.list().length>0)
            {
		System.out.println("Directory is not empty!");
                File[] listOfFiles = folder.listFiles();

                for (int i = 0; i < listOfFiles.length; i++) 
                {
                  if (listOfFiles[i].isFile()) 
                  {
                    System.out.println("File " + listOfFiles[i].getName());
                    listOfFileNames.add(listOfFiles[i].getName());
                  } 
                }
            }
            else
            {
                System.out.println("Directory is empty!");		
            }	
	}
        else
        {	
            System.out.println("This is not a directory");	
	}
    }
    
     public void readFolder(String selectedItem)
    {
        String filename = "C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Folders\\"+selectedItem;
        
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename)); //for reading data
            String line = null; //the read line is null

            while((line = br.readLine()) != null) //while there are lines to read
            {
              values = line.split(","); //split data in file by commas
              System.out.println("NEW LINE "+values); //output the splitted data

              for(int i=0; i<Array.getLength(values); i++) //loop for the array of read lines
              {
                System.out.println("Value:"+values[i]); //output the array value for the loop
              }
              br.close(); //called once, it stops all reading to the file
           }
         }
        catch(Exception exc) //catch errors
        {
            System.out.println("ERROR READING FOLDERS FILE");
            System.out.println(exc);
        }
    }
     
    public void saveFolder(String selectedItem, String folderName, String description, String sets)
    {
        //DELETE ORIGINAL
        try
        {
            File filenameDelete = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Folders\\"+selectedItem);

            if(filenameDelete.delete())
            {
                System.out.println(filenameDelete.getName() + " is deleted!");
            }
            else
            {
                System.out.println("Delete operation is failed.");
            }
    	}
        catch(Exception e)
        {
            System.out.println("Error deleting folder.");
            e.printStackTrace();
    	}
        
        //^^^^^^^^^^^^^^^^^^^^^^
        
        File filename = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Folders\\"+folderName+".txt");
        
        //AMEND DATA TO FILE
        System.out.println("Attempting to create folder.");
        try
        {
                FileWriter fw = new FileWriter(filename, true);
                BufferedWriter bw = new BufferedWriter(fw); //temporary store for data

                bw.write(folderName+","+description+","+sets);
                bw.write("\r\n");
                bw.write("" + calendar.getTime());

                bw.close(); //close buffered writer
                System.out.println("Successfully created folder.");
        } 
        catch(Exception exc)
        {
                System.out.println("Error creating folder.");
                System.out.println(exc);
        } 
    }
}
