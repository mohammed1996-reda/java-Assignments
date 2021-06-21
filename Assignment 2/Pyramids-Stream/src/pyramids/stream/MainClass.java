package pyramids.stream;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

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
             
            // Calculating The Mean
            double Means = Pyramids.stream()
                .filter(p -> p.getHeight() > 0)
                .mapToDouble(Pyramid::getHeight)
                .average()
                .getAsDouble();            
            
            // Replacing 0 Values with the Mean
            for (Pyramid p : Pyramids)
            {   
                if (p.getHeight() <= 0.0)
                {
                    //System.out.println("Empty Changed");
                    p.setHeight(Means);
                }
            }
             
            // Converting Data to List of Height
            List <Double> Heights = Pyramids.stream()
                    .map(Pyramid::getHeight)
                    .sorted()
                    .collect(toList());
            
            // Calculating The Median
            double median = 0 ;
            double firstQuartile = 0;
            double thirdQuartile = 0;
            
            // Checking Main Height Size Odd or Even
            if (Heights.size() % 2 == 0)
            {
                int index2 = Heights.size()/2;
                int index1 = (Heights.size()/2) -1;
                median = (Heights.get(index1) + Heights.get(index2)) /2;
                // System.out.println("Indexes are = " + index1 + " , " + index2);
                
                // Checking Sub Height Size Odd or Even
                if (index1 % 2 == 0)
                {
                    int index11 = (int)index1 /2;
                    int index12 = (int)(index1/2) - 1;
                    firstQuartile = (Heights.get(index11) + Heights.get(index12)) /2;
                    thirdQuartile = (Heights.get((int)(index1+index11)) + Heights.get((int)(index1+index12))) /2;
                    
                }
                else
                {
                    int indexx = (int) index1/2;
                    firstQuartile = Heights.get(indexx);
                    thirdQuartile = Heights.get((int)(index1+indexx));
                    // System.out.println("Indexes are = " + indexx + " , " + (index1+indexx));
                }
            }
            else
            {
                int index = Heights.size()/2;
                median = Heights.indexOf(index);
                //System.out.println("Indexes are = " + index);
                
                // Checking Sub Height Size Odd or Even
                if (index % 2 == 0)
                {
                    int index11 = index /2;
                    int index12 = (index/2) - 1;
                    firstQuartile = (Heights.get(index11) + Heights.get(index12)) /2;
                    thirdQuartile = (Heights.get((int)(index+index11)) + Heights.get((int)(index+index12))) /2;
                   
                }
                else
                {
                    int indexx = index/2;
                    firstQuartile = Heights.get(indexx);
                    thirdQuartile = Heights.get((int)(index+indexx));
                    // System.out.println("Indexes are = " + indexx + " , " + (index+indexx));
                }
            }
            System.out.println("The Height = " + Heights);
            System.out.println("The Mean = " + Means);
            System.out.println("The Median = " + median);
            System.out.println("The First Quartile = " + firstQuartile);
            System.out.println("The Third Quartile = " + thirdQuartile);
        }
        catch (NullPointerException e)
        {
            System.out.println("File Not Found" + e);
        }
    }
}