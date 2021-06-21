package pyramids;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

// 1) Explore the dataset (CSV file) and understand it’s parts
// 2) Dataset preparation/transformation
// Build a Pyramid class to define a prototype for all information you will extract from CSV for each pyramid.
// Build a PyramidCSVDAO class to:
// Read pyramids.csv file.
// Create List of Pyramids objects for each pyramid in the csv file
// Do not forget to validate the values you make all needed conversion.

public class MainClass 
{
    public static void main(String[] args) 
    {
        // Initialize Pyramids List
        List <Pyramid> Pyramids = new ArrayList<>();
        
        try
        {
            // Create a new Pyramid CSV Reader object to read the file
            PyramidCSVDAO pDAO = new PyramidCSVDAO();
            String File_Path = "F:\\ITI AI Pro\\Lectures\\5) Java and UML\\Assignment\\Assignment 1\\Pyramids\\pyramids.csv";
            Pyramids = pDAO.readPyramidsFromCSV(File_Path);

            // Loop the pyramids list to print them
            int i = 1;
            for (Pyramid p : Pyramids)
            {   
                System.out.println("#" + (i++) + " " + p.getPharaoh()+ " - " + p.getModern_name()+ " - " + p.getSite()+ " - " + p.getHeight());
            }
            System.out.println("\nPyramids Printed Successfully !!!\n");
        }
        catch (NullPointerException e)
        {
            System.out.println("File Not Found" + e);
        }
    }
}
