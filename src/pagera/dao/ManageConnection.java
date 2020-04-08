package pagera.dao;

import java.sql.Connection;
import java.sql.*;

public class ManageConnection
{
   
   
    private static Connection conn;
    
    
    /**
     * the Old way to create Questions 
     * @deprecated you should not use this class
     */
       public ManageConnection()
       {
  
     
       }

     public static Connection getConnection() throws SQLException
     {
        try{
        
         Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
         String driver = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)}; DBQ=mydb.mdb;DriverID=22;READONLY=true}";
         conn = DriverManager.getConnection(driver);
         
         }
         catch ( ClassNotFoundException cnfex ) {
            System.err.println(
               "Failed to load JDBC/ODBC driver." );
            cnfex.printStackTrace();
            System.exit( 1 ); 
         }
         catch ( SQLException sqlex ) {
            System.err.println( "Unable to connect" );
            sqlex.printStackTrace();
            System.exit( 1 );  
         }
         
         return conn;
     }
}
