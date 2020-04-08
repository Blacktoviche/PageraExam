package pagera.view;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class QuestionView extends JPanel {
    private JTextArea jTextArea1 = new JTextArea();

    private JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);

    private JButton jButton1 = new JButton();

    public QuestionView(JTextArea area)
    {
        try {
        
            jTextArea1.setText(area.getText());
            jTextArea1.setLineWrap(true);
            jTextArea1.setFont(new Font("Tahoma", 0, 15));
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(580, 530));
        jScrollPane1.setBounds(new Rectangle(5, 5, 565, 490));
        jButton1.setText("Close");
        jButton1.setBounds(new Rectangle(240, 505, 100, 20));
        this.add(jButton1, null);
        this.add(jScrollPane1, null);
    }

    public JButton getJButton1()
    {
        return jButton1;
    }
}
