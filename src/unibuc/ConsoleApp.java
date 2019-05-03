package unibuc;

import com.sun.source.tree.WhileLoopTree;
import unibuc.DAO.ClientDAO;
import unibuc.DAO.MovieDAO;
import unibuc.Domain.Client;
import unibuc.Domain.Movie;
import unibuc.Domain.Location;
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
        keyboard.nextLine();
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
                if (password.equals(c.getPassword()))
                {done=1; showClientOptionMenu();}
                else {

                    System.out.println("The password is incorrect. To try again write 1, to exit write 0.");
                    int opt=keyboard.nextInt();
                    if(opt==0)
                        System.exit(0);
                    else password=keyboard.nextLine();
                }
            }
        }
        else // e client nou
        {
            System.out.println("Introduce a password:");
            String password=keyboard.nextLine();

            // ClientService readUser function?
            Client client= clientService.readDataClient( username, password);
            showClientOptionMenu();

        }

    }

    public void showInitialMenu() throws IOException
    {

        System.out.println("You are a client or an admin?");
        System.out.println("1. Client");
        System.out.println("2. Admin ");
        System.out.println("3. exit");
       int option= readOption(3);
        executeStatusUser(option);
    }


    public void showAdminInitialMenu()
    {

        System.out.println("Menu");
        System.out.println("1. Edit clients");
        System.out.println("2. Edit shows ");
        System.out.println("3. Rservations menu");
        int option= readOption(3);
        executeAdminOptionMenu(option);
    }

    public void executeAdminOptionMenu(int option)
    {
        int done=0;
        switch (option) {
            case 1:
                showAdminInitialMenuClientEdit();
                break;
            case 2:
        }

    }

    public void showAdminInitialMenuClientEdit()
    {

        System.out.println("Menu");
        System.out.println("1. See all clients");
        System.out.println("2. Search for a client");
        System.out.println("3. Delete a client");
        System.out.println("4.Go back to initial menu.");
        int option= readOption(3);
        executeAdminOptionMenuClientEdit(option);
    }



    public void executeAdminOptionMenuClientEdit(int option) {
        int done=0;
        switch (option) {
            case 1:
                done=0;
                System.out.println("Introduce the name of the client: ");
                while(done==0) {
                    keyboard.nextLine();
                    String nameClient = keyboard.next();
                    Client clientFound = clientService.getClientDAO().searchClient(nameClient);
                    if (clientFound != null)
                    {  clientFound.displayClientDetails(); done=1;}
                    else System.out.println("This client doesn't exist. Try typing again the name.");
                }
                showAdminInitialMenu();
                break;
            case 2:
                // list entities

                done=0;
                System.out.println("Introduce the name of the location;");
                while(done==0) {
                    keyboard.nextLine();
                    String locName = keyboard.nextLine();
                    Location locFound=clientService.getLocationDAO().searchLocation(locName);
                    if (locFound != null)
                    {
                        clientService.getMovieDao().searchMovieInLoc(locName); done=1;}
                    else System.out.println("This location doesn't exist.");
                }
                showClientOptionMenu();
                break;
            case 3:
                System.out.println("Introduce the name of the category;");
                while(done==0) {
                    keyboard.nextLine();
                    String catName = keyboard.nextLine();
                    boolean found=clientService.getMovieDao().searchMovieOfCategory(catName);
                    if (found)
                    {
                        done=1;}
                    else System.out.println("Try again typing a category.");
                }
                showClientOptionMenu();
                break;
            case 4:
                System.exit(0);
        }
    }

    public void showAdminInitialMenuShowsEdit()
    {

        System.out.println("Menu");
        System.out.println("1. See all shows");
        System.out.println("2. Search for a show");
        System.out.println("3. Delete a show");
        System.out.println("4.Go back to initial menu.");
        int option= readOption(3);
        executeAdminOptionMenuShowsEdit(option);
    }

    public void executeAdminOptionMenuShowsEdit(int option)
    {
        int done=0;
        switch (option){
            case 1:

        }

    }


    public int readOption(int noOptions) {
        //  try {
        int option = keyboard.nextInt();
        if (option >= 1 && option <=noOptions)
            return option;
        //   }
        // } catch (InvalidDataException invalid) {
        // nothing to do, as it's handled below
        //}
        System.out.println("Invalid option. Try again");
        return readOption(noOptions);
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

    public void showClientOptionMenu()
    {
        System.out.println("Menu");
        System.out.println("1. Search for a movie");
        System.out.println("2. See shows in a certain location");
        System.out.println("3. See movies of a certain category");
        System.out.println("4. Make a reservation");
        System.out.println("5.Logout");
        int option= readOption(5);
        executeOptionMenuClient(option);

    }

    public void executeOptionMenuClient(int option) {
        int done=0;
        switch (option) {
            case 1:
                done=0;
                System.out.println("Introduce the name of the movie: ");
                while(done==0) {
                    keyboard.nextLine();
                    String movie = keyboard.next();
                    Movie movieFound = clientService.getMovieDao().searchMovie(movie);
                    if (movieFound != null)
                    {  movieFound.displayDetails(); done=1;}
                    else System.out.println("This movie doesn't exist.");
                }
                showClientOptionMenu();
                break;
            case 2:
                // list entities

                done=0;
                System.out.println("Introduce the name of the location;");
                while(done==0) {
                    keyboard.nextLine();
                    String locName = keyboard.nextLine();
                    Location locFound=clientService.getLocationDAO().searchLocation(locName);
                    if (locFound != null)
                    {
                        clientService.getMovieDao().searchMovieInLoc(locName); done=1;}
                    else System.out.println("This location doesn't exist.");
                }
                showClientOptionMenu();
                break;
            case 3:
                System.out.println("Introduce the name of the category;");
                while(done==0) {
                    keyboard.nextLine();
                    String catName = keyboard.nextLine();
                    boolean found=clientService.getMovieDao().searchMovieOfCategory(catName);
                    if (found)
                    {
                        done=1;}
                    else System.out.println("Try again typing a category.");
                }
                showClientOptionMenu();
                break;
            case 4:
                System.exit(0);
        }
    }
}
