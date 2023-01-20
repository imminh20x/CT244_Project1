
package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectMCSQL {
    private Connection connection;
    
    public Connection getConnection(){
        return connection;
    }
    
    public ConnectMCSQL(){
       try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");             
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CHATAPPLICATION; user=sa;password=sa2008");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("DB.Connect.<init>()");
        }
    }
    
}
