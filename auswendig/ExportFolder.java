/* Copyright (C) Septemeber 2018, Marius Evans, All Rights Reserved
 * This file is part of project Auswendig
 * Reproduction, sale and commerical distribution of this material is strictly forbidden unless prior written permission is obtained from Marius Evans
 * Written by Marius Evans (mariusevans@outlook.com)
 */

package auswendig;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ExportFolder 
{
    List<String> linesSelectedItem;
    List<String> linesSetOne;
    List<String> linesSetTwo;
    List<String> linesSetThree;
    List<String> linesExportFile;
    
    String selectedItem;
    String filename;
    String[] eachSet;
    public File[] listOfFiles;
    List<String> listOfFileNames = new ArrayList<>();
    
    public ExportFolder()
    {
        System.out.println("Running OpenFolder.");
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
    
    public void getSets(String selectedItem, String filename)
    {
        String selectedItemNOTXT = selectedItem.replace(".txt", "");
        try
        {
            Path pathSelectedItem = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Folders\\"+selectedItem);
            linesSelectedItem = Files.readAllLines(pathSelectedItem, StandardCharsets.UTF_8);
        }
        catch(Exception exc)
        {
            System.out.println("Error creating file.");
            System.out.println(exc);
        }
        
        String readLine = "";
        int fileSize = linesSelectedItem.size();
        try
        {
            readLine = linesSelectedItem.get(0);

            String[] cardvalues = readLine.split(",");
            String sets = cardvalues[2];
            eachSet = sets.split("/");
            System.out.println(""+readLine);
        }
        catch(Exception exc)
        {
            System.out.println("Error reading.");
            System.out.println(exc);
            exc.printStackTrace();
        }
    }
    
    public void export()
    {
        //READ ALL LINES
        boolean sets2 = false;
        boolean sets3 = false;
        String setOneString = eachSet[0]+"";
        String filename1 = "C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\ExportedFolders\\"+filename+".txt";
        
        try
        {
            FileWriter fw = new FileWriter(filename1, true); //CREATE THE EXPORT FILE
            BufferedWriter bw = new BufferedWriter(fw); //temporary store for data
            bw.write("");
            bw.close(); //close buffered writer
            
            Path exportFile = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\ExportedFolders\\"+filename+".txt");
            linesExportFile = Files.readAllLines(exportFile, StandardCharsets.UTF_8);
            
            Path setOne = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setOneString+".txt");
            linesSetOne = Files.readAllLines(setOne, StandardCharsets.UTF_8);
            if(eachSet.length>0 && eachSet.length<2)
            {
                sets2=true;
                String setTwoString = eachSet[1];
                Path setTwo = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setTwoString+".txt");
                linesSetTwo = Files.readAllLines(setTwo, StandardCharsets.UTF_8);
            }
            if(eachSet.length>2)
            {
                sets3=true;
                String setThreeString = eachSet[2];
                Path setThree = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setThreeString+".txt");
                linesSetThree = Files.readAllLines(setThree, StandardCharsets.UTF_8);
            }
        }
        catch(Exception exc)
        {
            System.out.println("Error reading file.");
            System.out.println(exc);
            exc.printStackTrace();
        }
        
        //EXPORT FILE
        try
        {
           Path exportFile = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\ExportedFolders\\"+filename+".txt");
           //linesExportFile.add(0, " Term     Example     Tags        Definition");
           for(int z=0; z<linesSetOne.size()-2;z++)
           {
               String readLine = linesSetOne.get(z);
               //System.out.println("readLine: "+readLine);
               String splitValues[] = readLine.split(",");
               String completeLine = "\r\n"+"\r\n"
                       
                       +splitValues[0]+"."+" Term: "+splitValues[1]+"                                               Definition: "+splitValues[4]+
                       "\r\n"+"   Example: "+splitValues[2]+"\r\n"+"   "+splitValues[3]
                       +"\r\n"+"\r\n"+"\r\n"+"------------------------------------------------------------------------------------------------------";
               
               System.out.println("completeLine: "+completeLine);
               linesExportFile.add(z, completeLine);
           }
           
           if(sets2==true)
           {
               for(int z=0; z<linesSetTwo.size()-2;z++)
               {
                   String readLine = linesSetTwo.get(z);
                   //System.out.println("readLine: "+readLine);
                   String splitValues[] = readLine.split(",");
                   String completeLine = "\r\n"+"\r\n"

                           +splitValues[0]+"."+" Term: "+splitValues[1]+"                                               Definition: "+splitValues[4]+
                           "\r\n"+"   Example: "+splitValues[2]+"\r\n"+"   "+splitValues[3]
                           +"\r\n"+"\r\n"+"\r\n"+"------------------------------------------------------------------------------------------------------";

                   System.out.println("completeLine: "+completeLine);
                   linesExportFile.add(z, completeLine);
               }
           }
           
           if(sets3==true)
           {
               for(int z=0; z<linesSetThree.size()-2;z++)
               {
                   String readLine = linesSetThree.get(z);
                   //System.out.println("readLine: "+readLine);
                   String splitValues[] = readLine.split(",");
                   String completeLine = "\r\n"+"\r\n"

                           +splitValues[0]+"."+" Term: "+splitValues[1]+"                                               Definition: "+splitValues[4]+
                           "\r\n"+"   Example: "+splitValues[2]+"\r\n"+"   "+splitValues[3]
                           +"\r\n"+"\r\n"+"\r\n"+"------------------------------------------------------------------------------------------------------";

                   System.out.println("completeLine: "+completeLine);
                   linesExportFile.add(z, completeLine);
               }
           }
           
           Files.write(exportFile, linesExportFile, StandardCharsets.UTF_8);
           Desktop desktop = Desktop.getDesktop();  
           desktop.open(new File(filename1));
        }
        catch(Exception exc)
        {
            System.out.println("Error creating file.");
            System.out.println(exc);
            exc.printStackTrace();
        }
    }
}
