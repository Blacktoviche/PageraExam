package pagera.view;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import pagera.bean.Answer;

public class MultiAnswerPanel extends AnswerPanel 
{

    private JCheckBox boxs[] ;
    
    public MultiAnswerPanel() 
    {
   
 
        
        setLayout( null );
        setSize(new Dimension(PageraExam.width, 500));
        
     }
   
    public void setBoxs(List<Answer> lista)
    {
        boxs = new  JCheckBox[lista.size()];
        int high = 10;
        
        for (int i = 0 ; i < lista.size() ;i++ )
         {
            
            boxs[i] = new JCheckBox(lista.get(i).getAnswer());
            boxs[i].setText(lista.get(i).getAnswer());
            boxs[i].validate();
           // JScrollPane scroll = new JScrollPane(boxs[i]);
            boxs[i].setSize(505, 40);
            //scroll.setSize(505, 40);
             
            boxs[i].setBounds(new Rectangle(20, high, 480, 30));
           // scroll.setBounds(new Rectangle(20, high, 480, 40));
             high+=40;
            add(boxs[i] , null);
            validate();
               
         }
        
    }//



    public JCheckBox[] getBoxs() 
    {
        return boxs;
    }
    
 
}//
