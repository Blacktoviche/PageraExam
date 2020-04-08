package pagera.view;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javax.swing.JScrollPane;

import pagera.bean.Answer;

public class SingleAnswerPanel extends AnswerPanel
{
    private JRadioButton radios[];

    public SingleAnswerPanel() 
    {
      
        
        
        setLayout( null );
        setSize(new Dimension(PageraExam.width, 500));
   
    }
 
 
    public void setRadios(List<Answer> lista) 
    {
     
      ButtonGroup group = new ButtonGroup();
      radios = new JRadioButton[lista.size()];
      int high = 10;
      
      for (int i = 0 ; i < lista.size() ; i++ )
      {
         
          radios[i] = new JRadioButton(lista.get(i).getAnswer());
          radios[i].setText(lista.get(i).getAnswer());
          radios[i].validate();
          group.add(radios[i]);
          //JScrollPane scroll = new JScrollPane(radios[i]);
          radios[i].setSize(550, 70);
          //scroll.setSize(550, 40);
           
          radios[i].setBounds(new Rectangle(20, high, 550, 30));
          //scroll.setBounds(new Rectangle(20, high,550, 50));
          high+=50;
          add(radios[i] , null);
          validate();
      }

        setVisible(true);
        validate();
        
    }

    public JRadioButton[]  getRadios() 
    { 
        return radios;
    }
}
