package pagera.view.wizard;

import java.awt.Dimension;

import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class AnswerWizardPanel extends JPanel {
    public JTextArea jTextArea1 = new JTextArea();

    private JLabel jLabel1 = new JLabel();

    private JScrollPane  jScrollPane1  = new JScrollPane(jTextArea1);


    private JSeparator jSeparator1 = new JSeparator();

    public AnswerPanel jPanel1;

    private JScrollPane jScrollPane2 ;


    public AnswerWizardPanel(AnswerPanel pan)
    { 
        try {
        
         
          jPanel1 = pan;
          jScrollPane2  = new JScrollPane(pan);
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception
    {
        this.setLayout( null );
        this.setSize(new Dimension(540, 488));
        jTextArea1.setBounds(new Rectangle(15, 75, 510, 145));
        jTextArea1.setLineWrap(true);
        jLabel1.setText("Insert Note to Explain the right answer ( recommended )");
        jLabel1.setBounds(new Rectangle(15, 45, 475, 30));
        jScrollPane1.setBounds(new Rectangle(15, 75, 510, 70));
        jScrollPane1.setToolTipText("this note will help to explain the right answer");
        jSeparator1.setBounds(new Rectangle(0, 150, 540, 2));
        jPanel1.setBounds(new Rectangle(15, 160, 510, 350));
        this.add(jPanel1, null);
        this.add(jSeparator1, null);
        this.add(jScrollPane1, null);
        this.add(jLabel1, null);
        //jScrollPane2.validate();
        jPanel1.validate();
        validate();

    }
}
