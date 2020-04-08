package pagera.view.wizard;

import java.awt.Dimension;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SouthWizardPanel extends JPanel {
    public JButton jButton1 = new JButton();

    public JButton jButton2 = new JButton();

    public JButton jButton3 = new JButton();


    public SouthWizardPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(539, 79));
        jButton1.setText("Build");
        jButton1.setBounds(new Rectangle(225, 30, 105, 25));
        jButton2.setText("Exit");
        jButton2.setVisible(false);
        jButton2.setBounds(new Rectangle(400, 30, 105, 25));
        jButton3.setText("<< Back");
        jButton3.setVisible(false);
        jButton3.setBounds(new Rectangle(55, 30, 95, 25));
        this.add(jButton3, null);
        this.add(jButton2, null);
        this.add(jButton1, null);
    }
}
