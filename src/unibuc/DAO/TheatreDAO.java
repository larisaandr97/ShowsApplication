package unibuc.DAO;
import unibuc.Domain.Location;
import unibuc.Domain.Theatre;
import unibuc.Service.ClientService;

import java.util.*;
import java.util.Date;

public class TheatreDAO {
    private ArrayList <Theatre> theatreList=new ArrayList<>();

    public void addTheatre(ClientService clientService,String name, String data, String description, double price, int noSeatsAvailable, String location, Set <String> distribution, String type){
        Location locationFound = clientService.getLocationDAO().searchLocation(location);
        if (locationFound==null) {
            System.out.println("Location not found");
            System.exit(0);
        }
        Theatre crt = new Theatre(name,data,description,price, noSeatsAvailable,locationFound, distribution, type);

       /* Theatre[] aux = new Theatre[theatreList.length+1];
        int ok=0;
        for(int i=0;i<theatreList.length;i++)
        {
            if (theatreList[i] == null)
            {
                aux[i] = crt;
                ok = 1;
            }
            else {
                aux[i] = theatreList[i];
            }

        }
        if(ok==0)
             aux[theatreList.length-1]=crt;
        theatreList = aux;*/
    }

    public void deleteTheatre(String name)
    {

        for(int i=0;i<theatreList.size();i++)
        {
            if (theatreList.get(i).getName().equals(name)) {
                theatreList.remove(i);
            }
        }
    }
    public void searchTheatre(String name)
    {

        for(int i=0;i<theatreList.size();i++)
            if (theatreList.get(i).getName().equals(name)) {
                theatreList.get(i).displayDetails();
                break;
            }
    }

}
