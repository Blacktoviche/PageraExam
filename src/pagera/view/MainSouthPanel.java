package pagera.view;

import java.awt.Dimension;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class MainSouthPanel extends JPanel {
    public JComboBox jComboBox1 ;
    private JSeparator jSeparator1 = new JSeparator();
    private JLabel jLabel1 = new JLabel();
    public JButton jButton1 = new JButton();


    public MainSouthPanel(String[] exFold)
    {
    
        jComboBox1 = new JComboBox(exFold);
      
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(600, 160));
        jComboBox1.setBounds(new Rectangle(190, 35, 160, 30));
        jSeparator1.setBounds(new Rectangle(160, 25, 220, 10));
        jLabel1.setText("Choose Exam");
        jLabel1.setBounds(new Rectangle(240, 5, 105, 25));
        jButton1.setText("Create Questions");
        jButton1.setBounds(new Rectangle(205, 100, 140, 25));
        jButton1.setToolTipText("you can create your own exam");
        this.add(jButton1, null);
        this.add(jLabel1, null);
        this.add(jSeparator1, null);
        this.add(jComboBox1, null);
    }
}
