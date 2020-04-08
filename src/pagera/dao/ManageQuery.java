package pagera.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManageQuery
{
    
    private ManageConnection mc ;
    private Statement statement;
    
    
    /**
     * the Old way to create Questions 
     * @deprecated you should not use this class
     */
    public ManageQuery()
    {
     
     try{
        mc = new ManageConnection();
        statement = mc.getConnection().createStatement();
        
     }
     catch(Exception ex)
     {
       ex.printStackTrace();    
     }
        
    }
    
    
    public void insertQuery(String query)throws SQLException
    {
    
        statement.execute(query);
         
    }
    
    public ResultSet selectQuery(String query)throws SQLException
    {
    
       return  statement.executeQuery(query);
        
    }
    
}
