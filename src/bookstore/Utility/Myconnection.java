/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Utility;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Myconnection {
    
    
    private String url="jdbc:mariadb://localhost:3307/vermeg";
    private String login="root";
    private String pwd="";
    private Connection connexion;
    private static Myconnection instance;
    
        private Myconnection() 
    {
        try {
           
            connexion=DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie ! ");
        } 
        catch (SQLException ex) {
            Logger.getLogger(Myconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        
        
    public static Myconnection getIstance() 
    {
        if(instance==null)
            instance=new Myconnection();
        
        return instance;
    }
    public Connection getConnection()
    {
        return connexion;
    }    
    
}
