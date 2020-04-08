package pagera.logic.wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import javax.swing.JTextArea;

import pagera.bean.Answer;
import pagera.bean.Exam;
import pagera.bean.Question;

import pagera.bean.Writer;

import pagera.dao.XMLWriter;

import pagera.frames.WizardFram;

import pagera.view.wizard.AnswerPanel;
import pagera.view.wizard.AnswerWizardPanel;
import pagera.view.wizard.ExamWizardPanel;
import pagera.view.wizard.QuestionWizardPanel;

public class WizardCreater implements ActionListener
{
  
    private QuestionWizardPanel qwp = new QuestionWizardPanel();
    private ExamWizardPanel eWP = new ExamWizardPanel(); 
    private Writer writer = new Writer();
    private List<Question> questionsList = new LinkedList<Question>();
    private WizardFram frame;
    private Exam currentExam = new Exam();
    private Question question;
    private AnswerWizardPanel wp;
    private List<Answer> answers ;
    private String mode ;
    private String quest;
    private String note;
    private XMLWriter examStore;
    private int  questionsCount;
    
    public WizardCreater(WizardFram fr)
    {
    
      frame = fr;
      addAction();
      frame.jPanel2.jButton3.setEnabled(false);
      question = new Question();
      
    }//
    
    public void actionPerformed(ActionEvent event)
    {
        
     if(event.getSource() == frame.jPanel2.jButton2)
        {
        
          if(frame.jPanel2.jButton2.getText().equals("Save Exam"))
            saveExam();
        
        
        else{
            
            int res = JOptionPane.showConfirmDialog(null, 
                         "Are you sure you want to exit", "Exam will not be saved",
                          JOptionPane.YES_NO_OPTION , JOptionPane.WARNING_MESSAGE);
            if(res == JOptionPane.NO_OPTION)
             return;
            
            
            System.exit(0); 
        }
        
        }
        
     if(event.getSource() == frame.jPanel2.jButton1)
     {
        
         if(frame.jPanel2.jButton1.getText().equals("Save"))
            {
            saveQ();
            frame.clear();
            return;
            }
         if(frame.jPanel2.jButton1.getText().equals("Next >>"))
            {
            checkAndFill();
            return;
            }
                 
         if(frame.jPanel2.jButton1.getText().equals("Build"))
         { 
          
         if(checkExamInfo())
            {
            
             frame.getContentPane().getComponents()[0].setVisible(false);
             frame.getContentPane().remove(0);
             frame.getContentPane().validate();
             frame.jPanel1.setVisible(true);
             frame.jPanel1.validate();
             frame.getContentPane().add(frame.jPanel1,0);
             frame.getContentPane().validate();
             frame.validate();
             frame.jPanel2.jButton1.setText("Next >>");
             frame.jPanel2.jButton2.setVisible(true);
             frame.jPanel2.jButton3.setVisible(true);
          
            
            }
          }//
        
     }//
        
       if(event.getSource() == frame.jPanel2.jButton3)
          returnTo();
        
        
    }//
    
    
    private void saveExam()
    {
      examStore = new XMLWriter(currentExam);
      examStore.start();
      
    }////////////

    
    public AnswerWizardPanel getAnswersPanel(int answersCount , String kind)
    {
        
       if(kind.equals(Question.MULTI))
          return createMultiPanel(answersCount);
          
          
       else
          return createSinglePanel(answersCount);
        
    }//
    

     private AnswerWizardPanel createMultiPanel(int cou)
     {
      
         AnswerPanel ap = new AnswerPanel(cou, Question.MULTI);
         AnswerWizardPanel awp = new AnswerWizardPanel(ap);
         awp.validate();
         
         return awp;
         
     }//
     
     private void addAction()
     {
         
         frame.jPanel2.jButton1.addActionListener(this);
         frame.jPanel2.jButton2.addActionListener(this);
         frame.jPanel2.jButton3.addActionListener(this);    
         
     }//
     
     
     private AnswerWizardPanel createSinglePanel(int cou)
     {
         
         AnswerPanel ap = new AnswerPanel(cou, Question.SINGLE);
         AnswerWizardPanel awp = new AnswerWizardPanel(ap);
         awp.validate();
         
         return awp;
         
     }//
     
     
     private void checkAndFill()
     {
    
          
         int count = 0;
        qwp = (QuestionWizardPanel) frame.getFirst();
        
        if(qwp.jTextArea1.getText().trim().equals(""))
         {
          JOptionPane.showMessageDialog(null,"Where is the Question");
         return;
         }
         
         if(!qwp.jRadioButton1.isSelected() && !qwp.jRadioButton3.isSelected())
         {
             JOptionPane.showMessageDialog(null,"Please select Answers Kind");  
             return;
         }
  
             
            count = 2+qwp.jComboBox1.getSelectedIndex(); 
       
       
       if(qwp.jRadioButton3.isSelected())
        {
        wp = createSinglePanel(count);
        }
        
        else
        {
        wp = createMultiPanel(count);
        }
         
        if(qwp.jRadioButton1.isSelected())
           mode = Question.MULTI;
        else
           mode = Question.SINGLE;
           
        quest = qwp.jTextArea1.getText();
    
        
       wp.setVisible(true);
       frame.replace(wp);  
       frame.validate();
       frame.jPanel2.jButton1.setText("Save");
       frame.jPanel2.jButton3.setEnabled(true);
       
     }//

    private void returnTo()
    {
        
        frame.first.setVisible(true);
        frame.returnFirst(frame.first);
        frame.validate(); 
        frame.jPanel2.jButton1.setText("Next >>");
        frame.jPanel2.jButton3.setEnabled(false);
        
     }//
    
    private void saveQ()
    {
        
        if(!buildQuestion())
         {
          
           return;
         
         }  
    else{
          
           question.setMode(mode);
           question.setQuestion(quest);
           question.setNote(note);
            
           questionsList.add(question);
           
        if(questionsCount > questionsList.size())
           returnTo();
           
        if(questionsCount == questionsList.size())
           {
           frame.jPanel2.jButton1.setVisible(false);
           frame.jPanel2.jButton2.setText("Save Exam");
           currentExam.setQuestionsList(questionsList);
           JOptionPane.showMessageDialog(null,"you have finished your questions click exit to be saved");
           
            return;
           }
           
           returnTo();
       }
        
    }/////////
    
    private boolean buildQuestion()
    {
       
     answers = new LinkedList<Answer>();
        
     AnswerWizardPanel awp  = (AnswerWizardPanel)  frame.getContentPane().getComponents()[0];
     AnswerPanel ap = awp.jPanel1;
     
     if(!checkArea(ap.getAreas() , answers))
       {
       JOptionPane.showMessageDialog(null , "Pleas Fill All Area With Answers" ,
         "Missing Text" ,JOptionPane.ERROR_MESSAGE);
      
       return false;  
     }
         
      if(!checkRadio(ap.getRadios() , answers))
        {
          JOptionPane.showMessageDialog(null , "          Please  Select  Right Answer \n"+
          "If your question has multi Answers you must select more than one answer" ,
            "Missing Text" ,JOptionPane.ERROR_MESSAGE);
         
          return false;  
        }  
        
     question = new Question();
     question.setAnswers(answers);
     note = awp.jTextArea1.getText();

     
      return true;
    }//
    
    private boolean checkRadio(JRadioButton[] radios , List<Answer> answ)
    {
        int count = 0;
        
        for (int i = 0 ; i < radios.length ; i++ )
        {
        
          if(radios[i].isSelected())
          {
            answ.get(i).setState(true);
            count++;
          }
            
        }
        
      if(count == 0)
       return false;
       
      if(mode.equals(Question.MULTI) && count <= 1)
       return false;
          
       
     return true;  
        
    }//
    
    private boolean checkExamInfo()
    {
       
    try{
    
      
      
      String examName =  eWP.jTextField1.getText();
      int  examTime = Integer.parseInt(eWP.jTextField2.getText());
      questionsCount = Integer.parseInt(eWP.jTextField3.getText());
      int  examAvreage = Integer.parseInt(eWP.jTextField4.getText());
      
      
      
      if(examName.trim().equals("") || !checkExamName(examName)) 
      {
         JOptionPane.showMessageDialog(null,"Please Change Exam Name",
         "Empty Name Or Name Exist Befor",
         JOptionPane.ERROR_MESSAGE);  
          return false;   
       }
           
           currentExam.setName(examName);
           currentExam.setTime(examTime);
           currentExam.setQuestionsCount(questionsCount);
           currentExam.setAverage(examAvreage);
           
           writer.setName(eWP.jTextField5.getText());
           writer.setMail(eWP.jTextField6.getText());
           writer.setWebAddress(eWP.jTextField7.getText());
           writer.setDescription(eWP.jTextArea1.getText());
           
           currentExam.setWriter(writer);
           
            
       } 
        catch(NumberFormatException nf)
        {
          JOptionPane.showMessageDialog(null,"Please Insert Number Not Character In Fields ( Time , Count , Average )",
          "Check Numbers Fields",
          JOptionPane.ERROR_MESSAGE);  
          return false;
        }
        
        
        return true;
        
    }///////////
    
    
    private boolean checkExamName(String examName)
    {
        
        File xmlFiles = new File("Exams");
        
        for(int i = 0; i < xmlFiles.list().length; i++)
        {
            
            if(xmlFiles.list()[i].equals(examName+".xml"))
             return false;
            
        }
        
        return true;
        
    }////////////
    
    private boolean checkArea(JTextArea[] areas , List<Answer> ans)
    {
        
        
        Answer[] answ = new Answer[areas.length];
        
        for (int i = 0 ; i < areas.length ; i++ )
        {
         
          if(areas[i].getText().trim().equals(""))
            return false;
         
          answ[i] = new Answer();
            
          answ[i].setAnswer(areas[i].getText());
          ans.add(answ[i]);
          
        }
        
        return true;
        
    }//

    public void setQwp(QuestionWizardPanel qwp)
    {
        this.qwp = qwp;
    }

    public QuestionWizardPanel getQwp()
    {
        return qwp;
    }

    public void setEWP(ExamWizardPanel eWP) {
        this.eWP = eWP;
    }

    public ExamWizardPanel getEWP() {
        return eWP;
    }
}
