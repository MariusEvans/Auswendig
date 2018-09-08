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
import java.util.Calendar;


public class EditSet 
{
    int cardNumber = 0;
    public File[] listOfFiles;
    public String[] listOfFileNames = {"","","","","","","","","","",""}; //10 sets supported
    String readLine[] = new String[6]; //array for read lines
    String[] values;
    String[] cardvalues;
    Calendar calendar = Calendar.getInstance(); //varaible for the current time/date
    public String descriptionGLOBAL;
    
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
    
    public void readCard(String selectedItem, int sliderValue)
    {
        String filename = "C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem;
			
        try
        {
            //BufferedReader br = new BufferedReader(new FileReader(filename)); //for reading data
            String line = null; //the read line is null
            LineNumberReader rdr = new LineNumberReader(new FileReader(filename));
            
            while((line = rdr.readLine()) != null) //while there are lines to read
            {
              for(int z=1; z<sliderValue+1; z++)
              {
                  int linenumber = rdr.getLineNumber();
                  System.out.println("LINE NUMBER: "+linenumber);
                  //cardvalues = line.split(","); //split data in file by commas
                  //System.out.println("NEW LINE "+cardvalues); //output the splitted data
                  if(linenumber==sliderValue)
                  {
                      cardvalues = line.split(",");
                      System.out.println("**** LINE NUMBER SPLIT: "+cardvalues); //output the splitted data;
                  }
               }
              /*for(int i=0; i<Array.getLength(cardvalues); i++) //loop for the array of read lines
              {
                System.out.println("Value:"+cardvalues[i]); //output the array value for the loop
              }*/
            }
            //br.close(); //called once, it stops all reading to the file
            rdr.close();
        }
            
        catch(Exception exc) //catch errors
        {
            System.out.println("ERROR READING SETS FILE");
            System.out.println(exc);
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
            Path newPath = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+setName+".txt");
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
    
    public EditSet()
    {
        System.out.println("EditSet running.");
    }
}
