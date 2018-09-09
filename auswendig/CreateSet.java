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
import java.util.Calendar;
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
        
        File filename = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setName+".txt");
        //AMEND DATA TO FILE
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
        } 
    }
    
    public void makeSet()
    {
        File filename = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setName+".txt");
        
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
}
