package unibuc.Domain;

import java.util.*;

public class Concert extends Shows {

    protected boolean inOut; //false pentru in, true pentru out
    protected String musicType;
    public Concert() {}

    public Concert(String name, String data, String description, double price,double priceVIP, Location location, boolean inOut, String musicType) {
       super(name, data, description, price,priceVIP, location);
       this.inOut=inOut;
       this.musicType=musicType;
    }

    public boolean isInOut() {
        return inOut;
    }

    public void setInOut(boolean inOut) {
        this.inOut = inOut;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }
    public void displayDetails()
    {
        System.out.println("Name: "+ this.getName());
        System.out.println("Date: "+ this.getData());
        System.out.println("Description: "+ this.getDescription());
        System.out.println("Price: "+ this.getPrice());
        System.out.println("In/Out:");
        if(this.isInOut())
        {
            System.out.println("Out");
        }
        else System.out.println("In");
        System.out.println("Music type: "+ this.getMusicType());
    }
}
