/* Copyright (C) Septemeber 2018, Marius Evans, All Rights Reserved
 * This file is part of project Auswendig
 * Reproduction, sale and commerical distribution of this material is strictly forbidden unless prior written permission is obtained from Marius Evans
 * Written by Marius Evans (mariusevans@outlook.com)
 */

package auswendig;

import java.io.File;
import javax.swing.JOptionPane;


public class DeleteSet 
{
    public File[] listOfFiles;
    public String[] listOfFileNames = {"","","","","","","","","","",""}; //10 folders supported
    
    public DeleteSet()
    {
        System.out.println("Running DeleteSet.");
    }
    
    public void delete(String selectedItem)
    {
        String selectedItemNOTXT = selectedItem.replace(".txt","");
        try
        {
            File set = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem);
            File starredSet = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\StarredSets\\"+selectedItemNOTXT+"Starred.txt");
            File leitnerSet = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Leitner\\"+selectedItemNOTXT+"Leitner.txt");
            System.out.println(set);
            System.out.println(starredSet);
            System.out.println(leitnerSet);
            //DELETE SET, STARRED SET AND LEITNER SET
            if(set.delete())
            {
                System.out.println(set.getName() + " is deleted!");
            }
            else
            {
                System.out.println("Delete operation is failed.");
            }
            
            if(starredSet.delete())
            {
                System.out.println(starredSet.getName() + " is deleted!");
            }
            else
            {
                System.out.println("Delete operation is failed.");
            }
            
            if(leitnerSet.delete() && leitnerSet.exists()==true) //if a leitner set exists, delete it
            {
                System.out.println(leitnerSet.getName() + " is deleted!");
            }
            else
            {
                System.out.println("Delete operation is failed.");
            }
            
            if(set.exists()==false && starredSet.exists()==false && leitnerSet.exists()==false) //message to say deleted
            {
                JOptionPane.showMessageDialog(null,"Deleted "+selectedItem);
            }
    	}
        catch(Exception e)
        {
            System.out.println("Error deleting set.");
            JOptionPane.showMessageDialog(null,"Could not delete set.");
            e.printStackTrace();
    	}
    }
    
    public void readFileNames()
    {
        File folder = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\");
		
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
}
