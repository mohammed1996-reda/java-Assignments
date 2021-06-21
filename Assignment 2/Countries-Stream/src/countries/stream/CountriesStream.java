package countries.stream;
import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.*;

public class CountriesStream 
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
        //Main run = new Main();
        CountriesStream run = new CountriesStream();
        List <City> Cities = new ArrayList<>();
        List <Country> Countries = new ArrayList<>();

        // Read the files
        String Cities_Path = "F:\\ITI AI Pro\\Lectures\\5) Java and UML\\Assignment\\Assignment 2\\Countries\\cities.csv";
        Cities = run.readcityFromCSV(Cities_Path);

        String Countries_Path = "F:\\ITI AI Pro\\Lectures\\5) Java and UML\\Assignment\\Assignment 2\\Countries\\countries.csv";
        Countries = run.readcountryFromCSV(Countries_Path);
              
        // Highest population city of each country
        System.out.println("Highest population city of each country");
        for (Country C1 : Countries)
        {
            List <City> PopulationPerCountry = Cities.stream()
                    .filter(c -> C1.getCode().equals(c.getCountryID())).sorted(Comparator.comparing(City::getPopulationValue).reversed())
                    .limit(1)
                    .collect(toList());

            PopulationPerCountry.forEach(C -> System.out.println("Country = " + C.getCountryID() + " ,City=" + C.getName()+ " ,Population = " + C.getPopulation()));   
        }
        // Highest population capital
        System.out.println("Highest 5 population capitals");
        List <City> HighestPopulation = Cities.stream()
                    .filter(c -> c.getPopulation() != "")
                    .sorted(Comparator.comparing(City::getPopulationValue).reversed())
                    .limit(5)
                    .collect(toList());
        
        HighestPopulation.forEach(C -> System.out.println("Country = " + C.getCountryID() + " ,City = " + C.getName()+ " ,Population = " + C.getPopulation()));   
    }
}
