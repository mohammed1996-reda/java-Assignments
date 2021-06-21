package pyramids.stream;

import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PyramidCSVDAO {
    
    // Constructor
    public PyramidCSVDAO()
    {
        
    }
    
    // Create Pyramid Object
    public Pyramid createPyramid(String[] attributes)
    {
        // If height is empty replace it with 0 for parsing
        if (attributes[7].isEmpty())
        {
            attributes[7] = "0";
        }
        
        // Assign Pyramids Variable from Attributes array
        String pharaoh = attributes[0];
        String modern_name= attributes[2];
        String site = attributes[4];
        double height = Double.parseDouble(attributes[7]);
        
        // Construct a new pyramid object
        Pyramid p = new Pyramid(pharaoh,modern_name,site,height);
        
        // Return the created object
        return p;
    }
    
    public List <Pyramid> readPyramidsFromCSV(String fileName)
    {       
        // Intialize an empty list
        List <Pyramid> Pyramids_List = new ArrayList<>();
        
        try
        {
            // Read the CSV File
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            
            // Skip the Header Line
            sc.nextLine();
            
            // Loop Each line as long as new line exist
            while (sc.hasNextLine())
            {
                // Read New Line and split with the delimeter ","
                String data = sc.nextLine();
                String[] attributes = data.split(",");
                              
                // Create a New Pyramid Object
                Pyramid New_Pyramid = createPyramid(attributes);
                
                // Add the new Pyramid to the Pyramids list
                Pyramids_List.add(New_Pyramid);                             
            }
            
            // Close the file after finishing
            sc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found" + e);
        }
        
        return Pyramids_List;
    }    
}