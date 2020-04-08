package pagera.view;

import java.awt.Dimension;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;

public class MainPanel extends JPanel {
    public JButton jButton1 = new JButton();

    public JButton jButton2 = new JButton();

    public JButton jButton3 = new JButton();

    public JButton jButton4 = new JButton();

    public JButton jButton5 = new JButton();

    public JButton jButton6 = new JButton();

    public JButton jButton7 = new JButton();

    private JSeparator jSeparator1 = new JSeparator();

    public JButton question = new JButton();

    public JButton answers = new JButton();

    public JProgressBar jProgressBar1 = new JProgressBar();


    public MainPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(594, 154));
        jButton1.setText("Next >>");
        jButton1.setBounds(new Rectangle(330, 115, 125, 25));
        jButton2.setText("<< Previous");
        jButton2.setBounds(new Rectangle(165, 115, 115, 25));
        jButton3.setText("Result");
        jButton3.setBounds(new Rectangle(15, 115, 100, 25));
        jButton4.setText("Finish");
        jButton4.setBounds(new Rectangle(490, 115, 90, 25));
        jButton5.setText("Ansewr Explain");
        jButton5.setBounds(new Rectangle(230, 75, 150, 25));
        jButton6.setText("Close Note");
        jButton6.setBounds(new Rectangle(255, 45, 105, 20));
        jButton7.setText("Mark");
        jButton7.setBounds(new Rectangle(275, 45, 70, 20));
        jSeparator1.setBounds(new Rectangle(0, 30, 595, 15));
        question.setText("Question");
        question.setBounds(new Rectangle(15, 45, 90, 20));
        answers.setText("Answers");
        answers.setBounds(new Rectangle(490, 45, 90, 20));
        jProgressBar1.setBounds(new Rectangle(15, 95, 100, 15));
        PageraExam.time.setBounds(new Rectangle(15, 75, 100, 30));
        this.add(PageraExam.time, null);
        this.add(jProgressBar1, null);
        this.add(answers, null);
        this.add(question, null);
        this.add(jSeparator1, null);
        this.add(jButton7, null);
        this.add(jButton6, null);
        this.add(jButton5, null);
        this.add(jButton4, null);
        this.add(jButton3, null);
        this.add(jButton2, null);
        this.add(jButton1, null);
        PageraExam.timeProgress = jProgressBar1;
    }
}
