package unibuc;
import unibuc.DAO.*;
import unibuc.Domain.*;
import unibuc.Service.AdminService;
import unibuc.Service.AuditService;
import unibuc.Service.ClientService;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataManipulation {

    private AuditService auditService=new AuditService();
    private static DataManipulation data=null;

    private DataManipulation(){};

    public static DataManipulation get_instance()
    {
        if(data==null)
            data=new DataManipulation();
        return data;
    }


    public void readMovies(ClientService clientService,String pathName) {
        BufferedReader br = null;
        String line = "";
        try {

            br = new BufferedReader(new FileReader(pathName));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] movieData = line.split(",");
                String name=movieData[0];
                String date=movieData[1];
                String hourStart=movieData[2];
                String hourEnd=movieData[3];
                String desc=movieData[4];
                Double price=Double.parseDouble(movieData[5]);
                Double priceVip=Double.parseDouble(movieData[6]);
                int noSeats=Integer.parseInt(movieData[7]);
                String location=movieData[8];
                boolean _3D;
                if(movieData[9]=="1")
                     _3D=true;
                else _3D=false;
                String sub=movieData[10];
                clientService.getMovieDao().addMovie(clientService,name, date,hourStart,hourEnd, desc, price,priceVip, noSeats,location,_3D,sub);
                auditService.write_action("read movie", "actions.csv");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void readConcerts(ClientService clientService,String pathName) {
        BufferedReader br = null;
        String line = "";
        try {

            br = new BufferedReader(new FileReader(pathName));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] concertData = line.split(",");
                String name=concertData[0];
                String date=concertData[1];
                String hourStart=concertData[2];
                String hourEnd=concertData[3];
                String desc=concertData[4];
                Double price=Double.parseDouble(concertData[5]);
                Double priceVip=Double.parseDouble(concertData[6]);
                String location=concertData[7];
                Boolean inOut=Boolean.parseBoolean(concertData[8]);
                String musicType=concertData[9];
                clientService.getConcertDAO().addConcert(clientService,name, date,hourStart,hourEnd, desc, price,priceVip,location,inOut,musicType);
                auditService.write_action("read movie", "actions.csv");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void readLocations(ClientService clientService,String pathName) {
        BufferedReader br = null;
        String line = "";
        try {

            br = new BufferedReader(new FileReader(pathName));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] locData = line.split(",");
                String locName=locData[0];
                String address=locData[1];
                int noSeatsAvail=Integer.parseInt(locData[2]);
                int noSeatsVIP=Integer.parseInt(locData[3]);
                String eventType=locData[4];
                clientService.getLocationDAO().addLocation(locName, address,noSeatsAvail,noSeatsVIP,eventType);
                auditService.write_action("read location", "actions.csv");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void readClients(ClientService clientService,String pathName) {
        BufferedReader br = null;
        String line = "";
        try {

            br = new BufferedReader(new FileReader(pathName));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] clientData = line.split(",");
                String username=clientData[0];
                String name=clientData[1];
                long telephone=Long.parseLong(clientData[2]);
                String mailAddress=clientData[3];
                int age=Integer.parseInt(clientData[4]);
                boolean student=Boolean.parseBoolean(clientData[5]);
                String password=clientData[6];
                clientService.getClientDAO().addClient(username, name, telephone, mailAddress, age,student, password);
                auditService.write_action("Read an user on: ", "actions.csv");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readAdmins(ClientService clientService,String pathName) {
        BufferedReader br = null;
        String line = "";
        try {

            br = new BufferedReader(new FileReader(pathName));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] clientData = line.split(",");
                String username=clientData[0];
                String name=clientData[1];
                long telephone=Long.parseLong(clientData[2]);
                String mailAddress=clientData[3];
                int age=Integer.parseInt(clientData[4]);
                boolean student=Boolean.parseBoolean(clientData[5]);
                String password=clientData[6];
                clientService.getClientDAO().addClient(username, name, telephone, mailAddress, age,student, password);
                auditService.write_action("Read an admin on: ", "actions.csv");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeUser(ClientDAO clientDao, String pathName)throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append("Username");
        sb.append(',');
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
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathName, true))) {

            ArrayList<Client> clientList = clientDao.getClientList();
            for (int i = 0; i < clientList.size(); i++) {

                sb.append(clientList.get(i).getUsername());
                sb.append(',');
                sb.append(clientList.get(i).getName());
                sb.append(',');
                sb.append(clientList.get(i).getTelephone());
                sb.append(',');
                sb.append(clientList.get(i).getMailAddress());
                sb.append(',');
                sb.append(clientList.get(i).getAge());
                sb.append(',');
                sb.append(clientList.get(i).getStatus());
                sb.append('\n');
                auditService.write_action("Wrote an user on :", "actions.csv");
                writer.write(sb.toString());

                // System.out.println("done!");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void writeMovie(ClientService clientService,String pathName)throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Name");
        sb.append(',');
        sb.append("Date");
        sb.append(',');
        sb.append("Description");
        sb.append(',');
        sb.append("Price");
        sb.append(',');
        sb.append("Price for VIP");
        sb.append(',');
        sb.append("Location");
        sb.append(',');
        sb.append("Subtitles:");
        sb.append('\n');
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathName, true))) {


            ArrayList<Movie> movieList = clientService.getMovieDao().getMovieList();
            for (int i = 0; i < movieList.size(); i++) {

                sb.append(movieList.get(i).getName());
                sb.append(',');
                sb.append(movieList.get(i).getData());
                sb.append(',');
                sb.append(movieList.get(i).getDescription());
                sb.append(',');
                sb.append(movieList.get(i).getPrice());
                sb.append(',');
                sb.append(movieList.get(i).getPriceVIP());
                sb.append(',');
                sb.append(movieList.get(i).getLocation());
                sb.append(',');
                sb.append(movieList.get(i).getSubType());
                sb.append('\n');

                writer.write(sb.toString());

            }
        }
        catch(FileNotFoundException e)
            {
                System.out.println(e.getMessage());
            }
        catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void writeLocations(ClientService clientService, String pathName)throws IOException {
        StringBuilder sb = new StringBuilder();

       /* sb.append("Location name");
        sb.append(',');
        sb.append("Address");
        sb.append(',');
        sb.append("No of seats available");
        sb.append(',');
        sb.append("No of VIP seats available");
        sb.append(',');
        sb.append("Events type");
        sb.append('\n');*/
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathName, true))) {

            ArrayList<Location> locationList =clientService.getLocationDAO().getLocationList();
            for (int i = 0; i < locationList.size(); i++) {

                sb.append(locationList.get(i).getLocName());
                sb.append(',');
                sb.append(locationList.get(i).getAddress());
                sb.append(',');
                sb.append(locationList.get(i).getNoSeatsAvailable());
                sb.append(',');
                sb.append(locationList.get(i).getNoSeatsVIP());
                sb.append(',');
                sb.append(locationList.get(i).getEventsType());
                sb.append('\n');
                auditService.write_action("Wrote a location on :", "actions.csv");
                writer.write(sb.toString());

                // System.out.println("done!");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


}


