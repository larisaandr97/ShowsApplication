package unibuc.Domain;
import unibuc.Domain.Location;
import unibuc.Domain.Shows;

import java.util.*;
import java.lang.*;
public class Theatre extends Shows {
    public String type; //de copii sau normal
    public Set <String> distribution;
    public Theatre(String name, String data, String description, double price, double priceVIP, Location location, Set <String> distribution, String type) {
        super(name, data, description, price,priceVIP,location);
        this.distribution.addAll(distribution);
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<String> getDistribution() {
        return distribution;
    }

    public void setDistribution(Set<String> distribution) {
        this.distribution = distribution;
    }

    public void displayDetails()
    {
        System.out.println("Name: "+ this.getName());
        System.out.println("Date: "+ this.getData());
        System.out.println("Description: "+ this.getDescription());
        System.out.println("Price: "+ this.getPrice());
        System.out.println("Distribution:");
        Iterator iterator = this.distribution.iterator();
        while(iterator.hasNext()){
        String element = (String) iterator.next();
        System.out.println(element);
    }
        System.out.println("Type: "+ this.getType());
    }
}
