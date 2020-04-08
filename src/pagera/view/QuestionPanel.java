package pagera.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JViewport;

public class QuestionPanel extends JPanel
{


    private JTextArea jTextArea1 = new JTextArea();
    private JSeparator jSeparator1 = new JSeparator();
    private JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);
    private AnswerPanel ap = new AnswerPanel();
    private JLabel label = new JLabel();
    
    
    private JScrollPane jScrollPane2;

    private JCheckBox box = new JCheckBox("Mark");
    

    public QuestionPanel(AnswerPanel pan)
    {
      
        
        setLayout( null );
        setSize(new Dimension(590, 530));
        ap = pan;
        
        box.setBounds(300, 5, 80, 20);
        
        jScrollPane2 = new JScrollPane(pan);
        jSeparator1.setBounds(new Rectangle(5, 245, 515, 10));
        label.setBounds(new Rectangle(5, 16, 90, 10));
        jScrollPane1.setBounds(new Rectangle(5, 30, 590, 150));
        jScrollPane2.setBounds(new Rectangle(5, 180, 590, 300));
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        jTextArea1.setFont(new Font("Tahoma", 0, 15));
        jScrollPane2.setVisible(true);
        jScrollPane2.validate();
        add(jScrollPane2, null);
        add(jScrollPane1, null);
        add(jSeparator1, null);
        add(box , null);
        add(label , null);
        setVisible(true);
        validate();
        jScrollPane2.setVisible(true);
        jScrollPane2.validate();
    }
   
    public void setQuestionText(String quest) 
    {
       jTextArea1.setText(quest);
    }

    public JCheckBox getBox()
    {
        return box;
    }

    public JTextArea getJTextArea1() 
    {
        return jTextArea1;
    }

    public AnswerPanel getAnswerPanel()
    {
        return ap;
    }
    
    public void setQN(int num)
    {
       label.setText("Question : "+num); 
    }

}
