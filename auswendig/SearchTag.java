/* Copyright (C) Septemeber 2018, Marius Evans, All Rights Reserved
 * This file is part of project Auswendig
 * Reproduction, sale and commerical distribution of this material is strictly forbidden unless prior written permission is obtained from Marius Evans
 * Written by Marius Evans (mariusevans@outlook.com)
 */

package auswendig;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchTag 
{   
    public File[] listOfFiles;
    public String[] listOfFileNames = {"","","","","","","","","","",""}; //10 sets supported
    //public String[] listOfResults = {"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    List<String> listOfResults = new ArrayList<>();
    
    public void readFileNames()
    {
        String destAddress = Paths.get(".").toAbsolutePath().normalize().toString()+"\\src\\Sets\\"; //get current directory
        File folder = new File(destAddress);
	//File folder = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\");
        
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
                    listOfFileNames[i] = listOfFiles[i].getName();
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
    
    public void readFiles(String tag)
    {
        int amountOfFiles = listOfFileNames.length;
        
        for(int z=0; z<amountOfFiles; z++)
        {
            try
            {
                String destAddress = Paths.get(".").toAbsolutePath().normalize().toString()+"\\src\\Sets\\"+listOfFileNames[z]; //get current directory
                Path pathSelectedItem = Paths.get(destAddress);
                //Path pathSelectedItem = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+listOfFileNames[z]);
                List<String> linesSelectedItem = Files.readAllLines(pathSelectedItem, StandardCharsets.UTF_8);
                int amountOfLines = linesSelectedItem.size();
                for(int b=0; b<amountOfLines; b++)
                {
                    String line = linesSelectedItem.get(b);
                    String lines[] = line.split(",");
                    String linesExceptTags = lines[0].toString()+","+lines[1].toString()+","+lines[2].toString()+","+lines[4].toString();
                    if(line.contains(tag))
                    {
                        listOfResults.add(listOfFileNames[z].replace(".txt", "")+" | "+linesExceptTags);
                    }
                }
                
            }
            catch(Exception exc)
            {
                System.out.println("Error reading files.");
                System.out.println(exc);
                exc.printStackTrace();
            }
        }
    }
}
