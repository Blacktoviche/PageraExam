package pagera.logic.tables;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.TableColumn;

import pagera.logic.tables.AnswerResultTable;


public class AnswersTable
{
    
    private JTable table = new JTable();
    private AnswerResultTable rTable ;
    
    
    public AnswersTable( List<Boolean> result) 
    {
    
        rTable = new AnswerResultTable(result );
 
        table.setAutoCreateColumnsFromModel(false);
        table.setModel(rTable); 


        for (int k = 0; k < rTable.columns.length; k++)
        {
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

            renderer.setHorizontalAlignment(rTable.columns[k].getAlignment());

            TableColumn column = new TableColumn(k, 

              rTable.columns[k].getWidth() , renderer, null);
              table.addColumn(column);   
          }

    }//
    
    public JTable getTable()
    {
       
       return table;
        
    }
    
}//
