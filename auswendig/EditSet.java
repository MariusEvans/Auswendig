/* Copyright (C) Septemeber 2018, Marius Evans, All Rights Reserved
 * This file is part of project Auswendig
 * Reproduction, sale and commerical distribution of this material is strictly forbidden unless prior written permission is obtained from Marius Evans
 * Written by Marius Evans (mariusevans@outlook.com)
 */

package auswendig;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;


public class EditSet 
{
    List<String> linesSelectedItem;
    List<String> linesStarred;
    boolean starredSet = false;
    int cardNumber = 0;
    public File[] listOfFiles;
    public File[] listOfFilesStarred;
    List<String> listOfFileNamesStarred = new ArrayList<>();
    List<String> listOfFileNames = new ArrayList<>();
    
    String readLine[] = new String[6]; //array for read lines
    String[] cardvalues;
    Calendar calendar = Calendar.getInstance(); //varaible for the current time/date
    public String descriptionGLOBAL;
    
    public void readFileNames()
    {
        File folder = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\");
	File folderStarred = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\StarredSets\\");	
        
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
        
        if(folderStarred.isDirectory())
        {
            if(folderStarred.list().length>0)
            {
		System.out.println("Directory is not empty!");
                File[] listOfFilesStarred = folderStarred.listFiles();

                for (int i = 0; i < listOfFilesStarred.length; i++) 
                {
                  if (listOfFilesStarred[i].isFile()) 
                  {
                    System.out.println("File " + listOfFilesStarred[i].getName());
                    listOfFileNamesStarred.add(listOfFilesStarred[i].getName());
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
    
    public void readCard(int sliderValue, boolean starredSet1)
    {	
        String readLine = "";
        System.out.println("starredSet = "+starredSet1);
        System.out.println("Card Number: "+sliderValue);
        try
        {
            if(sliderValue>0 && starredSet1==true)
            {
                readLine = linesStarred.get(sliderValue-1);
            }
            else if(sliderValue<0 && starredSet1==true)
            {
                readLine = linesStarred.get(sliderValue);
            }
            
            if(sliderValue>0 && starredSet1==false)
            {
                readLine = linesSelectedItem.get(sliderValue-1);
            }
            else if(sliderValue<0 && starredSet1==false)
            {
                readLine = linesSelectedItem.get(sliderValue);
            }
             
            cardvalues = readLine.split(",");
            System.out.println(""+readLine);
        }
        catch(Exception exc)
        {
            System.out.println("Error reading card.");
            System.out.println(exc);
            exc.printStackTrace();
        }
    }
    
    public void AddCard(int sliderValue, String selectedItem, String term, String example, String tags, String definition, boolean starred2)
    {
        try
        {
            Path path;
            if(starred2==true)
            {
                path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\StarredSets\\"+selectedItem);
            }
            else
            {
                path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem);
            }
            
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            int position = sliderValue-1;
            String extraLine = sliderValue+","+term+","+example+","+tags+","+definition;
            System.out.println(""+extraLine);

            lines.add(position, extraLine);
            Files.write(path, lines, StandardCharsets.UTF_8);
        }
        catch(Exception exc)
        {
                System.out.println("Error creating card.");
                System.out.println(exc);
        }
    }
    
    public void deleteCard(String selectedItem, int sliderValue)
    {
        try
        {
            Path path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem);
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            
            lines.remove(sliderValue-1);
            Files.write(path, lines, StandardCharsets.UTF_8);
        }
            
        catch(Exception exc) //catch errors
        {
            System.out.println("ERROR READING SETS FILE");
            System.out.println(exc);
        }
    }
    
    public void SaveCard(String selectedItem, int sliderValue, String term, String example, String tags, String definition)
    {
        //REMOVE OLD CARD
        try
        {
            Path path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem);
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            
            System.out.println("VALUES AT CARD TO DELETE: "+lines.get(sliderValue-1));
            lines.remove(sliderValue-1);
            Files.write(path, lines, StandardCharsets.UTF_8);
        }
            
        catch(Exception exc) //catch errors
        {
            System.out.println("ERROR READING SETS FILE");
            System.out.println(exc);
        }
        
        //ADD NEW CARD
        try
        {
            Path path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem);
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            int position = sliderValue-1;
            String extraLine = sliderValue+","+term+","+example+","+tags+","+definition;
            System.out.println(""+extraLine);

            lines.add(position, extraLine);
            Files.write(path, lines, StandardCharsets.UTF_8);
        }
        catch(Exception exc)
        {
                System.out.println("Error creating card.");
                System.out.println(exc);
        }
    }
    
    public void saveSet(String selectedItem, String setName, String description)
    {   
        File filename = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setName+".txt");
        
        //SAVE DATA TO FILE
        System.out.println("Attempting to create set.");
        try
        {
            Path originalPath = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem);
            Path newPath;
            if(selectedItem.contains("Starred"))
            {
                 newPath = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\StarredSets\\"+setName+"Starred.txt");
            }
            else
            {
                newPath = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setName+".txt");
            }
            newPath = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setName+".txt");
            List<String> lines = Files.readAllLines(originalPath, StandardCharsets.UTF_8);
            int lastline = lines.size();
            int position = lastline-1;
            System.out.println("Lines size: "+lastline);
            lines.remove(position); //remove old description
            lines.add(position, description); //add new description
            Files.write(originalPath, lines, StandardCharsets.UTF_8);
            
            Files.write(newPath, lines, StandardCharsets.UTF_8);
        } 
        catch(Exception exc)
        {
            System.out.println("Error creating set.");
            System.out.println(exc);
            exc.printStackTrace();
        } 
        
        if(selectedItem.contentEquals(setName))
        {
            System.out.println("selectedItem: "+selectedItem+" and "+"setName: "+setName+" have the same filename.");
        }
        else
        {
            //DELETE ORIGINAL
            try
            {
                File filenameDelete = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Folders\\"+selectedItem);
                //File filenameNew = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setName+".txt");
                //filenameDelete.renameTo(filenameNew);
                //filenameDelete.delete();
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
                System.out.println("Error deleting set.");
                e.printStackTrace();
            }
        }
    }
    
    public void readDescription(String selectedItem)
    {
        Path filename = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem);
	Path filenameStarred = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\StarredSets\\"+selectedItem);	
        try
        {   
            List<String> lines = Files.readAllLines(filename, StandardCharsets.UTF_8);
            int linesize = lines.size();
            descriptionGLOBAL = lines.get(linesize-1); 
        }
        catch(Exception exc)
        {
            System.out.println(exc);
        }
    }
    
    public void readLines(String selectedItem, boolean starredSet)
    {
        try
        {
            if(starredSet==true)
            {
                Path pathStarred = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\StarredSets\\"+selectedItem);
                linesStarred = Files.readAllLines(pathStarred, StandardCharsets.UTF_8);
                starredSet=true;
            }
            else
            {
                Path pathSelectedItem = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem);
                linesSelectedItem = Files.readAllLines(pathSelectedItem, StandardCharsets.UTF_8);
            }
     
        }
        catch(Exception exc)
        {
            System.out.println("Error creating file.");
            System.out.println(exc);
        }
    }
    
    public EditSet()
    {
        System.out.println("EditSet running.");
    }
}
