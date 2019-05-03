package unibuc.Service;

import unibuc.DAO.*;
import unibuc.Domain.Client;
import unibuc.Domain.Location;
import unibuc.Domain.Movie;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import unibuc.DataManipulation;
import unibuc.Domain.Movie;
import unibuc.Domain.Ticket;

public class ClientService {

    private ReservationDAO reservationDAO = new ReservationDAO();
     private  MovieDAO movieDao = new MovieDAO();
    private ClientDAO clientDAO=new ClientDAO();
    private LocationDAO locationDAO=new LocationDAO();
    private ConcertDAO concertDAO=new ConcertDAO();
    private TheatreDAO theatreDAO=new TheatreDAO();

    public Client readDataClient(String username, String password) throws IOException
    {

        //citire de la tastatura detalii
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Username curent:");
        System.out.println(username);
        System.out.println("Introduce your name:");
        String name = keyboard.nextLine();

        System.out.println("Introduce your telephone number:");
        long number = keyboard.nextLong();

        System.out.println("Introduce your mail address:");
        String mail = keyboard.next();

        System.out.println("Introduce your age:");
        int age = keyboard.nextInt();

        System.out.println("Are you a student? Type 1 for Yes and 0 for No:");
        boolean student = keyboard.nextBoolean();
        Client client=clientDAO.addClient(username,name, number, mail, age, student,password);
        // DataManipulation instance=d.get_instance();

        DataManipulation.get_instance().writeUser(clientDAO, "users.csv");
        return client;
    }


    public void writeUser(Client client, String pathName)
    {
        try (PrintWriter writer = new PrintWriter(new File(pathName)))
        {

            StringBuilder sb = new StringBuilder();

            sb.append("Name");
            sb.append(',');
            sb.append("Telephone");
            sb.append(',');
            sb.append("mailAddress");
            sb.append(',');
            sb.append("Age");
            sb.append(',');
            sb.append("Student");
            sb.append('\n');

            sb.append(client.getName());
            sb.append(',');
            sb.append(client.getTelephone());
            sb.append(',');
            sb.append(client.getMailAddress());
            sb.append(',');
            sb.append(client.getAge());
            sb.append(',');
            sb.append(client.getStatus());
            sb.append('\n');

            writer.write(sb.toString());

            System.out.println("done!");

        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public boolean searchMovieInLocation(String locName)
    {

        Location locationFound=locationDAO.searchLocation(locName);
        if(locationFound==null)
        { System.out.println("Location does not exist. "); return false;}
        else
        {
            boolean moviesFound=movieDao.searchMovieInLoc(locName);
            return moviesFound;
        }

    }

    public void addReservation(Client client ) {

        //citire de la tastatura detalii
        Movie movie=movieDao.readMovie();


        //name, long telephone, String mailAddress, int age, boolean student
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Introduce the date:");
        String data = keyboard.nextLine();

        System.out.println("Introduce the number of VIP tickets:");
        int noVIPTickets = keyboard.nextInt();

        System.out.println("Introduce the number of regular tickets:");
        int noRegTickets = keyboard.nextInt();


        if (movie.location.getNoSeatsAvailable() >= noRegTickets && movie.location.getNoSeatsVIP() >= noVIPTickets) {


            //Calculeaza discount-ul in functie de statusul clientului(copil/student/adult)
            String stat = client.getStatus();
            PriceCategoryDAO price = new PriceCategoryDAO();
            int discount = price.searchPriceCategory(client.getStatus());


            System.out.println("Introduce 1 for VIP ticket and 0 for normal ticket.");
            boolean ticketVip = keyboard.nextBoolean();


            System.out.println("Introduce the event type.");
            String resType = keyboard.nextLine();


            Ticket ticket = new Ticket(movie.getPrice(), movie.getName(), movie.location.getLocName(), data, discount, ticketVip, movie.getPriceVIP());
            //alegerea locului, display de locuri disponibile, cu seats[i]=0
            //introducere tastatura  noTickets numere
            reservationDAO.addReservationMovie(movie, client, data, noRegTickets, noVIPTickets,resType,ticket);

        } else System.out.println("There are not enough available seats at this event");

    }

    public void searchReservationForClient(String name)
    {
        Client client=clientDAO.searchClient(name);

    }

    public ReservationDAO getReservationDAO() {
        return reservationDAO;
    }

    public void setReservationDAO(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    public MovieDAO getMovieDao() {
        return movieDao;
    }

    public void setMovieDao(MovieDAO movieDao) {
        this.movieDao = movieDao;
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public LocationDAO getLocationDAO() {
        return locationDAO;
    }

    public void setLocationDAO(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    public ConcertDAO getConcertDAO() {
        return concertDAO;
    }

    public void setConcertDAO(ConcertDAO concertDAO) {
        this.concertDAO = concertDAO;
    }

    public TheatreDAO getTheatreDAO() {
        return theatreDAO;
    }

    public void setTheatreDAO(TheatreDAO theatreDAO) {
        this.theatreDAO = theatreDAO;
    }
}
