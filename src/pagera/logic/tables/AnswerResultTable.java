package pagera.logic.tables;

import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;


public class AnswerResultTable extends AbstractTableModel
{

      public static final ColumnData columns[] =

    { new ColumnData("Question Number", 200, JLabel.LEFT),
      new ColumnData("Result", 150, JLabel.LEFT), };

      private Vector<AnswerColumns> vector;

      public AnswerResultTable( List<Boolean> result)
      {

        vector = new Vector<AnswerColumns>();
          fillVector(result);

      }
     
    public void fillVector(List<Boolean> result )
    {
           
        for (int h = 0 ;  h < result.size() ; h++ )
        {
          int u = h  ;
         vector.addElement(new AnswerColumns( ++u , result.get(h).booleanValue() ));
            
        }
        

      }//

      public int getRowCount() 
      {

        return vector == null ? 0 : vector.size(); 

      }//

      public int getColumnCount()
      {

        return columns.length; 
      } 

     
      public String getColumnName(int column)
      { 

        return columns[column].getTitle(); 

      }//

      public boolean isCellEditable(int nRow, int nCol) 
      {

        return false;

      }//
     
      public Object getValueAt(int nRow, int nCol)
      {

        if (nRow < 0 || nRow >= getRowCount())

          return "";

        AnswerColumns row = (AnswerColumns) vector.elementAt(nRow);

        switch (nCol) {

          case 0: return row.getQuestion();

          case 1: return row.getResult();

        }

        return "";

      }//

    }

