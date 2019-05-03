package unibuc.DAO;

import unibuc.DataManipulation;
import unibuc.Domain.Client;
import unibuc.Domain.Location;
import unibuc.Domain.Movie;
import unibuc.Service.ClientService;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDAO {
    private ArrayList<Movie> movieList= new ArrayList<Movie>();

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void addMovie(ClientService clientService, String name, String data,String hourStart, String hourEnd, String description, double price, double priceVIP, int noSeatsAvailable, String location, boolean _3D, String subType) {

        Location locationFound = clientService.getLocationDAO().searchLocation(location);
        if (locationFound==null) {
            System.out.println("Location not found");
            System.exit(0);
        }


        Movie mov = new Movie(name, data,hourStart,hourEnd, description, price, priceVIP, locationFound, _3D, subType);
        movieList.add(mov);
       /* Movie[] aux = new Movie[movieList.length + 1];
        int ok = 0;
        for (int i = 0; i < movieList.length; i++) {
            if (movieList[i] == null) {
                aux[i] = mov;
                ok = 1;
            } else {
                aux[i] = movieList[i];
            }
        }
        if (ok == 0)
            aux[aux.length - 1] = mov;


        movieList = aux;
*/    }

    public void deleteMovie(String name) {

        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getName().equals(name)) {
                movieList.remove(i);
            }
        }
    }

    public Movie searchMovie(String name) {

        for (int i = 0; i < movieList.size(); i++)
            if (movieList.get(i).getName().equals(name)) {
                {
                    movieList.get(i).displayDetails();
                    return movieList.get(i);
                }

            }
        return null;
    }

    public boolean searchMovieInLoc(String locName)
    {
        int found=0;
        for (int i = 0; i < movieList.size(); i++)
            if (movieList.get(i).getLocation().getLocName().equals(locName)) {
                {
                    movieList.get(i).displayDetails();
                   // return movieList.get(i);
                    found=1;
                }

            }
        if(found==0)
            { System.out.println("We didn't find any movies in the location you introduced.");
             return false;
            }
        return true;
    }

    public boolean searchMovieOfCategory(String category)
    {
        int found=0;
        for (int i = 0; i < movieList.size(); i++)
            if (movieList.get(i).getSubType().equals(category)) {
                {
                    movieList.get(i).displayDetails();
                    found=1;
                  //  return movieList.get(i);
                }

            }
        if(found==0)
        {
            System.out.println("We haven't found movies of the category you introduced.");
            return false;
        }
        return true;
    }

    public Movie readMovie() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce the name of the movie:");
        String nameMovie = keyboard.next();
        Movie movie =searchMovie(nameMovie);
        return movie;
    }

    public void displayMovies()
    {
        System.out.println(movieList.size());

        for(int i=0;i<movieList.size();i++) {
            System.out.println(movieList.get(i).getName());
            System.out.print(" ");
            System.out.print(movieList.get(i).getData());
            System.out.print(" ");
            System.out.print(movieList.get(i).getDescription());
        }
    }
}