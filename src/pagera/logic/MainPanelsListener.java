package pagera.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import javax.swing.JMenuItem;

import javax.swing.JOptionPane;

import pagera.dao.ValidatingExamFile;

import pagera.frames.ExamFrame;

import pagera.frames.MainFrame;
import pagera.frames.MakeQuestionHelp;
import pagera.frames.MeFrame;
import pagera.frames.PEFrame;
import pagera.frames.WizardFram;

import pagera.view.MainNorthPanel;
import pagera.view.MainSouthPanel;

public class MainPanelsListener implements ActionListener
{
    
    private MainSouthPanel msp ;
    private MainNorthPanel mnp = new MainNorthPanel();
    private String emptyExams[] = {"There is no Exam "}; 
    private int state = 0;
    private MainFrame frame;
    private List<JMenuItem> items = new LinkedList<JMenuItem>();
    private String choose = "--------Select Exam--------";
    private ValidatingExamFile validateExam = new ValidatingExamFile();
    
    
    public MainPanelsListener(MainFrame fr) 
    {
    
         frame = fr;
     
        msp = new MainSouthPanel(getExams());
           
      
        
        msp.jButton1.addActionListener(this);
        msp.jComboBox1.addActionListener(this);
        frame.getQuesHelp().addActionListener(this);
        frame.getMe().addActionListener(this);
        frame.getPe().addActionListener(this);
        
        frame.getCreateQuestions().addActionListener(this);
        
        fillExamMenu(getExams());
    
    }
    public void actionPerformed(ActionEvent event)
    {
        
        if(event.getSource() == msp.jComboBox1) 
        {
           if(state == 0)
           {
            if(msp.jComboBox1.getSelectedIndex() == 0)
              return;
             createExam(msp.jComboBox1.getSelectedItem().toString()); 
             return;
             
           }
        }
        
        if(event.getSource() == msp.jButton1)
        {
            WizardFram wizardFram = new WizardFram();
            wizardFram.setDefaultCloseOperation(wizardFram.EXIT_ON_CLOSE);
            frame.setVisible(false);
            frame = null;
            return;
        }
        
        if(event.getSource() == frame.getCreateQuestions())
        { 
            WizardFram wizardFram = new WizardFram();
            wizardFram.setDefaultCloseOperation(wizardFram.EXIT_ON_CLOSE);
            frame.setVisible(false);
            frame = null;
            return;
        }
        
        if(event.getSource() == frame.getQuesHelp())
        { 
            MakeQuestionHelp mqh = new MakeQuestionHelp();
            return;
        }
        
        if(event.getSource() == frame.getMe())
        { 
            MeFrame mf = new MeFrame();
            return;
        }
        
        if(event.getSource() == frame.getPe())
        { 
            PEFrame mf = new PEFrame();
            return;
        }
        
        if(event.getSource() instanceof JMenuItem)
        {
            
          if( ((JMenuItem)event.getSource()).getText().equals(choose))
          return;
          
          checkItems(event);
          
        }
        
    }//
    
    private String[] getExams()
    {
     
     try{
     
       File exams = new File("Exams");
       
  
       String[] comb = new String[1+exams.list().length];
       comb[0] = choose;
       
       if(exams.list().length > 0)
       {
          for (int i = 0 ; i < exams.list().length ;i++ )
          {
              
              comb[++i] = exams.list()[--i];
              
          }
          
             return comb;
       }
       
       else{
           state = 1;
           return emptyExams;
       }
       
        }
        catch(Exception ex)
        {
     JOptionPane.showMessageDialog(null , 
    "The Folder Exams is not exist the program will terminate" ,
    "Exams not fount" ,JOptionPane.ERROR_MESSAGE);
        System.exit(0);
        }
        
        return null;
    }//
    
    
    private void createExam(String examName)
    {
        
        /*
         * Validating XML Exam File
         */
        if(validateExam.isValide(examName))
         {
        ExamFrame examFrame = new ExamFrame(examName);
        examFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);
        frame = null;
         }
         
         else {
             
             JOptionPane.showMessageDialog(null,
             "Exam File "+examName+" is not Valide Read the Error Message\n" +
             "                "+validateExam.getErrorMessage(),"Fatal Error",
             JOptionPane.ERROR_MESSAGE);
             
         }
        
    }//

    public void setMsp(MainSouthPanel msp) {
        this.msp = msp;
    }

    public MainSouthPanel getMsp() {
        return msp;
    }

    public void setMnp(MainNorthPanel mnp) {
        this.mnp = mnp;
    }

    public MainNorthPanel getMnp() {
        return mnp;
    }
    
    private void fillExamMenu(String ites[])
    {
        
        for (int i = 0 ; i < ites.length ; i++ )
        {  
           
           JMenuItem exa = new JMenuItem(ites[i]);
           exa.addActionListener(this);
           frame.exam.add(exa);
           items.add(exa);
            
        }
          
    }//
    
    private void checkItems(ActionEvent even)
    {
        
        for (int i = 0 ; i < items.size() ; i++ )
        {  
       
          if(even.getSource() == items.get(i))
           {
             createExam(items.get(i).getText());
             return;
           }
            
        }  
    }//
    
}//
