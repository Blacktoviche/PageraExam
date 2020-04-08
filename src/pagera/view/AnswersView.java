package pagera.view;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import javax.swing.JTextArea;

import pagera.bean.Answer;

public class AnswersView extends JPanel
{
    
    private JCheckBox boxs[] ;
    private JRadioButton radios[];

    private JButton jButton1 = new JButton();
    private JTextArea area[];
    
    public AnswersView(AnswerPanel answePanel)
    {
    
       if(answePanel instanceof MultiAnswerPanel)
           setBoxs(  ((MultiAnswerPanel)answePanel).getBoxs()  );
    
        if(answePanel instanceof SingleAnswerPanel)
            setRadios(  ((SingleAnswerPanel)answePanel).getRadios()  );
            
       setLayout( null );
       setSize(new Dimension(580, 530));
        jButton1.setText("Close");
        jButton1.setBounds(new Rectangle(230, 490, 110, 25));
        this.add(jButton1, null);
    }

    private void setBoxs(JCheckBox boxx[])
    {
        int high = 15;
        
        area = new JTextArea[boxx.length];
        
        for (int i = 0 ; i < boxx.length ; i++ )
        {
           
           area[i] = new JTextArea(boxx[i].getText());
            area[i].setLineWrap(true);
            area[i].setFont(new Font("Tahoma", 0, 15));
           JScrollPane scroll = new JScrollPane(area[i]);
           area[i].setSize(560, 60);
           scroll.setSize(560, 60);
           
           area[i].setBounds(new Rectangle(10, high , 560, 60));
           scroll.setBounds(new Rectangle(10, high , 560, 60));
           
           high+=65;
           add(scroll,null); 
          
        }

        setVisible(true);
        validate();
         
    }
         
    private void setRadios(JRadioButton radiox[]) 
    {
         int high = 15;
        
         area = new JTextArea[radiox.length];
        
        for (int i = 0 ; i < radiox.length ; i++ )
        {
            
            area[i] = new JTextArea(radiox[i].getText());
            area[i].setLineWrap(true);
            area[i].setFont(new Font("Tahoma", 0, 15));
            JScrollPane scroll = new JScrollPane(area[i]);
            area[i].setSize(415, 60);
            scroll.setSize(415, 60);
            
            area[i].setBounds(new Rectangle(10, high , 560, 60));
            scroll.setBounds(new Rectangle(10, high , 560, 60));
            
            high+=65;
            add(scroll,null); 
           
        }

        setVisible(true);
        validate();
        
    }
    
    private String devideString(String ans)
    {
        int nin = 70;
        StringBuffer buff = new StringBuffer();
        char[] ansew = ans.toCharArray();
        
        for(int i = 0; i < ans.length() ; i++)
        {
           buff.append(ansew);
           
           if(i == nin)
           {
             buff.append("\n");
             nin*=2;
           }  
         
          
        }
          
        return buff.toString();
        
    }//

     private void addArea(int count)
     {
         int high = 15;
         
          area = new JTextArea[count];
         
         for (int i = 0 ; i < count ; i++ )
         {
             
             area[i] = new JTextArea();
             area[i].setLineWrap(true);
             JScrollPane scroll = new JScrollPane(area[i]);
             area[i].setSize(415, 40);
             scroll.setSize(415, 40);
             
             area[i].setBounds(new Rectangle(10, high , 415, 40));
             scroll.setBounds(new Rectangle(10, high , 415, 40));
             
             high+=45;
             add(scroll,null); 
            
         }
     }//
    public JButton getJButton1() {
        return jButton1;
    }
}
