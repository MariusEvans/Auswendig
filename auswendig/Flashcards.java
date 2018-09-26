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
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class Flashcards 
{
    List<String> linesSelectedItem;
    List<String> linesStarred;
    List<String> linesDaysPast;
    
    int daysPast1;
    int cardNumber = 0;
    int lastLineNum = 1;
    
    public File[] listOfFiles;
    public String[] listOfFileNames = {"","","","","","","","","","",""}; //10 sets supported
    String readLine[] = new String[6]; //array for read lines
    String[] values;
    String[] cardvalues;
    Calendar calendar = Calendar.getInstance(); //varaible for the current time/date
    String selectedItem;
    public String descriptionGLOBAL;
    
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
    
    public void readCardLEITNER(String selectedItem, int sliderValue, String daysTillReview) 
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
           
            while((line = rdr.readLine()) != null && flag==false) //while there are lines to read
            {
              if(flag==false)
              {
                  String line1 = rdr1.readLine();
                  for(int z=lastLineNum; z<sliderValue+1; z++)
                  {
                      int linenumber = rdr.getLineNumber();
                      System.out.println("CARD NUM: "+z);
                      if(linenumber==sliderValue+1 && flag==false)
                      {
                          String cardvalues4[] = line.split(",");
                          String cardvalueString = Arrays.toString(cardvalues4);
                          char cardvalueChars[] = cardvalueString.toCharArray();
                          char cardValueChar = cardvalueChars[5];
                          String cardValueString = cardValueChar+"";
                          if(cardValueString.contains("*"))
                          {
                            cardValueChar = cardvalueChars[6];
                            cardValueString = cardValueChar+"";
                            if(cardValueString.contains("*"))
                            {
                                cardValueChar = cardvalueChars[6];
                            }
                          }

                          int daysTillReviewCard = Character.getNumericValue(cardValueChar);
                          System.out.println("");
                          System.out.println(linenumber+" daysTillReviewCard is "+daysTillReviewCard);
                          if(daysTillReviewCard==0)
                          {
                              System.out.println("FOUND 0. CARD NUM: "+z);
                              String readLineSelectedItem = linesSelectedItem.get(z-1);
                              cardvalues = readLineSelectedItem.split(",");
                              String cardvalueString1 = Arrays.toString(cardvalues);
                              System.out.println("Arrays.toString "+cardvalueString1);
                              lastLineNum=sliderValue;
                              //SaveCardLEITNER(selectedItem, sliderValue, daysTillReview);
                          }
                          else
                          {
                              System.out.println("line number: "+linenumber+"daysTillReview is not 0");
                              sliderValue+=1;
                              lastLineNum=sliderValue;
                              readCardLEITNER(selectedItem, sliderValue, daysTillReview);
                          }
                          flag=true;

                      }
                   }
                }
                
              }
              rdr.close();
              rdr1.close();    
            /*if(flag==false && sliderValue>0)
            {
                JOptionPane.showMessageDialog(null, "All cards have been reviewed for today.");
            }*/
        }
        catch(Exception exc)
        {
            System.out.println("ERROR READING SETS FILE");
            System.out.println(exc);
            exc.printStackTrace();
        }
    }
    
    public void readLines(String selectedItem) //read all lines of files only once, this optimises reading files
    {
        String selectedItemNOTXT = selectedItem.replace(".txt", "");
        try
        {
            Path pathSelectedItem = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem);
            Path pathStarred = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItemNOTXT+"Starred.txt");
            Path pathDaysPast = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\auswendig\\daysPast.txt");
            linesSelectedItem = Files.readAllLines(pathSelectedItem, StandardCharsets.UTF_8);
            linesStarred = Files.readAllLines(pathSelectedItem, StandardCharsets.UTF_8);
            linesDaysPast = Files.readAllLines(pathDaysPast, StandardCharsets.UTF_8);
        }
        catch(Exception exc)
        {
            System.out.println("Error creating file.");
            System.out.println(exc);
        }
    }
    
    public void readCardLeiter1(String selectedItem, int cardNum)
    {
        boolean timeToReview = false;
        boolean flag = false;
        String selectedItemNOTXT=selectedItem.replace(".txt", "");
        List<String> linesLeitner = null;
        int maxCards = 0;
        try //get size of deck (number of cards)
        {
            Path pathLeitner = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Leitner\\"+selectedItemNOTXT+"Leitner.txt");
            linesLeitner = Files.readAllLines(pathLeitner, StandardCharsets.UTF_8);
            maxCards = linesLeitner.size();
        }
        catch(Exception exc)
        {
            System.out.println("Error getting size of deck.");
            System.out.println(exc);
        }
        while(timeToReview==false || cardNum<=maxCards)
        {
            String readLine1 = linesLeitner.get(cardNum);
            System.out.println("Leitner read line: "+readLine1);
            String[] splitValues = readLine1.split(",");
            String cardvalueString = Arrays.toString(splitValues);
            char cardvalueChars[] = cardvalueString.toCharArray();
            char cardValueChar = cardvalueChars[5];
            String cardValueString = cardValueChar+"";
            if(cardValueString.contains("*"))
            {
                cardValueChar = cardvalueChars[6];
                cardValueString = cardValueChar+"";
                if(cardValueString.contains("*"))
                {
                    cardValueChar = cardvalueChars[6];
                }
            }
            int daysTillReviewCard = Character.getNumericValue(cardValueChar);
            
            System.out.println("");
            if(daysTillReviewCard==0 && flag==false)
            {
                cardvalues = readLine1.split(",");
                System.out.println("contains 0: "+cardvalues.toString());
                timeToReview=true;
                flag=true;
            }
            else
            {
                timeToReview=false;
            }
            System.out.println("daysTillReviewCard: "+daysTillReviewCard+". Read line: "+readLine);
            cardNum+=1;
        }
    }
    
    public void minusDaysPast(String selectedItem, int daysPast1)
    {
        String daysTillReview = "";
        int daysLeft = 0;
        int daysTillReviewFINAL;
        String selectedItemNOTXT = selectedItem.replace(".txt","");
        int maxCards = 0;
        List<String> linesLeitner = null;
        
        if(daysPast1>0)
        {
            try //get size of deck (number of cards)
            {
                Path pathLeitner = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Leitner\\"+selectedItemNOTXT+"Leitner.txt");
                linesLeitner = Files.readAllLines(pathLeitner, StandardCharsets.UTF_8);
                maxCards = linesLeitner.size();
            }
            catch(Exception exc)
            {
                System.out.println("Error getting size of deck.");
                System.out.println(exc);
            }

            for(int i=0; i<maxCards; i++)
            {
                String readLine = linesLeitner.get(i);
                System.out.println("Leitner read line: "+readLine);
                String[] splitValues = readLine.split(",");
                String cardvalueString = Arrays.toString(splitValues);
                char cardvalueChars[] = cardvalueString.toCharArray();
                char cardValueChar = cardvalueChars[5];
                String cardValueString = cardValueChar+"";
                if(cardValueString.contains("*"))
                {
                    cardValueChar = cardvalueChars[6];
                    cardValueString = cardValueChar+"";
                    if(cardValueString.contains("*"))
                    {
                        cardValueChar = cardvalueChars[6];
                    }
                }
                int daysTillReviewCard = Character.getNumericValue(cardValueChar);
                System.out.println("daysTillReviewCard: "+daysTillReviewCard+". Read line: "+readLine);
                if(daysPast1==daysTillReviewCard || daysPast1>daysTillReviewCard) //set days till review as 0 if more days past then days till review
                {
                    daysTillReviewFINAL=0;
                }
                else
                {
                    daysTillReviewFINAL = daysTillReviewCard-daysPast1;
                }
                //REMOVE OLD CARD
                try
                {
                    Path path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Leitner\\"+selectedItemNOTXT+"Leitner.txt");
                    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

                    System.out.println("VALUES AT CARD TO DELETE: "+lines.get(i));
                    lines.remove(i);
                    int position = i;
                    String extraLine = i+",*"+daysTillReviewFINAL;
                    System.out.println("ADDED NEW LINE: "+extraLine);
                    lines.add(i, extraLine);
                    Files.write(path, lines, StandardCharsets.UTF_8);
                }

                catch(Exception exc) //catch errors
                {
                    System.out.println("ERROR READING SETS FILE");
                    System.out.println(exc);
                }
            }
        }
    }
    
    public int daysPast()
    {
        LocalDate now = LocalDate.now();
        String readLine = "";
        int daysPastInt = 0;
        //check days past
        try
        {
            readLine = linesDaysPast.get(0);
            if(readLine.equals(now) || readLine.matches(now+"") || readLine.contains(now+"")) //if the current date is equal to the read date daysPastInt=0
            {
                daysPastInt=0;
            }
            else
            {
                String[] cardvalues00 = readLine.split("-");
                System.out.println(""+cardvalues00);
                String daysString = "";
                for(int i=0; i<3; i++)
                {
                   daysString = cardvalues00[i]; 
                }

                System.out.println("days String: "+daysString);
                int daysInt = Integer.parseInt(daysString);
                LocalDate daysPastDate = now.minusDays(daysInt);
                String daysPastString = daysPastDate+"";
                String[] daysPastArray = daysPastString.split("-");

                String daysPast = "";
                for(int z=0; z<3; z++)
                {
                    daysPast = daysPastArray[z];   
                    daysPastInt = Integer.parseInt(daysPast);
                }
                System.out.println("days Past: "+daysPastInt);
            }
        }
        catch(Exception exc)
        {
            System.out.println("Error reading date.");
            System.out.println(exc);
            exc.printStackTrace();
        }
        
        //store new date
        try
        {
            Path pathDaysPast = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\auswendig\\daysPast.txt");
            linesDaysPast.remove(0);
            linesDaysPast.add(0, now+"");
            Files.write(pathDaysPast, linesDaysPast, StandardCharsets.UTF_8);
        }
        catch(Exception exc)
        {
            System.out.println("Error writing date.");
            System.out.println(exc);
            exc.printStackTrace();
        }
        return daysPastInt;
    }
    
    public Flashcards(String selectedItem)
    {
        System.out.println("Flashcards running.");
        System.out.println("SELECTED ITEM PASSED: "+selectedItem);
        readLines(selectedItem);
        daysPast1 = daysPast(); //gets the days past since last opened flashcards, writes new date in daysPast.txt file
        System.out.println("Days past since last opened flashcards: "+daysPast1);
        minusDaysPast(selectedItem, daysPast1);
    }
}
