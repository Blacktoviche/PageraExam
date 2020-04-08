package pagera.logic.tables;

    import java.util.List;
    import javax.swing.JTable;
    import javax.swing.table.DefaultTableCellRenderer;
    import javax.swing.table.TableColumn;


    public class MarkTable 
    {
        
        private JTable table = new JTable();
        private MarkResultTable rTable ;
        
        
        public MarkTable( List<Boolean> result) 
        {
        
            rTable = new MarkResultTable(result );
     
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
