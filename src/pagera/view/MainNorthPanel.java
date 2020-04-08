package pagera.view;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class MainNorthPanel extends JPanel {


    private JLabel jLabel2 ;
    private PageraExam pel = new PageraExam();
    
    public MainNorthPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel2 = new JLabel(pel.getLogo());
        this.setLayout( null );
        this.setSize(new Dimension(600, 400));
        jLabel2.setBounds(new Rectangle(5, 10, 514, 100));
        this.add(jLabel2, null);
    }
}
