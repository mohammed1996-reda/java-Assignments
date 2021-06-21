package countries;

public class Country 
{
    // Class Parameters
    private String Country;
    private String Code;

    public Country() 
    {
        
    }

    public Country(String Country, String Code) 
    {
        this.Country = Country;
        this.Code = Code;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }       
}