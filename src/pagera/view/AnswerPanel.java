package pagera.view;

import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class AnswerPanel extends JPanel {
   
    private JCheckBox boxs[] ;
    private JRadioButton radios[];
    
    public AnswerPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(PageraExam.width, PageraExam.hight));

    } 
    
}
