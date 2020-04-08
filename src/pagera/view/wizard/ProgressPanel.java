package pagera.view.wizard;

import java.awt.Dimension;

import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressPanel extends JPanel {
    public JLabel jLabel1 = new JLabel();

    public JLabel question = new JLabel();

    public JLabel answer = new JLabel();

    public ExamProgress jProgressBar1 = new ExamProgress();

    public ExamProgress jProgressBar2 = new ExamProgress();

    public ProgressPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(376, 145));
        jLabel1.setText("Saving Exam.....");
        jLabel1.setBounds(new Rectangle(15, 15, 350, 20));
        question.setText("Question ");
        question.setBounds(new Rectangle(15, 90, 345, 25));
        answer.setText("Answer");
        answer.setBounds(new Rectangle(15, 50, 345, 25));
        jProgressBar1.setBounds(new Rectangle(15, 70, 345, 20));
        jProgressBar2.setBounds(new Rectangle(15, 110, 345, 20));
        this.add(jProgressBar2, null);
        this.add(jProgressBar1, null);
        this.add(answer, null);
        this.add(question, null);
        this.add(jLabel1, null);
    }
}
