package unibuc.DAO;

import unibuc.Domain.Location;
import unibuc.Service.ClientService;

import java.util.ArrayList;
import java.util.Date;

public class LocationDAO {
    //private Location[] locationList=new Location[100];
    private ArrayList<Location> locationList= new ArrayList<Location>();

    public ArrayList<Location> getLocationList() {
        return locationList;
    }

    public void addLocation(ClientService clientService, String locName, String address, int seatsAvailable, int seatsVIP, String eventsType){

        Location loc = new Location(locName,address, seatsAvailable, seatsVIP,eventsType);
        locationList.add(loc);
        /*Location[] aux = new Location[locationList.length+1];
        int ok=0;
        for(int i=0;i<locationList.length;i++) {
            if (locationList[i] == null) {
                aux[i] = mov;
                ok = 1;
            }
            else {
                aux[i] = locationList[i];
            }
        }
        if(ok==0)
            aux[aux.length-1]=mov;
        locationList = aux;*/
    }

    public void deleteLocation(String name)
    {

        for(int i=0;i<locationList.size();i++)
        {
            if (locationList.get(i).getLocName().equals(name)) {
               // locationList[i] = null;
                locationList.remove(i);
            }
        }
    }

    public void displayLocations()
    {
        for(int i=0;i<locationList.size();i++) {
            System.out.println(locationList.get(i).getLocName());
        }

    }

    public Location searchLocation(String name)
    {

        for(int i=0;i<locationList.size();i++)
            if (locationList.get(i).getLocName().equals(name)) {
                 // locationList[i].displayDetails();
                     return locationList.get(i); }
        return null;
    }
}
