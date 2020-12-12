package bookstore.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private String url ="jdbc:mysql://localhost:3306/BookStore" +
            "?useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false" +
            "&serverTimezone=UTC";
    private String login="root";
    private String pwd="";
    private Connection connexion;
    private static MyConnection instance;

    private MyConnection(){
        try {
            connexion= DriverManager.getConnection(url,login,pwd);
            System.out.println("Connexion établie!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static MyConnection getInstance(){
        if (instance == null){
            instance = new MyConnection();
        }
        return instance;
    }

    public Connection getConnexion() {
        return connexion;
    }

    public static void main(String[] args) {
        MyConnection.getInstance();
    }
}
