package pagera.view;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NotePanel extends JPanel
{
    private JTextArea jTextArea1 = new JTextArea();
    private JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);
    private JLabel jLabel1 = new JLabel();
  
    
    public NotePanel()
    {
        try {
            jbInit();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception
    {
        this.setLayout( null );
        this.setSize(new Dimension(PageraExam.width, 452));
        jTextArea1.setFont(new Font("Tahoma", 0, 15));
        jTextArea1.setLineWrap(true);
        jScrollPane1.setBounds(new Rectangle(15, 70, 565, 375));
        jLabel1.setText("It should clear the idea about this question ");
        jLabel1.setBounds(new Rectangle(150, 40, 290, 30));
        this.add(jLabel1, null);
        this.add(jScrollPane1, null);
    }

    public void setJTextArea1(JTextArea jTextArea1) 
   { System.out.println("n");
        this.jTextArea1 = jTextArea1;
    }

    public JTextArea getJTextArea1() {
        return jTextArea1;
    }
}