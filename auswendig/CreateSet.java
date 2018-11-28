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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

public class CreateSet
{
    int cardNumber = 0;
    String setName = "tempSetName";
    String description = "tempDescription";
    String term;
    String example;
    String tags;
    String definition;
    
    Calendar calendar = Calendar.getInstance(); //varaible for the current time/date
    
    public CreateSet()
    {
        System.out.println("Running CreateSet.");
    }
    
    public void AddCard(String setName, String description, String term, String example, String tags, String definition)
    {
        cardNumber = cardNumber+1;
        this.setName = setName;
        this.description = description;
        this.term = term;
        this.example = example;
        this.tags = tags;
        this.definition = definition;
        
        String destAddress = Paths.get(".").toAbsolutePath().normalize().toString()+"\\src\\Sets\\"+setName+".txt"; //get current directory
        File filename = new File(destAddress);
        //File filename = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setName+".txt");
    
        try
        {
            if(filename.exists()==false) //write first card
            {
                FileWriter fw = new FileWriter(filename, true);
                BufferedWriter bw = new BufferedWriter(fw); //temporary store for data

                bw.write("");

                bw.close(); //close buffered writer
            }
            else //change encoding to UTF-8
            {
                String destAddress1 = Paths.get(".").toAbsolutePath().normalize().toString()+"\\src\\Sets\\"+setName+".txt"; //get current directory
                Path path = Paths.get(destAddress1);
                //Path path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setName+".txt");
                List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                String addedLine = cardNumber+","+term+","+example+","+tags+","+definition;
                lines.add(addedLine);
                Files.write(path, lines, StandardCharsets.UTF_8);
            }
        }
            
        catch(Exception exc) //catch errors
        {
            System.out.println("ERROR ADDING CAR");
            System.out.println(exc);
        }
        
        /*
        System.out.println("Attempting to create card.");
        try
        {
                FileWriter fw = new FileWriter(filename, true);
                BufferedWriter bw = new BufferedWriter(fw); //temporary store for data

                bw.write(cardNumber+","+term+","+example+","+tags+","+definition);
                bw.write("\r\n");

                bw.close(); //close buffered writer
                System.out.println("Successfully created card.");
        } 
        catch(Exception exc)
        {
                System.out.println("Error creating card.");
                System.out.println(exc);
        }*/
    }
    
    public void makeSet()
    {
        String destAddress = Paths.get(".").toAbsolutePath().normalize().toString()+"\\src\\Sets\\"+setName+".txt"; //get current directory
        File filename = new File(destAddress);
        //File filename = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setName+".txt");
        
        //AMEND RECEIPT DATA TO FILE
        System.out.println("Attempting to create set.");
        try
        {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw); //temporary store for data

            bw.write("" + calendar.getTime()); //write the current data/time
            bw.write("\r\n"+description); //new line

            bw.close(); //close buffered writer
            System.out.println("Successfully created set.");
        } 
        catch(Exception exc)
        {
                System.out.println("Error creating set.");
                System.out.println(exc);
        } 
    }
    
    public void createStarredSet() //add 1 line to a starred set if not created, prevents errors
    {
        String destAddress = Paths.get(".").toAbsolutePath().normalize().toString()+"\\src\\Sets\\"+setName+".txt"; //get current directory
        String destAddress1 = Paths.get(".").toAbsolutePath().normalize().toString()+"\\src\\StarredSets\\"+setName+"Starred.txt"; //get current directory
        
        File filename = new File(destAddress);
        File filenameStarred = new File(destAddress1);
        //File filename = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setName+".txt");
        //File filenameStarred = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\StarredSets\\"+setName+"Starred.txt");
        //AMEND RECEIPT DATA TO FILE
        System.out.println("Attempting to create empty starred set.");
        try
        {
            if(filenameStarred.exists()==true) //do nothing if starred set exists
            {
                
            }
            else if(filenameStarred.exists()==false) //created starred set to prevent errors
            {
                FileWriter fw = new FileWriter(filenameStarred, true);
                BufferedWriter bw = new BufferedWriter(fw); //temporary store for data

                bw.write("Empty");

                bw.close(); //close buffered writer
                System.out.println("Successfully created empty starred set.");
            }
        } 
        catch(Exception exc)
        {
                System.out.println("Error creating empty starred set.");
                System.out.println(exc);
        } 
    }
    
    public void createLeitnerSet()
    {
        String destAddress = Paths.get(".").toAbsolutePath().normalize().toString()+"\\src\\Leitner\\"+setName+"Leitner.txt"; //get current directory
        Path path = Paths.get(destAddress);
        //Path path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Leitner\\"+setName+"Leitner.txt");
        File filename = path.toFile();
        String pathLeitner = path.toString();
        
        int maxCards = 0;
        try //get size of deck (number of cards)
        {
            String destAddress1 = Paths.get(".").toAbsolutePath().normalize().toString()+"\\src\\Sets\\"+setName+".txt"; //get current directory
            Path pathSelectedItem = Paths.get(destAddress1);
            //Path pathSelectedItem = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setName+".txt");
            List<String> linesLeitner = Files.readAllLines(pathSelectedItem, StandardCharsets.UTF_8);
            maxCards = linesLeitner.size()-2;
        }
        catch(Exception exc)
        {
            System.out.println("Error getting size of deck.");
            System.out.println(exc);
        }
        
        try
        {
            FileWriter fw1 = new FileWriter(pathLeitner, true);
            BufferedWriter bw1 = new BufferedWriter(fw1); //temporary store for data
            System.out.println("does not exist");
            System.out.println("----- New Leitner Set");
            for(int i=0; i<maxCards+1; i++)
            {
               bw1.write(i+","+"*0"); 
               bw1.write("\r\n");
               System.out.println(i+","+"*0");
            }
            bw1.close(); //close buffered writer
        }
        catch(Exception exc)
        {
                System.out.println("Error creating card.");
                System.out.println(exc);
               
        }
    }
}
