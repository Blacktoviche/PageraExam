package pagera.view.wizard;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExamWizardPanel extends JPanel {
    private JSeparator jSeparator1 = new JSeparator();

    private JLabel jLabel1 = new JLabel();

    private JLabel jLabel2 = new JLabel();

    public JTextField jTextField1 = new JTextField();

    public JTextField jTextField2 = new JTextField();

    public JTextField jTextField3 = new JTextField();

    public JTextField jTextField4 = new JTextField();

    private JLabel jLabel3 = new JLabel();

    private JLabel jLabel4 = new JLabel();

    private JLabel jLabel5 = new JLabel();

    private JLabel jLabel6 = new JLabel();

    private JLabel jLabel7 = new JLabel();

    private JLabel jLabel8 = new JLabel();

    private JLabel jLabel9 = new JLabel();

    public JTextField jTextField5 = new JTextField();

    private JLabel jLabel10 = new JLabel();

    public JTextField jTextField6 = new JTextField();

    private JLabel jLabel11 = new JLabel();

    public JTextField jTextField7 = new JTextField();

    private JLabel jLabel12 = new JLabel();

    public JTextArea jTextArea1 = new JTextArea();
 
    private JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);

    private JSeparator jSeparator2 = new JSeparator();

    private JSeparator jSeparator3 = new JSeparator();


    public ExamWizardPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(540, 449));
        jSeparator1.setBounds(new Rectangle(0, 220, 540, 15));
        jLabel1.setText("Exam Info");
        jLabel1.setBounds(new Rectangle(200, 5, 205, 30));
        jLabel1.setFont(new Font("Tahoma", 1, 26));
        jLabel2.setText("Please fill all fields");
        jLabel2.setBounds(new Rectangle(210, 35, 145, 15));
        jLabel2.setFont(new Font("Tahoma", 0, 15));
        
        jTextArea1.setLineWrap(true);
        
        jTextField1.setBounds(new Rectangle(110, 75, 125, 25));
        jTextField2.setBounds(new Rectangle(405, 75, 115, 25));
        jTextField3.setBounds(new Rectangle(110, 140, 125, 25));
        jTextField4.setBounds(new Rectangle(405, 140, 115, 25));
        
        jLabel3.setText("Exam Name : ");
        jLabel3.setBounds(new Rectangle(5, 75, 145, 30));
        jLabel4.setText("Exam Time ( in minutes ): ");
        jLabel4.setBounds(new Rectangle(250, 75, 180, 30));
        jLabel5.setText("Questions Count : ");
        jLabel5.setBounds(new Rectangle(5, 140, 145, 30));
        jLabel6.setText("Success Exam Average : ");
        jLabel6.setBounds(new Rectangle(250, 140, 160, 30));
        
        jLabel7.setText("All These Fields above are Mandatory ");
        jLabel7.setBounds(new Rectangle(155, 175, 250, 25));
        jLabel8.setText("Exam result will be calculated  ..  ( (rigth questions count  * 100 ) / All Questions Count) ");
        jLabel8.setBounds(new Rectangle(25, 195, 540, 25));
        jLabel9.setText("Writer Info");
        jLabel9.setBounds(new Rectangle(205, 225, 170, 25));
        jLabel9.setFont(new Font("Tahoma", 1, 25));
        jTextField5.setBounds(new Rectangle(75, 280, 160, 25));
        jLabel10.setText("Name :");
        jLabel10.setBounds(new Rectangle(20, 280, 60, 25));
        jLabel10.setToolTipText("null");
        jTextField6.setBounds(new Rectangle(305, 280, 220, 25));
        jLabel11.setText("E-Mail :");
        jLabel11.setBounds(new Rectangle(255, 280, 60, 25));
        jLabel11.setToolTipText("null");
        jTextField7.setBounds(new Rectangle(115, 315, 390, 25));
        jLabel12.setText("Web Address :");
        jLabel12.setBounds(new Rectangle(20, 315, 95, 25));
        jLabel12.setToolTipText("null");
        jScrollPane1.setBounds(new Rectangle(15, 355, 510, 90));
        jScrollPane1.setBorder(BorderFactory
                               .createTitledBorder("Some Words About Questions Writer"));
        jSeparator2.setBounds(new Rectangle(210, 245, 134, 10));
        jSeparator3.setBounds(new Rectangle(205, 30, 128, 2));
        this.add(jSeparator3, null);
        this.add(jSeparator2, null);
        this.add(jScrollPane1, null);
        this.add(jLabel12, null);
        this.add(jTextField7, null);
        this.add(jLabel11, null);
        this.add(jTextField6, null);
        this.add(jLabel10, null);
        this.add(jTextField5, null);
        this.add(jLabel9, null);
        this.add(jLabel8, null);
        this.add(jLabel7, null);
        this.add(jLabel6, null);
        this.add(jLabel5, null);
        this.add(jLabel4, null);
        this.add(jLabel3, null);
        this.add(jTextField4, null);
        this.add(jTextField3, null);
        this.add(jTextField2, null);
        this.add(jTextField1, null);
        this.add(jLabel2, null);
        this.add(jLabel1, null);
        this.add(jSeparator1, null);
    }
}
