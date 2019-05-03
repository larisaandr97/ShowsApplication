package unibuc;
import unibuc.Domain.*;
import unibuc.Service.AdminService;
import unibuc.Service.AuditService;
import unibuc.Service.ClientService;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private Scanner keyboard = new Scanner(System.in);



    public static void main(String args[])throws IOException
    {

        ConsoleApp consoleApp=new ConsoleApp();

        ClientService clientService=consoleApp.getClientService();
        clientService.getClientDAO().displayClients();
        PriceCategory price = new PriceCategory("student", 20);

        if(DataManipulation.get_instance()!=null)
        {
           // clientService.getLocationDAO().addLocation(clientService,"CinemaCity", "Str. Republicii nr. 20", 250, 50, "movie");
           // clientService.getLocationDAO().displayLocations();
          //  clientService.getMovieDao().addMovie(clientService, "Avengers: Infinity War", "12-10-2019","The Guardians of the Galaxy respond to a distress call from the Asgardian ship", 18.50,  25.50, 50, "CinemaCity",true, "subtitled" );
          /*  consoleApp.showClientInitialMenu();
            int option=consoleApp.readOptionInitial();
            consoleApp.executeOptionMenuClient(option);
            clientService.getClientDAO().displayClients();*/
            DataManipulation.get_instance().readLocations(consoleApp.getClientService(), "readLocations.csv");
            DataManipulation.get_instance().writeLocations(consoleApp.getClientService(), "locations.csv");
            DataManipulation.get_instance().readMovies(consoleApp.getClientService(), "readMovies.csv");
            DataManipulation.get_instance().writeMovie(consoleApp.getClientService(), "movies.csv");
            DataManipulation.get_instance().readClients(consoleApp.getClientService(), "readClients.csv");
            DataManipulation.get_instance().writeUser(consoleApp.getClientService().getClientDAO(), "users.csv");
           // clientService.getClientDAO().displayClients();
            clientService.getLocationDAO().displayLocations();
            clientService.getMovieDao().displayMovies();
           // clientService.getMovieDao().addMovie(clientService, "Avengers: Infinity War", "12-10-2019","The Guardians of the Galaxy respond to a distress call from the Asgardian ship", 18.50,  25.50, 50, "CinemaCity",true, "subtitled" );
           consoleApp.showInitialMenu();

          /*  consoleApp.showClientInitialMenu();
            int option=consoleApp.readOption(5);
            consoleApp.executeOptionMenuClient(option);*/
           // clientService.getClientDAO().displayClients()  ;

        }
   /*
        Main app = new Main();
        app.showInitialMenu();
        int option = app.readOptionInitial();
        app.executeStatusUser(option);
        while (true) {

        }*/
    }

}