package unibuc.DAO;
import unibuc.Domain.Client;
import unibuc.Domain.Movie;
import unibuc.Domain.Reservation;
import unibuc.Domain.Ticket;
import unibuc.Domain.Shows;
import java.lang.*;
import java.util.*;

public class ReservationDAO {
    private Reservation[] resList;


    Set<Reservation> myStrings = new TreeSet<>(new Comparator<Reservation>() {
        @Override
        public int compare(Reservation o1, Reservation o2) {
            // Define comparing logic here
            return o1.getResDate().compareTo(o2.getResDate());
        }
    });
    // pot sa o fac pentru orice tip de eveniment?
    public void addReservationMovie(Shows movie, Client client, String date, int noRegTickets,int noVIPTickets, String resType, Ticket ticket ) {
       // if (resType.equals("movie")) {


                 int resCode=resList.length+1;
                //adaug rezervarea la array
                Reservation res = new Reservation(date, noRegTickets,noVIPTickets, resType, resCode, ticket);
                Reservation[] aux = new Reservation[resList.length + 1];
                int ok=0;
                for (int i = 0; i < resList.length; i++) {
                    if (resList[i] == null) {
                        aux[i] = res;
                        ok = 1;
                    }
                    else {
                        aux[i] = resList[i];
                    }

                }
                if(ok==0)
                    aux[resList.length-1] = res;
                resList = aux;

       // }
      //  else if()
    }

    public void cencelReservation(int resCode)
    {
        for(int i=0;i<resList.length;i++)
            if (resList[i].getResCode()==resCode) {
                resList[i]=null;
                break;
            }
    }

    public Reservation searchReservationDetails(int resCode)
    {

        for(int i=0;i<resList.length;i++)
            if (resList[i].getResCode()==resCode) {
                 return resList[i];
            }
        System.out.println("We couldn't find your reservation. Try typing again your reservation code.");
        return null;
    }

}

