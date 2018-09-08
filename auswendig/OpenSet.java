package auswendig;

import java.io.File;

public class OpenSet 
{
    public File[] listOfFiles;
    public String[] listOfFileNames = {"","","","","","","","","","",""}; //10 folders supported
    
    public OpenSet()
    {
        System.out.println("Running OpenSet.");
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
