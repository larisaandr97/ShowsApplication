package unibuc;

import unibuc.DAO.ClientDAO;
import unibuc.DAO.MovieDAO;
import unibuc.Domain.Client;
import unibuc.Domain.Movie;
import unibuc.Service.AdminService;
import unibuc.Service.ClientService;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleApp {
    private Scanner keyboard = new Scanner(System.in);
    private DataManipulation d;
    private ClientService clientService=new ClientService();
    private AdminService adminService=new AdminService();


    public DataManipulation getD() {
        return d;
    }

    public void setD(DataManipulation d) {
        this.d = d;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public void showClientInitialMenu()throws IOException
    {
       /* System.out.println("1. Do you already have an account? Sign in.");
        System.out.println("2. Are you new here? Create an account now ");
        System.out.println("3. Exit");*/

        //Sau : Direct: Username si Password
        System.out.println("Username:");
        String username=keyboard.nextLine();
        //System.out.println("Password:");
        Client c= clientService.getClientDAO().searchClient(username);
        if(c!=null) //clientul deja exista
        {
            System.out.println("The client already exists.");

            int done=0;
            while(done==0) {
                System.out.println("Password:");
                String password = keyboard.nextLine();
                if (password == c.getPassword())
                {done=1; showClientOptionMenu(c);}
                else {
                    System.out.println("The password is incorrect. To try again write 1, to exit write 0.");
                    int opt=keyboard.nextInt();
                    if(opt==0)
                        System.exit(0);
                }
            }
        }
        else // e client nou
        {
            System.out.println("Introduce a password:");
            String password=keyboard.nextLine();

            // ClientService readUser function?
            Client client= clientService.readDataClient( username, password);
            showClientOptionMenu(client);

        }

    }

    public void showInitialMenu()
    {

        System.out.println("You are a client or an admin?");
        System.out.println("1. Client");
        System.out.println("2. Admin ");
        System.out.println("3. exit");
        readOptionInitial();
    }


    public void showAdminInitialMenu()
    {

    }

    public int readOptionInitial() {
        //  try {
        int option = keyboard.nextInt();
        if (option >= 1 && option <= 3)
            return option;
        //   }
        // } catch (InvalidDataException invalid) {
        // nothing to do, as it's handled below
        //}
        System.out.println("Invalid option. Try again");
        return readOptionInitial();
    }

    public void executeStatusUser(int option) throws IOException{
        switch (option) {
            case 1:
                showClientInitialMenu();
                break;
            case 2:
                // list entities
                showAdminInitialMenu();
                break;
            case 3:
                System.exit(0);
        }
    }

    public void showClientOptionMenu(Client c)
    {
        System.out.println("Menu");
        System.out.println("1. Search for a movie");
        System.out.println("2. See shows in a certain location");
        System.out.println("3. Make a reservation");

    }

    public void executeOptionMenuClient(int option) {
        switch (option) {
            case 1:
                String movie=keyboard.next();

                Movie movieFound=clientService.getMovieDao().searchMovie(movie);
                if(movieFound!=null)
                     movieFound.displayDetails();
                else System.out.println("This movie doesn't exist.");
                break;
            case 2:
                // list entities
                String location=keyboard.nextLine();

                break;
            case 3:
                System.exit(0);
        }
    }
}
