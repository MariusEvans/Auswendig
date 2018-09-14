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
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class Flashcards 
{
    List<String> linesSelectedItem;
    List<String> linesStarred;
    
    int cardNumber = 0;
    public File[] listOfFiles;
    public String[] listOfFileNames = {"","","","","","","","","","",""}; //10 sets supported
    String readLine[] = new String[6]; //array for read lines
    String[] values;
    String[] cardvalues;
    Calendar calendar = Calendar.getInstance(); //varaible for the current time/date
    String selectedItem;
    public String descriptionGLOBAL;
    public int[] lineNumbers0 = new int[15]; //*!!!! CHANGE SIZE TO MAX CARDS
    
    public void readSet(String selectedItem)
    {
        String filename = "C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem;
        
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
            System.out.println("ERROR READING SETS FILE");
            System.out.println(exc);
        }
    }
    
    public void readCard(int sliderValue) //read regular set, not starred
    {
        String readLine = "";
        System.out.println("Card Number: "+sliderValue);
        try
        {
            if(sliderValue>0)
            {
                readLine = linesSelectedItem.get(sliderValue-1);
            }
            else
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
    
    public void readCardSTARRED(int sliderValue)
    {
        String readLine = "";
        System.out.println("Card Number: "+sliderValue);
        try
        {
            if(sliderValue>0)
            {
                readLine = linesStarred.get(sliderValue-1);
            }
            else
            {
                readLine = linesStarred.get(sliderValue);
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
    
    
    public void AddCard(int sliderValue, String selectedItem, String term, String example, String tags, String definition)
    {
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
    
    public void StarCard(int sliderValue, String selectedItem, String term, String example, String tags, String definition)
    {
        String selectedItemNOTXT = selectedItem.replace(".txt","");
        Path path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\StarredSets\\"+selectedItemNOTXT+"Starred"+".txt");
        String path1 = path.toString();
        try
        {
            String extraLine = sliderValue+","+term+","+example+","+tags+","+definition;
            System.out.println(""+extraLine);
            
            FileWriter fw = new FileWriter(path1, true);
            BufferedWriter bw = new BufferedWriter(fw); //temporary store for data

            bw.write(""+extraLine);
            bw.write("\r\n");
            
            bw.close(); //close buffered writer
        }
        catch(Exception exc)
        {
            System.out.println("Error creating card.");
            System.out.println(exc);
            File filename = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\StarredSets\\"+selectedItemNOTXT+"Starred"+".txt");
            //createStarredSet(filename, sliderValue, selectedItem, term, example, tags, definition);
        }
    }
    
    public boolean checkStarred(String selectedItem, int sliderValue)
    {
        String selectedItemNOTXT = selectedItem.replace(".txt","");
        String filename = "C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\StarredSets\\"+selectedItemNOTXT+"Starred"+".txt";
	boolean starred = false;		
        boolean DONOTREADAGAIN = false;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename)); //for reading data
            String line = null; //the read line is null
            String[] values2 = null;
            int cardNum=0;
            while((line = br.readLine()) != null && DONOTREADAGAIN==false) //while there are lines to read
            {
                String cardvalues5[] = line.split(",");
                String cardvalueString = Arrays.toString(cardvalues5);
                char cardvalueChars[] = cardvalueString.toCharArray();
                char cardValueChar = cardvalueChars[1]; //card num within range of 0-9
                char possibleComma = cardvalueChars[2];
                char possibleComma2 = cardvalueChars[3];
                String possibleCommaString = possibleComma+"";//card num within range of 10-99
                String possibleComma2String = possibleComma2+"";//card num within range of 100-200
                if(possibleCommaString.equals(",")) //0-9 cardNum
                {
                   cardNum = Character.getNumericValue(cardValueChar);
                }
                else
                {
                    if(possibleComma2String.equals(",")) //10-99 card number
                    {
                        StringBuilder sb = new StringBuilder();
                        sb.append(cardValueChar);
                        sb.append(possibleComma);
                        String cardNum10to99 = sb.toString();
                        cardNum = Integer.parseInt(cardNum10to99);
                    }
                    else //100-200 card number
                    {
                        StringBuilder sb = new StringBuilder();
                        sb.append(cardValueChar);
                        sb.append(possibleComma);
                        sb.append(possibleComma2);
                        String cardNum10to99 = sb.toString();
                        cardNum = Integer.parseInt(cardNum10to99);
                    }
                }
                
                System.out.println("CARD NUM: "+cardNum);
                if(cardNum==sliderValue)
                {
                    System.out.println("cardNum "+cardNum+" is the same as slider Value "+sliderValue);
                    starred=true;
                    DONOTREADAGAIN=true;
                }
                else
                {
                    starred=false;
                }
            }
            br.close();
        }
            
        catch(Exception exc) //catch errors
        {
            System.out.println("ERROR READING SETS FILE");
            System.out.println(exc);
            exc.printStackTrace();
        }
        return starred;
    }
    
    /*public void createStarredSet(File filename, int sliderValue, String selectedItem, String term, String example, String tags, String definition)
    {
        //create starred set by simply writing "" to a new file
        //AMEND DATA TO FILE
        System.out.println("Attempting to create card.");
        try
        {
                FileWriter fw = new FileWriter(filename, true);
                BufferedWriter bw = new BufferedWriter(fw); //temporary store for data
                
                bw.write("");

                bw.close(); //close buffered writer
        } 
        catch(Exception exc)
        {
                System.out.println("Error creating set.");
                System.out.println(exc);
                exc.printStackTrace();
        } 
        StarCard(sliderValue, selectedItem, term, example, tags, definition);
    }*/
    
    public void UnstarCard(String selectedItem, int sliderValue)
    {
        boolean DONOTREADAGAIN = false;
        String selectedItemNOTXT = selectedItem.replace(".txt","");
        try
        {
            Path path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\StarredSets\\"+selectedItemNOTXT+"Starred"+".txt");
            String pathString = path.toString();
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            
            LineNumberReader rdr = new LineNumberReader(new FileReader(pathString)); //for reading data
            String line = null; //the read line is null
            String[] values2 = null;
            int cardNum=0;
            //CARD NUMBERS ARE STORED SERIALLY, FIND THE LINE A CARD NUMBER IS ON, THEN REMOVE THAT LINE
            while((line = rdr.readLine()) != null && DONOTREADAGAIN==false) //while there are lines to read
            {
                int linenumber = rdr.getLineNumber();
                String cardvalues5[] = line.split(",");
                String cardvalueString = Arrays.toString(cardvalues5);
                char cardvalueChars[] = cardvalueString.toCharArray();
                char cardValueChar = cardvalueChars[1]; //card num within range of 0-9
                char possibleComma = cardvalueChars[2];
                char possibleComma2 = cardvalueChars[3];
                String possibleCommaString = possibleComma+"";//card num within range of 10-99
                String possibleComma2String = possibleComma2+"";//card num within range of 100-200
                if(possibleCommaString.equals(",")) //0-9 cardNum
                {
                   cardNum = Character.getNumericValue(cardValueChar);
                }
                else
                {
                    if(possibleComma2String.equals(",")) //10-99 card number
                    {
                        StringBuilder sb = new StringBuilder();
                        sb.append(cardValueChar);
                        sb.append(possibleComma);
                        String cardNum10to99 = sb.toString();
                        cardNum = Integer.parseInt(cardNum10to99);
                    }
                    else //100-200 card number
                    {
                        StringBuilder sb = new StringBuilder();
                        sb.append(cardValueChar);
                        sb.append(possibleComma);
                        sb.append(possibleComma2);
                        String cardNum10to99 = sb.toString();
                        cardNum = Integer.parseInt(cardNum10to99);
                    }
                }
                
                if(cardNum==sliderValue)
                {
                    lines.remove(linenumber-1);
                    System.out.println("cardNum "+cardNum+" is the on line "+linenumber);
                    DONOTREADAGAIN=true;
                }
            }
            rdr.close();
            Files.write(path, lines, StandardCharsets.UTF_8);
        }
            
        catch(Exception exc) //catch errors
        {
            System.out.println("ERROR UNSTARRING CARD");
            System.out.println(exc);
        }
    }
    
    public void readDescription(String selectedItem)
    {
        String filename = "C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem;
			
        try
        {
            //BufferedReader br = new BufferedReader(new FileReader(filename)); //for reading data
            String line = null; //the read line is null
            LineNumberReader rdr = new LineNumberReader(new FileReader(filename));
            Path filenameLineSizes = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem);
            List<String> lines = Files.readAllLines(filenameLineSizes, StandardCharsets.UTF_8);
            int linesize = lines.size();
            
            while((line = rdr.readLine()) != null) //while there are lines to read
            {
              for(int z=1; z<linesize-2; z++)
              {
                  int linenumber = rdr.getLineNumber();
                  System.out.println("LINE NUMBER: "+linenumber);
  
                  if(linenumber==linesize)
                  {
                      descriptionGLOBAL = line;
                  }
               }
            }
            rdr.close();
        }
        catch(Exception exc)
        {
            System.out.println(exc);
        }
    }
    
    public void createSetOrAddCardLeitner(String selectedItem, int maxCards, int sliderValue, String daysTillReview)
    {
        String selectedItemNOTXT = selectedItem.replace(".txt","");
        Path path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Leitner\\"+selectedItemNOTXT+"Leitner"+".txt");
        File filename = path.toFile();
        String path1 = path.toString();
        try
        {
            if(filename.exists()==true) //if file exists, amend the line of the current card
            {
                SaveCardLEITNER(selectedItem, sliderValue, daysTillReview);
            }
            else if(filename.exists()==false) //create blank set with daysTilLReview = 0
            {
                FileWriter fw1 = new FileWriter(path1, true);
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
        }
        catch(Exception exc)
        {
                System.out.println("Error creating card.");
                System.out.println(exc);
               
        }
    }
    
    public void SaveCardLEITNER(String selectedItem, int sliderValue, String daysTillReview)
    {
        String selectedItemNOTXT = selectedItem.replace(".txt","");
        
        try
        {
           Path path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Leitner\\"+selectedItemNOTXT+"Leitner"+".txt");
           String path1 = path.toString();
           String line = null; //the read line is null
           LineNumberReader rdr = new LineNumberReader(new FileReader(path1));
           boolean flag = false;
            while((line = rdr.readLine()) != null) //while there are lines to read
            {
              for(int z=1; z<sliderValue+1; z++)
              {
                  int linenumber = rdr.getLineNumber();
                  //System.out.println("LINE NUMBER: "+linenumber);
                  
                  if(linenumber-1==sliderValue && flag==false)
                  {
                      String cardvalues3[] = line.split(",");
                      //System.out.println("**** LINE NUMBER SPLIT: "+cardvalues3); //output the splitted data;
                      String cardvalueString = Arrays.toString(cardvalues3);
                      System.out.println(cardvalueString);
                      char cardvalueChars[] = cardvalueString.toCharArray();
                      char cardValueChar = cardvalueChars[5];
                      int daysTillReviewCard = Character.getNumericValue(cardValueChar);
                      System.out.println("daysTillReviewCard: "+daysTillReviewCard);
                      
                      String daysTillReviewReplace = daysTillReview.replace("*","");
                      int daysTillReviewInt1 = Integer.parseInt(daysTillReviewReplace);
                      System.out.println("daysTillReview: "+daysTillReviewInt1);
                      
                      System.out.println(linenumber);
                      System.out.println("daysTillReviewCard ("+daysTillReviewCard+") + daysTillReviewInt ("+daysTillReviewInt1+") =");
                      int daysTillReviewInt2 = daysTillReviewInt1+daysTillReviewCard;
                      System.out.println(daysTillReviewInt2);
                      //System.out.println("daysTillReviewNew: "+daysTillReviewInt);
                     
                      if(daysTillReviewInt1==0) //enables a card to be reviewed again on the same day...
                      {
                          daysTillReviewInt2=0;
                      }
                      if(daysTillReviewInt2>9) //max days till review is 9... limited by getting 1 char....
                      {
                          daysTillReviewInt2=9;
                      }
                      
                      daysTillReview = "*"+daysTillReviewInt2;
                      System.out.println(cardvalueString+" ---> "+daysTillReviewCard);
                      flag=true;
                  }
               }
            }
            rdr.close();
        }
        catch(Exception exc)
        {
            System.out.println("ERROR READING SETS FILE");
            System.out.println(exc);
        }
        
        //REMOVE OLD CARD
        try
        {
            Path path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Leitner\\"+selectedItemNOTXT+"Leitner"+".txt");
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            
            System.out.println("VALUES AT CARD TO DELETE: "+lines.get(sliderValue));
            lines.remove(sliderValue);
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
            Path path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Leitner\\"+selectedItemNOTXT+"Leitner"+".txt");
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            int position = sliderValue;
            String extraLine = sliderValue+","+daysTillReview;
            System.out.println(""+extraLine);

            lines.add(position, extraLine);
            Files.write(path, lines, StandardCharsets.UTF_8);
        }
        catch(Exception exc)
        {
            System.out.println("Error saving card.");
            System.out.println(exc);
        }
    }
    
    public void readCardLEITNER(String selectedItem, int sliderValue) 
    {
        String selectedItemNOTXT = selectedItem.replace(".txt","");
        //GET LEITNER CARDS WITH A DAYSTILLREVIEW OF 0, ONLY DISPLAY THESE CARDS
        try
        {
           Path path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Leitner\\"+selectedItemNOTXT+"Leitner"+".txt");
           String path1 = path.toString();
           String filenameOrig = "C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem;
           String line = null; //the read line is null
           LineNumberReader rdr = new LineNumberReader(new FileReader(path1));
           LineNumberReader rdr1 = new LineNumberReader(new FileReader(filenameOrig));
           boolean flag = false;
           
            while((line = rdr.readLine()) != null) //while there are lines to read
            {
              String line1 = rdr1.readLine();
              for(int z=1; z<sliderValue+1; z++)
              {
                  int linenumber = rdr.getLineNumber();
                  
                  if(linenumber==sliderValue+1 && flag==false)
                  {
                      String cardvalues4[] = line.split(",");
                      String cardvalueString = Arrays.toString(cardvalues4);
                      char cardvalueChars[] = cardvalueString.toCharArray();
                      char cardValueChar = cardvalueChars[5];
                      int daysTillReviewCard = Character.getNumericValue(cardValueChar);
                      if(daysTillReviewCard==0)
                      {
                          lineNumbers0[z] = linenumber;
                          int linenumberDYSTORW = linenumber;
                          System.out.println("");
                          System.out.println(linenumber+" daysTillReviewCard is "+daysTillReviewCard);
                          cardvalues = line1.split(",");
                          String cardvalueString1 = Arrays.toString(cardvalues);
                          System.out.println("Arrays.toString "+cardvalueString1);
                          //readCardLEITNERdaysTilLReview0(linenumberDYSTORW, sliderValue, selectedItem);
                      }
                      flag=true;
                  }
               }
            }
            rdr.close();
            rdr1.close();
        }
        catch(Exception exc)
        {
            System.out.println("ERROR READING SETS FILE");
            System.out.println(exc);
        }
    }
    
    public void readLines(String selectedItem) //read all lines of files only once, this optimises reading files
    {
        String selectedItemNOTXT = selectedItem.replace(".txt", "");
        try
        {
            Path pathSelectedItem = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem);
            Path pathStarred = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItemNOTXT+"Starred.txt");
            linesSelectedItem = Files.readAllLines(pathSelectedItem, StandardCharsets.UTF_8);
            linesStarred = Files.readAllLines(pathSelectedItem, StandardCharsets.UTF_8);
        }
        catch(Exception exc)
        {
            System.out.println("Error creating file.");
            System.out.println(exc);
        }
    }
    
    public Flashcards(String selectedItem)
    {
        System.out.println("Flashcards running.");
        System.out.println("SELECTED ITEM PASSED: "+selectedItem);
        readLines(selectedItem);
    }
}
