package pagera.logic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTable;


import pagera.bean.Exam;
import pagera.bean.Question;

import pagera.dao.XMLReader;

import pagera.frames.ExamFrame;

import pagera.logic.tables.AnswersTable;
import pagera.logic.tables.MarkTable;

import pagera.frames.AnsQueFrame;

import pagera.view.AnswersView;
import pagera.view.MainPanel;
import pagera.view.MarkPanel;
import pagera.view.MultiAnswerPanel;
import pagera.view.NotePanel;
import pagera.view.PageraExam;
import pagera.view.QuestionPanel;
import pagera.view.QuestionView;
import pagera.view.ResultPanel;
import pagera.view.ResultProgress;

public class Collector implements ActionListener 
{
    
    
    private List<QuestionPanel> panelsList = new LinkedList<QuestionPanel>();
    private List<Question> questionsList = new LinkedList<Question>();
    private QuestionPanelCreater questionPanelCreater = 
    new QuestionPanelCreater();
    private MainPanel mainPanel;
    public static int  currentPanel = 0;
    private ExamFrame frame;
    private JTable resuTable ; 
    private JTable markTable;
    
    private ResultPanel results;
    private MarkPanel marks;
    private ResultProgress progress;
    private AnsQueFrame ansqueFrame;
    private AnswersView ansView;
    private QuestionView queView;
    private Clock clo;
    private XMLReader xmlReader;
    
    
    public Collector(ExamFrame fr , String fEx)
    {
    
       frame = fr; 
      
       
       /*
        * this is the old way 
        * to create exam by reading Serializable Files
        * each File was acting one question
        * 
        * createSerializ(fEx);
        * 
        * */
        
       /*
        * The new Way
        */
       createExamFromXML(fEx);
       
       mainPanel = new MainPanel();
       addAction();
       mainPanel.jButton2.setEnabled(false);
       mainPanel.jButton3.setEnabled(false);
       mainPanel.jButton5.setVisible(false);
       mainPanel.jButton6.setVisible(false);
      
      
       if(panelsList.size()==1)
           mainPanel.jButton1.setEnabled(false);
        
        clo = new Clock();  
        clo.start();
     
    }//
    
    public void actionPerformed(ActionEvent event)
    {
        
        if(event.getSource() == mainPanel.jButton1)
        {
            next();
        }
        
        if(event.getSource() == mainPanel.jButton2)
        {
            previous(); 
        }
        if(event.getSource() == mainPanel.jButton4)
        {
           if(mainPanel.jButton4.getText().equals("Exit"))
             System.exit(0);
            
            else{
                int res = JOptionPane.showConfirmDialog(null, 
                             "Are you sure you want to exit", "------------",
                              JOptionPane.YES_NO_OPTION , JOptionPane.WARNING_MESSAGE);
                if(res == JOptionPane.NO_OPTION)
                 return;
                
                 
            }
              
            finish(); 
        }
       
        if(event.getSource() == mainPanel.jButton3)
        {
            showResultPanel();
            
        }
        if(event.getSource() == mainPanel.jButton5)
        {
            mainPanel.jButton7.setVisible(false);
            showNotePanel();    
        }
        if(event.getSource() == mainPanel.jButton6)
        {
            mainPanel.jButton7.setVisible(true);
            closeNotePanel();
        }
        
        if(event.getSource() == mainPanel.jButton7)
        {
            showMarkPanel();
        }
   
        if(event.getSource() == mainPanel.question)
        {
            showQuestionPanel();
        }
        
        if(event.getSource() == mainPanel.answers)
        {
            showAnswersPanel();
        }
        
    }//
    
    private void createPanels(Question q , int num)
    {
     
     panelsList.add(questionPanelCreater.getQPanel(q , num ) );
 
        
    }//

 
     private void createExamFromXML(String examName)
     {
         
       xmlReader  = new XMLReader(examName);
       Exam currentExam = xmlReader.getExam();
       PageraExam.examAverage = currentExam.getAverage();
       PageraExam.examTime = currentExam.getTime();
         
       PageraExam.writer = currentExam.getWriter();
       
       questionsList = currentExam.getQuestionsList();
         
        Collections.shuffle(questionsList);
         for (int i = 0 ; i < questionsList.size() ; i++ )
         {
         
             createPanels(questionsList.get(i) , i);
                    
         }
         
         
     }////

    /* this method for reading from Serializable Files ( Old Way )
      private void createSerializ(String folderName)
      {
          
          questionsList = questionCreater.getQuestions(folderName);
          
          Collections.shuffle(questionsList);
          
          for (int i = 0 ; i < questionsList.size() ; i++ )
          {
          
              createPanels(questionsList.get(i) , i);
                     
          }
          
      }//
      
      */
      
    /*  //this method for reading from database ( The Oldest Way )
      private void createData()
      {
        
       for (int i = 1 ;i < 4 ;i++ )
       {  
            
         Question q = dataQuestionCreater.createQuestion(i);
      
         Question ne = new Question();
         ne.setQuestion(q.getQuestion());
         ne.setAnswers(q.getAnswers());
         ne.setState(q.getState());
         ne.setNote(q.getNote());
 
         questionsList.add(ne);
         createPanels(q);   
         
       }
     }//
    */
    
     private void next()
     {
         if(currentPanel == panelsList.size()-2)
             mainPanel.jButton1.setEnabled(false);
             
         if(!mainPanel.jButton2.isEnabled())
         {
             mainPanel.jButton2.setEnabled(true);    
         }   
         int j = ++currentPanel;
         panelsList.get(currentPanel).setVisible(true);
         frame.replace(panelsList.get(currentPanel) , --j );
         frame.validate();
         
     }//
     
      
      private void previous()
      {
         if(!mainPanel.jButton1.isEnabled())
         {
             mainPanel.jButton1.setEnabled(true);    
         }
          
         if(currentPanel == 1)
           { 
           mainPanel.jButton2.setEnabled(false);
      
           }  
          int j = --currentPanel;
          panelsList.get(currentPanel).setVisible(true);
          frame.replace(panelsList.get(currentPanel) , ++j );
          frame.validate();
          
          
      }//
      
      
    private void addAction()
    {
        mainPanel.jButton1.addActionListener(this);
        mainPanel.jButton2.addActionListener(this);
        mainPanel.jButton3.addActionListener(this);
        mainPanel.jButton4.addActionListener(this);
        mainPanel.jButton5.addActionListener(this);
        mainPanel.jButton6.addActionListener(this);
        mainPanel.jButton7.addActionListener(this);
        mainPanel.answers.addActionListener(this);
        mainPanel.question.addActionListener(this);
    }//

    
    
    public void setMainPanel(MainPanel mainPanel)
    {
        this.mainPanel = mainPanel;
    }

    public MainPanel getMainPanel()
    {
        return mainPanel;
    }
    
    public List<QuestionPanel> getPanels()
    {
         return panelsList;
    }
    
    
    private void finish()
    {

        mainPanel.jButton7.setVisible(false);
        int resu = 0;
        mainPanel.jButton1.setEnabled(false);
        mainPanel.jButton2.setEnabled(false);
        mainPanel.question.setVisible(false);
        mainPanel.answers.setVisible(false);

        
        Calculator c = new Calculator(questionsList);
        c.extractAnswers(panelsList);
        
        AnswersTable anta = new AnswersTable(c.getFinalResult());
        resuTable = anta.getTable();
        addResultTableListener();
        resu = ( ( c.getRate() *  100 )/ panelsList.size() );
        progress = new ResultProgress(resu);
        results = new ResultPanel(resuTable , progress);
        results.setReportText(panelsList.size() ,  c.getRate() , resu);
        results.setVisible(true);
        frame.finish(results);
        frame.validate();
        progress.runProgress();
        mainPanel.jButton4.setText("Exit");
        
    }//
    
    private void addResultTableListener()
    {
        
        resuTable.addMouseListener(new MouseAdapter() {

          public void mouseReleased(MouseEvent e)
          {
            int row = resuTable.getSelectedRow();
            int column = resuTable.getSelectedColumn();
              int u = 0;

            if (row == -1 || column == -1)

              return; 

            else
            {
           u = row;   
                mainPanel.jButton1.setEnabled(true);
                mainPanel.jButton2.setEnabled(true);
                mainPanel.jButton3.setEnabled(true);
                mainPanel.jButton5.setVisible(true);
                mainPanel.question.setVisible(true);
                mainPanel.answers.setVisible(true);
                
            if(u  == 0)
             mainPanel.jButton2.setEnabled(false);
             
            if(++u == panelsList.size())
             mainPanel.jButton1.setEnabled(false);
             
            currentPanel = row;
            panelsList.get(row).setVisible(true);
            frame.finish(panelsList.get(row));
            frame.validate();

            }
          }

        });
        
    }//

     private void addMarkTableListener()
     {
         
         markTable.addMouseListener(new MouseAdapter() {

           public void mouseReleased(MouseEvent e)
           {
             int row = markTable.getSelectedRow();
             int column = markTable.getSelectedColumn();
               int u = 0;

             if (row == -1 || column == -1)

               return; 

             else
             {
                 u = row;   
                 mainPanel.jButton1.setEnabled(true);
                 mainPanel.jButton2.setEnabled(true);
                 
                 if(frame.state == frame.FINISHED)
                 mainPanel.jButton5.setVisible(true);
                 
             if(u  == 0)
              mainPanel.jButton2.setEnabled(false);
              
             if(++u == panelsList.size())
              mainPanel.jButton1.setEnabled(false);
              
             currentPanel = row;
             panelsList.get(row).setVisible(true);
             frame.mark(panelsList.get(row));
             frame.validate();
             mainPanel.jButton7.setEnabled(true);
             
                 mainPanel.question.setVisible(true);
                 mainPanel.answers.setVisible(true);

             }
           }

         });
         
     }//
     
   private void showResultPanel()
   {
       mainPanel.jButton5.setVisible(false);
       mainPanel.jButton6.setVisible(false);
       mainPanel.jButton1.setEnabled(false);
       mainPanel.jButton2.setEnabled(false);
       mainPanel.jButton3.setEnabled(false);
       mainPanel.question.setVisible(false);
       mainPanel.answers.setVisible(false);
       
       results.setVisible(true);
       results.validate();
       frame.finish(results);
       frame.validate();
   }
   
   private void showNotePanel()
   {
        
       NotePanel note = new NotePanel();
       note.getJTextArea1().setText(questionsList.get(currentPanel).getNote());
       mainPanel.jButton1.setEnabled(false);
       mainPanel.jButton2.setEnabled(false);
       mainPanel.jButton6.setVisible(true);
       mainPanel.jButton5.setVisible(false);
       mainPanel.question.setVisible(false);
       mainPanel.answers.setVisible(false);
    
       
       note.setVisible(true);
       frame.finish(note);
       frame.validate();
       
   }//
   
   
    private void closeNotePanel()
    {
       
        int u = currentPanel;
        mainPanel.jButton1.setEnabled(true);
        mainPanel.jButton2.setEnabled(true);
        mainPanel.question.setVisible(true);
        mainPanel.answers.setVisible(true);
        
        if(u  == 0)
         mainPanel.jButton2.setEnabled(false);
         
        if(u == panelsList.size())
         mainPanel.jButton1.setEnabled(false);
         
        mainPanel.jButton6.setVisible(false);
        mainPanel.jButton5.setVisible(true);
        
        panelsList.get(currentPanel).setVisible(true);
        frame.finish(panelsList.get(currentPanel));
        frame.validate();
    }//
    
    private void showMarkPanel()
    {
     
        markTable = new JTable();   
        
        mainPanel.jButton1.setEnabled(false);
        mainPanel.jButton2.setEnabled(false);
        mainPanel.jButton7.setEnabled(false);
        mainPanel.jButton5.setVisible(false);
        mainPanel.question.setVisible(false);
        mainPanel.answers.setVisible(false);
        
        Calculator c = new Calculator(questionsList);
        c.extractMark(panelsList);
        
        MarkTable marka = new MarkTable(c.getMarkResult());
        markTable = marka.getTable();
        addMarkTableListener();
        marks = new MarkPanel(markTable);
        marks.setVisible(true);
        frame.mark(marks);
        frame.validate();
        
        
    }//
    
    private void showQuestionPanel()
    {
        
     queView = new QuestionView(panelsList.get(currentPanel).getJTextArea1()); 
     ansqueFrame = new AnsQueFrame(queView,null);
        
        
        
    }//
    
    private void showAnswersPanel()
    {
        
        ansView = new AnswersView(panelsList.get(currentPanel).getAnswerPanel()); 
        ansqueFrame = new AnsQueFrame(null,ansView);
        
        
    }//
    
     private class Clock extends Thread
         {
          
           private JLabel label = new JLabel("Time : ");
           
           private int minute = 0;
           private int second = 1;
           private String m = "";
           private String s = "";
           private int rat = 0;
           

           public void run()
           {
      
            minute =  PageraExam.examTime;
            PageraExam.timeProgress.setMinimum(0);
            PageraExam.timeProgress.setMaximum(minute);
            PageraExam.timeProgress.setForeground(Color.GREEN);
            
               PageraExam.timeProgress2.setMinimum(0);
               PageraExam.timeProgress2.setMaximum(minute);
               PageraExam.timeProgress2.setForeground(Color.GREEN);
               
               
               PageraExam.timeProgress.setStringPainted(false);
               PageraExam.timeProgress2.setStringPainted(false);
               
               
            setTime();
             
           }
           public void setLabel(JLabel l)
           {
             label = l;
           }
           
           private void setTime()
           {
  
               while(true){    
                        
                         try {
                       
                  if(frame.state == ExamFrame.FINISHED)
                  break;
                  
                 
                 PageraExam.time.setText("Time  :  "+m+(minute)+"  :  "+s+(--second));
                    
                 
                     if(minute == 0 && second == 0)
                         finish();
                         
                        
                     if(second == 0)
                      {
                        second = 60;
                        --minute;
                        PageraExam.timeProgress.setValue(++rat);
                        PageraExam.timeProgress2.setValue(++rat);
                        
                      }////
        
                      
                      if(second < 11)
                        s = "0";
                      else
                        s = "";
                        
                      if(minute < 11)
                        m = "0";
                      else
                        m = "";
                             /////////////////
                        //////
                            /////////////////
           
                    
                         if( minute <= (PageraExam.examTime/3))
                          {
                           PageraExam.time.setForeground(Color.RED);
                           PageraExam.timeProgress.setForeground(Color.RED);
                           PageraExam.timeProgress2.setForeground(Color.RED);
                           
                           
                          }
                         Thread.sleep(1000);
                         }
                        catch(InterruptedException eof )
                        {
                             continue ;
                        }
                       
               }           
                     
      }//////////////
         
         public JLabel getLabel()
         {
             return label;
         }//////
         
         }    
}