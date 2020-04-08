package pagera.view.wizard;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pagera.bean.Question;


public class AnswerPanel extends JPanel 
{
   
   
    
    private int high;
    private JTextArea area[];
    private JRadioButton radio[];
    
    public AnswerPanel(int si , String kin)
    {
    
    
     high = 64*si;
     
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        addArea(si);
        if(kin.equals(Question.MULTI))
        addRadioM(si);
        else
        addRadioS(si);
    }

    private void jbInit() throws Exception 
    {
        this.setLayout( null );
        this.setSize(new Dimension(537, high));

    }
    
    private void addArea(int count)
    {
        int high = 15;
        int ii = 1;
         area = new JTextArea[count];
        
        for (int i = 0 ; i < count ; i++ , ii++)
        {
            
            area[i] = new JTextArea();
            area[i].setLineWrap(true);
            JScrollPane scroll = new JScrollPane(area[i]);
            area[i].setSize(415, 40);
            scroll.setSize(415, 40);
            
            area[i].setBounds(new Rectangle(10, high , 415, 40));
            scroll.setBounds(new Rectangle(10, high , 415, 40));
            area[i].setBorder(BorderFactory.createTitledBorder("Answer  "+ii));
            high+=45;
            add(scroll,null); 
           
        }
    }//
    
    private void addRadioS(int count)
    {
       
        radio = new JRadioButton[count];
        int high = 25;
        ButtonGroup group = new ButtonGroup();
        
        for (int i = 0 ; i < count ; i++ )
        {
           
            radio[i] = new JRadioButton("Right");
            radio[i].setSize(80,24);
            radio[i].setBounds(new Rectangle(445, high, 100, 24));
            high+=45;
            group.add(radio[i]);
            add(radio[i],null);  
           
        }
        
    }//
    
     private void addRadioM(int count)
     {
         int high = 25;
         radio = new JRadioButton[count];
         for (int i = 0 ; i < count ; i++ )
         {
            
             radio[i] = new JRadioButton("is Right");
             radio[i].setSize(80,24);
             radio[i].setBounds(new Rectangle(445, high, 1000, 24));
             high+=45;
             add(radio[i],null);  
            
         }
         
     }//
     
     public JTextArea[] getAreas()
     {   
        return area;    
     }//
     
      public JRadioButton[] getRadios()
      {   
         return radio;    
      }//
}
