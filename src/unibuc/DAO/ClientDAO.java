package unibuc.DAO;

import unibuc.Domain.Client;
import java.util.*;
public class ClientDAO {
    //private Client[] clientList;
    ArrayList<Client> clientList;

    public ClientDAO()
    {
         clientList= new ArrayList<>();
    }

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public Client addClient(String username, String name, long telephone, String mailAddress, int age, boolean student, String password){
        Client crt = new Client( username,name,telephone,mailAddress,age,student, password);
       clientList.add(crt);
       return crt;
      /*  Client[] aux = new Client[clientList.length+1];
        for(int i=0;i<clientList.length;i++)
        {
            aux[i]=clientList[i];
        }
        aux[clientList.length]=crt;
        clientList = aux;*/
    }

    public void deleteClient(String name) {

        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).getName().equals(name)) {
                clientList.remove(i);
            }
        }
    }

    public Client searchClient(String username)
    {

        for(int i=0;i<clientList.size();i++)
            if (clientList.get(i).getUsername().equals(username)) {
                System.out.println("User found");
                Client c= clientList.get(i);
                return c;
            }
        System.out.println("This client doesn't exist.");
        return null;
    }
    public void displayClients()
    {
        System.out.println(clientList.size());

        for(int i=0;i<clientList.size();i++) {
            System.out.println(clientList.get(i).getUsername());
            System.out.print(" ");
            System.out.print(clientList.get(i).getName());


        }
    }
}

