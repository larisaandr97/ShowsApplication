package unibuc.Domain;
import unibuc.Domain.Location;

import java.util.*;

public class Shows {
    protected String name;
    protected String data;
    protected String hourStart;
    protected String hourEnd;
    protected String description;
    protected double price;
    protected double priceVIP;
    protected int noSeatsAvailable;
    protected int noSeatsVIP;
    protected int[] seats;
    public Location location;
    public Shows () {}
    public Shows(String name, String data, String hourStart, String hourEnd,String description, double price, double priceVIP, Location location) {
        this.name = name;
        this.data = data;
        this.hourStart=hourStart;
        this.hourEnd=hourEnd;
        this.description = description;
        this.price=price;
        this.priceVIP=priceVIP;
        this.noSeatsAvailable=location.getNoSeatsAvailable();
        this.noSeatsVIP=location.getNoSeatsVIP();
        this.seats=new int[noSeatsAvailable+1];
        for(int i=0;i<seats.length;i++)
            seats[i]=0;
        this.location=location;
    }

   // public abstract void displayDetails();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHourStart() {
        return hourStart;
    }

    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    public String getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNoSeatsAvailable() {
        return noSeatsAvailable;
    }

    public void setNoSeatsAvailable(int noSeatsAvailable) {
        this.noSeatsAvailable = noSeatsAvailable;
    }

    public double getPriceVIP() {
        return priceVIP;
    }

    public void setPriceVIP(double priceVIP) {
        this.priceVIP = priceVIP;
    }

    public int getNoSeatsVIP() {
        return noSeatsVIP;
    }

    public void setNoSeatsVIP(int noSeatsVIP) {
        this.noSeatsVIP = noSeatsVIP;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
