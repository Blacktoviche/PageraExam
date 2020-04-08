package pagera.view;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WriterPanel extends JPanel {
    public JTextField jTextField1 = new JTextField();

    public JTextField jTextField2 = new JTextField();

    public JTextField jTextField3 = new JTextField();

    public JTextArea jTextArea1 = new JTextArea();

    public JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);

    private JLabel jLabel1 = new JLabel();

    private JLabel jLabel2 = new JLabel();

    private JLabel jLabel3 = new JLabel();

    private JLabel jLabel4 = new JLabel();

    public JButton jButton1 = new JButton();


    public WriterPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(505, 458));
        jTextArea1.setFont(new Font("Tahoma", 0, 15));
        jTextArea1.setLineWrap(true);
        jTextField1.setBounds(new Rectangle(135, 50, 250, 30));
        jTextField2.setBounds(new Rectangle(135, 95, 250, 30));
        jTextField3.setBounds(new Rectangle(135, 140, 250, 30));
        jScrollPane1.setBounds(new Rectangle(5, 200, 495, 225));
        jScrollPane1.setBorder(BorderFactory
                               .createTitledBorder("Information about Writer"));
        jLabel1.setText("Personal Information");
        jLabel1.setBounds(new Rectangle(145, 5, 240, 40));
        jLabel1.setFont(new Font("Tahoma", 0, 21));
        jLabel2.setText("Name :");
        jLabel2.setBounds(new Rectangle(45, 50, 90, 30));
        jLabel3.setText("E-Mail :");
        jLabel3.setBounds(new Rectangle(45, 95, 90, 30));
        jLabel4.setText("Website :");
        jLabel4.setBounds(new Rectangle(45, 140, 90, 30));
        jButton1.setText("Save");
        jButton1.setBounds(new Rectangle(205, 430, 100, 25));
        jButton1.setToolTipText("save this file in the Exam Folder");
        this.add(jButton1, null);
        this.add(jLabel4, null);
        this.add(jLabel3, null);
        this.add(jLabel2, null);
        this.add(jLabel1, null);
        this.add(jScrollPane1, null);
        this.add(jTextField3, null);
        this.add(jTextField2, null);
        this.add(jTextField1, null);
    }
}
