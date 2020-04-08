package pagera.frames;

import java.awt.Container;
import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import pagera.logic.wizard.WizardCreater;

import pagera.view.wizard.ExamWizardPanel;
import pagera.view.wizard.QuestionWizardPanel;
import pagera.view.wizard.SouthWizardPanel;

public class WizardFram extends JFrame {
    public JPanel jPanel1 ;
    private JSeparator jSeparator1 = new JSeparator();
    public SouthWizardPanel jPanel2 = new SouthWizardPanel();
    private Container cont;
    private WizardCreater wizardCreater ;
    private ExamWizardPanel eWP ;
    public JPanel first;
    
    
    public WizardFram()
    {
       
        super("Pagera Exam v 2.0");
        cont = getContentPane();
        wizardCreater = new WizardCreater(this);
        jPanel1  = wizardCreater.getQwp();
        eWP = wizardCreater.getEWP();
        
        
        
        try {
            
            jbInit();
            
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        
    }

    private void jbInit() throws Exception
    {
        
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          Dimension frameSize = new Dimension(542, 575);
          if (frameSize.height > screenSize.height)
          {
            frameSize.height = screenSize.height;
          }
          if (frameSize.width > screenSize.width)
          {
            frameSize.width = screenSize.width;
          }
          setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        setResizable(false); 
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(542, 575));
        jSeparator1.setBounds(new Rectangle(0, 460, 540, 10));
        jPanel2.setBounds(new Rectangle(0, 465, 535, 80));
        this.getContentPane().add(eWP, null);
        this.getContentPane().add(jSeparator1, null);
        this.getContentPane().add(jPanel2, null);
        setVisible(true);
    }
    
    public void replace(JPanel pan)
    {
       
        first = jPanel1;
        cont.getComponents()[0].setVisible(false);
        cont.remove(0);
        cont.validate();
        pan.setVisible(true);
        pan.validate();
        cont.add(pan,0);
        cont.validate();
        validate();
        
    }//
    
    public void returnFirst(JPanel first)
    {
        
        cont.getComponents()[0].setVisible(false);
        cont.remove(0);
        cont.validate();
        first.setVisible(true);
        first.validate();
        cont.add(first,0);
        cont.validate();
        validate();  
        
    }//
    
    public JPanel getFirst()
    {
         return jPanel1; 
    }

    public void setEWP(ExamWizardPanel eWP) {
        this.eWP = eWP;
    }

    public ExamWizardPanel getEWP() {
        return eWP;
    }
    
    public void clear()
    {
       
       QuestionWizardPanel fir = (QuestionWizardPanel) first;
        fir.jTextArea1.setText("");
        fir.jRadioButton1.setSelected(false);
        fir.jRadioButton3.setSelected(false);
        fir.jComboBox1.setSelectedIndex(0);
    }
}
