/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date; 
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class Emprunt {
    private int id, icClient;
    private String nomEmp;
    private Date DateDebut,DateFin;
    


   
    
     public Emprunt(int idClient, String nomEmp) {
        this.id = id;
        this.icClient = idClient;
        this.nomEmp = nomEmp;
   
    }
    
     public Emprunt(String nomEmp) {
        this.nomEmp = nomEmp;
   
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public void setDateDebut(Date DateDebut) {
        this.DateDebut = DateDebut;
    }

    public void setDateFin(Date DateFin) {
        this.DateFin = DateFin;
    }
     
    public Emprunt() {
    }
    
     public Emprunt(int idClient,String nomEmp, String DateDebut, String DateFin) {
         DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
         this.icClient=idClient;
         this.nomEmp=nomEmp;
         
        try {
            this.DateDebut= dateFormat.parse(DateDebut);
        } catch (ParseException ex) {
            Logger.getLogger(Emprunt.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.DateFin= dateFormat.parse(DateFin);
        } catch (ParseException ex) {
            Logger.getLogger(Emprunt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public Emprunt(int id,int idClient,String nomEmp, Date DateDebut, Date DateFin) {
       
         this.id=id;
         this.icClient=idClient;
         this.nomEmp=nomEmp;
         this.DateDebut=DateDebut;
         this.DateFin= DateFin;
        
    }
    
    
    public Emprunt(int idClient) {
    this.icClient=idClient;
    }

    public int getId() {
        return id;
    }

    public int getIcClient() {
        return icClient;
    }

    public String getNomEmp() {
        return nomEmp;
    }

  

    public void setId(int id) {
        this.id = id;
    }

    public void setIcClient(int icClient) {
        this.icClient = icClient;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    @Override
    public String toString() {
        return "Emprunt{" + "id=" + id + ", idClient=" + icClient + ", nomEmp=" + nomEmp + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + '}';
    }

  

  
   

    
    
}
