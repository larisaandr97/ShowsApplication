package unibuc.DAO;
import unibuc.Domain.Concert;
import unibuc.Domain.Location;
import unibuc.Domain.Shows;
import unibuc.Service.ClientService;

import java.util.ArrayList;
import java.util.Date;

public class ConcertDAO {
    private ArrayList<Concert> concertList=new ArrayList<>();

    public void addConcert(ClientService clientService,String name, String data, String hourStart, String hourEnd,String description, double price, double priceVIP, String location, boolean inOut, String musicType){
        Location locationFound = clientService.getLocationDAO().searchLocation(location);
        if (locationFound==null) {
            System.out.println("Location not found");
            System.exit(0);
        }
        Concert crt = new Concert(name,data,hourStart,hourEnd,description,price,priceVIP, locationFound, inOut, musicType);
        concertList.add(crt);
        /*Shows[] aux = new Concert[concertList.length+1];
        int ok=0;
        for(int i=0;i<concertList.length;i++)
        {
            if (concertList[i] == null) {
                aux[i] = crt;
                ok = 1;
            }
            else {
                aux[i] = concertList[i];
            }
        }
       if(ok==0)
              aux[concertList.length-1]=crt;
        concertList = aux;*/
    }

    public void deleteConcert(String name)
    {

        for(int i=0;i<concertList.size();i++)
        {
            if (concertList.get(i).getName().equals(name)) {
                //concertList[i] = null;
                concertList.remove(i);
            }
        }
    }
    public Shows searchConcert(String name)
    {

        for(int i=0;i<concertList.size();i++)
            if (concertList.get(i).getName().equals(name)) {
                {//concertList[i].displayDetails();
                     return concertList.get(i);}

            }
        return null;
    }

}
