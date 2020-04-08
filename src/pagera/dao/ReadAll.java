package pagera.dao;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.sql.Types;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import pagera.dao.ManageQuery;


public class ReadAll
{


    private ManageQuery manageQuery = new ManageQuery();
    private ResultSet resultSet = null;
    private JTable table = null;
    private JScrollPane scroller = null;
    
    /**
     * the Old way to create Questions 
     * @deprecated you should not use this class
     */
    public ReadAll()
    {
    }
    
    
    
    
    public JScrollPane getResultSetAsJScroll(String query )
        {
        
          try 
          {
            resultSet =   manageQuery.selectQuery(query);
            
            return extractResultSet(resultSet);
            
          }
          catch(SQLException sql)
          {
          JOptionPane.showMessageDialog(null,"Error In your Quiery");
          }
           catch(Exception e3)
          {
            JOptionPane.showMessageDialog(null,"Error In your Quiery");
          }
            return new JScrollPane();
        }

      private JScrollPane extractResultSet(ResultSet rs) throws SQLException
      {
        
         boolean moreRecord = rs.next();
         
         if(!moreRecord)///
         {
           JOptionPane.showMessageDialog(null,"Database contained no records");
           
          return new JScrollPane(new JTable(0,0));
         }
      
      Vector columnHeads = new Vector();
      Vector rows = new Vector();
      
      try 
      {
        ResultSetMetaData rsmd = rs.getMetaData();
        
        for(int i = 1; i <= rsmd.getColumnCount(); ++i){
        
            columnHeads.addElement(rsmd.getColumnName(i));
        }
          do 
          {
            rows.addElement(getNextRow(rs,rsmd));
            
          }while(rs.next());
          
          table = new JTable(rows, columnHeads);
          scroller = new JScrollPane(table);
          
           return scroller;

      }
      
       catch(SQLException sqlE)
       {
         JOptionPane.showMessageDialog(null,"SQLException was thrown","Invalid Connection",JOptionPane.ERROR_MESSAGE);
       }
       return null;
      }
      
       private Vector getNextRow(ResultSet rs, ResultSetMetaData rsmd) throws SQLException 
       {
          
          Vector currentRow = new Vector();
          
          for(int i = 1; i <= rsmd.getColumnCount(); ++i)
            switch(rsmd.getColumnType(i))
            {
              case Types.VARCHAR:
              case Types.LONGVARCHAR:
                   currentRow.addElement(rs.getString(i));
                   break;
              case Types.INTEGER:
                   currentRow.addElement(new Long(rs.getLong(i)));
                   break;
             case Types.NUMERIC:
                   currentRow.addElement(new Long(rs.getLong(i)));
                   break;
              case Types.DATE :
                   currentRow.addElement(rs.getDate(i));// Date(i));
                   break;
              case Types.TIMESTAMP:
                   currentRow.addElement(rs.getDate(i));
                   break;
             case Types.DOUBLE:
                   currentRow.addElement(new Integer(new Double(rs.getDouble(i)).intValue()));
                   break;
              default:
              
              
            }
          return currentRow;
       }

     
        public Vector getResultSetAsVector(String query )
        {
        
          try 
          {
            
            resultSet =   manageQuery.selectQuery(query);
            
            return extractResultSetAsVector(resultSet);
            
          }
          catch(SQLException sql)
          {
          JOptionPane.showMessageDialog(null,sql.getMessage(),"Invalid Connection",JOptionPane.ERROR_MESSAGE);
          }
           catch(Exception e3)
          {
            JOptionPane.showMessageDialog(null,"Error In your Quiery","Invalid Connection",JOptionPane.ERROR_MESSAGE);
          }
            return null;
        }

      private Vector extractResultSetAsVector(ResultSet rs) throws SQLException
      {
        
         boolean moreRecord = rs.next();
         
         if(!moreRecord)///
         {
           JOptionPane.showMessageDialog(null,"Database contained no records","Invalid Connection",JOptionPane.ERROR_MESSAGE);
           
          return  new Vector();
         }
      
      Vector columnHeads = new Vector();
      Vector rows = new Vector();
      
      try 
      {
        ResultSetMetaData rsmd = rs.getMetaData();
        
        for(int i = 1; i <= rsmd.getColumnCount(); ++i){
        
            columnHeads.addElement(rsmd.getColumnName(i));
        }
          do 
          {
            rows.addElement(getNextRow(rs,rsmd));
            
          }while(rs.next());
          
           return rows;
      }
       catch(SQLException sqlE)
       {
         JOptionPane.showMessageDialog(null,"SQLException through","Invalid Connection",JOptionPane.ERROR_MESSAGE);
       }
       return null;
      }
      

}
