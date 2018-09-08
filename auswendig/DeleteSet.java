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
        try
        {
            File file = new File("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem);

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
