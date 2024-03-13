package AtmManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Con{
    Connection c;
    Statement statement;
    public Con(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root","root");
            statement = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
