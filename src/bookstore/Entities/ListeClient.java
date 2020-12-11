/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class ListeClient {
    private List<Client> Clients;
    public ListeClient(List<Client> Clients) {
this.Clients=Clients;
}
public ListeClient() {
Clients = new ArrayList<Client>();
//instancier un objet de type array list
}


public List<Client> getClients() {
return Clients;
}


public void setClients(List<Client> Clients) {
this.Clients=Clients;
}

    
}
