package unibuc.DAO;
import jdk.dynalink.linker.support.CompositeTypeBasedGuardingDynamicLinker;
import unibuc.Domain.Client;
import unibuc.Domain.Movie;
import unibuc.Domain.Reservation;
import unibuc.Domain.Ticket;
import unibuc.Domain.Shows;
import unibuc.Service.ClientService;

import java.lang.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationDAO {
    private ArrayList<Reservation>  resList=new ArrayList<Reservation>();


    Set<Reservation> myStrings = new TreeSet<>(new Comparator<Reservation>() {
        @Override
        public int compare(Reservation o1, Reservation o2) {
            // Define comparing logic here
            return o1.getResDate().compareTo(o2.getResDate());
        }
    });

    public Date convertStringToDate(String date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


        try {

            Date dateParse = formatter.parse(date);
             return dateParse;


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    // pot sa o fac pentru orice tip de eveniment?
    public void addReservationMovie(Shows movie, Client client, String date, int noRegTickets, int noVIPTickets, String resType, Ticket ticket ) {
       // if (resType.equals("movie")) {


        int resCode=resList.size()+1;
       Date data=convertStringToDate(date);
       String name=client.getName();
        //adaug rezervarea la array

                Reservation res = new Reservation(name,data, noRegTickets,noVIPTickets, resType, resCode, ticket);
                resList.add(res);
    }

    public void cencelReservation(int resCode)
    {
        for(int i=0;i<resList.size();i++)
            if (resList.get(i).getResCode()==resCode) {
                resList.remove(i);
                break;
            }
    }

    public Reservation searchReservationDetails(int resCode)
    {

        for(int i=0;i<resList.size();i++)
            if (resList.get(i).getResCode()==resCode) {
                 return resList.get(i);
            }
        System.out.println("We couldn't find your reservation. Try typing again your reservation code.");
        return null;
    }




}

