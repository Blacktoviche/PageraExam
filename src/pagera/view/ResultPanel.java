package pagera.view;

import java.awt.Dimension;

import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ResultPanel extends JPanel 
{

    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JScrollPane jScrollPane1 ;
    private JProgressBar jProgressBar1 ;
    
    public ResultPanel(JTable table , ResultProgress progress)
    {
       
       
        try {
        
           jScrollPane1 = new JScrollPane(table);   
            jProgressBar1 = progress.getJpb();
            jbInit(table);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

        private void jbInit(JTable jTable1) throws Exception 
        {
        
        this.setLayout( null );
        this.setSize(new Dimension(PageraExam.width, 452));
        jProgressBar1.setBounds(new Rectangle(115, 70, 385, 35));
        jLabel1.setText(" ");
        jLabel1.setBounds(new Rectangle(10, 10, 599, 30));
        jLabel2.setBounds(new Rectangle(130, 40, 400, 30));
        jLabel3.setText("Click on the question number which you want to go to");
        jLabel3.setBounds(160, 100, 400, 30);
        jScrollPane1.setBounds(new Rectangle(5, 135, 580, 300));
        this.add(jProgressBar1, null);
        this.add(jLabel1, null);
        this.add(jLabel2, null);
        this.add(jLabel3, null);
        this.add(jScrollPane1, null);
        

    }

    public void setReportText(int i , int u , int h) 
    {
      
      String status = (h >= PageraExam.examAverage) ? "Pass" : "Failed";
      
      jLabel1.setText("There are "+i+" Questions in this exam.You answered "+
      u+" Questions correctly which gives you a score of "+h+"%");
      
      jLabel2.setText("PASSING SCORE :  "+PageraExam.examAverage+"%   YOUR SCORE :  "+h+"   TEST STATUS: " +status);
      
    }

  
}
