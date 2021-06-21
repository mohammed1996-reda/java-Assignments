package countries;
import java.io.*;
import java.util.*;

public class Main 
{
    public List <City> readcityFromCSV(String fileName)
    {       
        // Intialize an empty list
        List <City> Cities_List = new ArrayList<>();
        
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
                String[] attributes = data.split(",",-1);
                
                for(int i = 0; i < attributes.length; i++)
                {
                    if(attributes[i].isEmpty())
                    {
                        attributes[i] = "";
                    }
                }
                
                // Create a New City Object
                String code = attributes[0];
                String name = attributes[1];
                String country_ID = attributes[2];
                String capital = attributes[3];
                String population = attributes[4];
                City New_City = new City(code, name, country_ID, capital, population);
                
                // Add the new City to the City list
                Cities_List.add(New_City);                             
            }
            
            // Close the file after finishing
            sc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found" + e);
        }
      
        return Cities_List;
    }
    
    public List <Country> readcountryFromCSV(String fileName)
    {       
        // Intialize an empty list
        List <Country> Countries_List = new ArrayList<>();
        
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
                                
                for(int i = 0; i < attributes.length; i++)
                {
                    if(attributes[i].isEmpty())
                    {
                        attributes[i] = "";
                    }
                }
                
                // Create a New City Object
                String code = attributes[1];
                String name = attributes[0];
                Country New_Country = new Country(name,code);
                
                // Add the new City to the City list
                if (!Countries_List.contains(code))
                {
                    Countries_List.add(New_Country);                           
                }
            }
            
            // Close the file after finishing
            sc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found" + e);
        }
      
        return Countries_List;
    }
    
    public static void main(String[] args) 
    {
 
        try
        {
            Main run = new Main();
            List <City> Cities = new ArrayList<>();
            List <Country> Countries = new ArrayList<>();
            
            // Read the files
            String Cities_Path = "F:\\ITI AI Pro\\Lectures\\5) Java and UML\\Assignment\\Assignment 2\\Countries\\cities.csv";
            Cities = run.readcityFromCSV(Cities_Path);
            
            String Countries_Path = "F:\\ITI AI Pro\\Lectures\\5) Java and UML\\Assignment\\Assignment 2\\Countries\\countries.csv";
            Countries = run.readcountryFromCSV(Countries_Path);
                                
            Map <String, List<City>> Relation = new HashMap<>();
            
            for (Country C1 : Countries)
            {
                List <City> CityLists = new ArrayList<>();
                for (City C2 : Cities)
                {
                    if (C1.getCode().equals(C2.getCountryID()))
                    {
                        CityLists.add(C2);
                    }
                }
                CityLists.sort(Comparator.comparing(City::getPopulationValue));
               
                Relation.put(C1.getCode(), CityLists);              
                Relation.forEach((k, v) -> System.out.println("Country=" + k + ", Cities=" + v.toString()));
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("File Not Found" + e);
        }
    }   
}

// Class Collector
// grouping by function