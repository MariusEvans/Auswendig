/* Copyright (C) Septemeber 2018, Marius Evans, All Rights Reserved
 * This file is part of project Auswendig
 * Reproduction, sale and commerical distribution of this material is strictly forbidden unless prior written permission is obtained from Marius Evans
 * Written by Marius Evans (mariusevans@outlook.com)
 */

package auswendig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class CreateFolder
{
    String folderName = "tempFolderName";
    String description = "tempDescription";
    String sets;
    
    Calendar calendar = Calendar.getInstance(); //varaible for the current time/date
    
    public CreateFolder()
    {
        System.out.println("Running CreateFolder.");
    }
    
    public void makeFolder(String folderName, String description, String sets)
    {
        this.folderName = folderName;
        this.description = description;
        this.sets = sets;
      
        String destAddress = Paths.get(".").toAbsolutePath().normalize().toString()+"\\src\\Folders\\"+folderName+".txt"; //get current directory
        File filename = new File(destAddress);
        //File filename = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Folders\\"+folderName+".txt");
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
