package pagera.view.wizard;

import java.awt.Dimension;

import java.awt.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QuestionWizardPanel extends JPanel {
    public JTextArea jTextArea1 = new JTextArea();
    private ButtonGroup gro = new ButtonGroup();
    
    public JRadioButton jRadioButton1 = new JRadioButton();

    public JRadioButton jRadioButton3 = new JRadioButton();


    public JLabel jLabel1 = new JLabel();

    public JLabel jLabel2 = new JLabel();

    private JLabel jLabel3 = new JLabel();
    private String answCount[] = {"2","3","4","5","6"};
    
    public JComboBox jComboBox1 = new JComboBox(answCount);

    private JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);


    public QuestionWizardPanel() {
        try {
        
            gro.add(jRadioButton1);
            gro.add(jRadioButton3);
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(540, 449));
        jTextArea1.setLineWrap(true);
        jScrollPane1.setBounds(new Rectangle(15, 75, 505, 220));
        jRadioButton1.setText("Muti Answers");
        jRadioButton1.setBounds(new Rectangle(15, 355, 140, 35));
        jRadioButton3.setText("Single Answer");
        jRadioButton3.setBounds(new Rectangle(15, 400, 140, 35));
        jLabel1.setText("Is this Question has one Answer or more ....");
        jLabel1.setBounds(new Rectangle(20, 310, 510, 30));
        jLabel2.setText("Insert the Question Text here");
        jLabel2.setBounds(new Rectangle(15, 45, 505, 30));
        jLabel3.setText("Answers Count");
        jLabel3.setBounds(new Rectangle(365, 330, 135, 25));
        jComboBox1.setBounds(new Rectangle(370, 355, 55, 25));
        this.add(jScrollPane1, null);
        this.add(jComboBox1, null);
        this.add(jLabel3, null);
        this.add(jLabel2, null);
        this.add(jLabel1, null);
        this.add(jRadioButton3, null);
        this.add(jRadioButton1, null);
    }

}
