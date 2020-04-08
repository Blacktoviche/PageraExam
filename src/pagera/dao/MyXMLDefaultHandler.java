package pagera.dao;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.LinkedList;
import java.util.List;

import java.util.Stack;

import javax.swing.JOptionPane;

import javax.swing.SwingUtilities;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import pagera.bean.Answer;
import pagera.bean.Exam;
import pagera.bean.Question;
import pagera.bean.Writer;

import pagera.view.PageraExam;
import pagera.view.wizard.ExamProgress;
import pagera.view.wizard.ProgressExamWindow;
import pagera.view.wizard.ProgressPanel;


public class MyXMLDefaultHandler extends DefaultHandler
{


        private Exam exam = new Exam();
        private int state = 0;
        private List<Question> questions = new LinkedList<Question>();
        private List<Answer> answers = new LinkedList<Answer>();
        private Question currentQ = new Question();
        private Answer currentA = new Answer();
        private Writer currentW = new Writer();
        private StringBuffer buffy;
        
       // private int aRate = 0;
      //  private int qRate = 0;
      // private int queCount = 0;
       // private int answCount = 0;
       
        
        
        
        
        public MyXMLDefaultHandler( )
        {
        }
    
        public void setDocumentLocator(Locator l)
        {
        }
        public void startDocument()
        throws SAXException
        {
             
        }
        public void endDocument()
        throws SAXException
        {
      
        }
        public void startElement(String namespaceURI,String sName,String qName, Attributes attrs)
        throws SAXException
        {
            
            buffy = new StringBuffer();
   
            checkElement(qName); 
             
        }///
        
        public void endElement(String namespaceURI , String sName , String qName )
        throws SAXException
        {
     
             
             storeValues(buffy.toString());
             buffy.delete(0 , buffy.length());
       
            if(qName.equals("question"))
              {
               
               currentQ.setAnswers(answers);
               questions.add(currentQ);
               currentQ = new Question();
               answers = new LinkedList<Answer>();
                  
              } 
              
            if(qName.equals("answer"))
              {
               
               answers.add(currentA);
               currentA = new Answer();
              
              } 
              
              if(qName.equals("exam"))
              {
                  
                exam.setQuestionsList(questions);
                exam.setWriter(currentW);
                PageraExam.writer = exam.getWriter();
              }
            
        }///////

        public void characters(char buf[], int offset, int len)
        throws SAXException
        {
       
 
            buffy.append(buf , offset , len);
          

        }//////


     private void checkElement(String qName)
     {
         
         if(qName.equals("name"))
          {
          state = 1;
          return;
          }
         if(qName.equals("time"))
          {
           state = 2;
           return;
          }
         if(qName.equals("questionscount"))
          {
           state = 3;
           return;
          }
         if(qName.equals("average"))
          {
           state = 4;
           return;
          }
          
          if(qName.equals("question"))
          {                      
       
             currentQ = new Question();
             state = 100;
             return;
          }
          if(qName.equals("questionstring"))
          {
              state = 5;
              return;
          }
         if(qName.equals("mode"))
         {
             state = 6;
             return;
         }
         if(qName.equals("answerscount"))
         {
             state = 7;
             return;
         }
         if(qName.equals("note"))
         {
             state = 8;
             return;
         }
         if(qName.equals("answer"))
         {
        
             currentA = new Answer();
             state = 100;
             return;
         }
         if(qName.equals("state"))
         {
             state = 9;
             return;
         }
         if(qName.equals("answerstring"))
         {
             state = 10;
             return;
         }
         if(qName.equals("writer"))
         {
             currentW = new Writer();
             state = 100;
             return;
         }
         if(qName.equals("wname"))
         {
             state = 11;
             return;
         }
         if(qName.equals("mail"))
         {
             state = 12;
             return;
         }
         if(qName.equals("webaddress"))
         {
             state = 13;
             return;
         }
         if(qName.equals("description"))
         {
             state = 14;
             return;
         }
          
     }/////////////////

     private void storeValues(String value)
     {
           
        switch(state)
        {
            
            case 1  : exam.setName(value);
            break;
            case 2  : exam.setTime(Integer.parseInt(value.trim()));
            break;
            case 3  : exam.setQuestionsCount(Integer.parseInt(value));
            break;
            case 4  : exam.setAverage(Integer.parseInt(value));
            break;
            case 5  : currentQ.setQuestion(value);
            break;
            case 6  : currentQ.setMode(value);
            break;
            case 7  : currentQ.setAnswersCount(Integer.parseInt(value));
            break;
            case 8  : currentQ.setNote(value);
            break;
            case 9  : currentA.setState(Boolean.parseBoolean(value));
            break;
            case 10 : if(!value.trim().equals("") ) currentA.setAnswer(value);
            break;
            case 11 : currentW.setName(value);
            break;
            case 12 : currentW.setMail(value);
            break;
            case 13 : currentW.setWebAddress(value);
            break;
            case 14 : currentW.setDescription(value);
            break;
          
        }////end switch
         
     }////

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Exam getExam() {
        return exam;
    }
}
