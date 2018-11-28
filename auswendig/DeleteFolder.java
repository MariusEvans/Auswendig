/* Copyright (C) Septemeber 2018, Marius Evans, All Rights Reserved
 * This file is part of project Auswendig
 * Reproduction, sale and commerical distribution of this material is strictly forbidden unless prior written permission is obtained from Marius Evans
 * Written by Marius Evans (mariusevans@outlook.com)
 */

package auswendig;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class DeleteFolder 
{
    public File[] listOfFiles;
    List<String> listOfFileNames = new ArrayList<>();
    
    public DeleteFolder()
    {
        System.out.println("Running DeleteFolder.");
    }
    
    public void delete(String selectedItem)
    {
        try
        {
            String destAddress = Paths.get(".").toAbsolutePath().normalize().toString()+"\\src\\Folders\\"+selectedItem; //get current directory
            File file = new File(destAddress);
            //File file = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Folders\\"+selectedItem);

            if(file.delete())
            {
                System.out.println(file.getName() + " is deleted!");
                JOptionPane.showMessageDialog(null,"Deleted "+selectedItem);
            }
            else
            {
                System.out.println("Delete operation is failed.");
            }
    	}
        catch(Exception e)
        {
            System.out.println("Error deleting folder.");
            JOptionPane.showMessageDialog(null,"Could not delete folder.");
            e.printStackTrace();
    	}
    }
    
    public void readFileNames()
    {
        String destAddress = Paths.get(".").toAbsolutePath().normalize().toString()+"\\src\\Folders\\"; //get current directory
        File folder = new File(destAddress);
	//File folder = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Folders\\");	
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
}
