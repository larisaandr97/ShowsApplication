package unibuc.Domain;

import java.util.*;

public class Movie extends Shows {
    protected boolean _3D;
    protected String category;
    protected String subType; //dublat sau subtitrat
    public Movie(String name, String data, String description, double price, double priceVIP, Location location, boolean _3D, String subType)
    {
        super(name, data, description, price,priceVIP,  location);
        this._3D=_3D;
        this.subType=subType;
    }
    public void displayDetails()
    {
        System.out.println("Name: "+ this.getName());
        System.out.println("Date: "+ this.getData());
        System.out.println("Description: "+ this.getDescription());
        System.out.println("Price: "+ this.getPrice());
        if(this.is_3D())
        {
            System.out.println("3D");
        }
        else System.out.println("2D");
        System.out.println(":");
        System.out.println("Type: "+ this.getSubType());
    }

    public boolean is_3D() {
        return _3D;
    }

    public void set_3D(boolean _3D) {
        this._3D = _3D;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }
}
