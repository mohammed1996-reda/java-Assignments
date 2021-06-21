package pyramids;

import java.util.List;

public class Pyramid {

    // Class Parameters
    private double height;
    private String modern_name;
    private String pharaoh;
    private String site;
    
    // Constructor
    public Pyramid(String pharaoh, String modern_name, String site, double height)
    {
        this.height = height;
        this.modern_name = modern_name;
        this.pharaoh = pharaoh;
        this.site = site;
    }
    
    // Setters and Getters
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getModern_name() {
        return modern_name;
    }

    public void setModern_name(String modern_name) {
        this.modern_name = modern_name;
    }

    public String getPharaoh() {
        return pharaoh;
    }

    public void setPharaoh(String pharaoh) {
        this.pharaoh = pharaoh;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    // public String toString()   
}
