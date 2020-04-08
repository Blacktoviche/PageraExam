package pagera.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import pagera.bean.Answer;
import pagera.bean.Exam;
import pagera.bean.Question;
import pagera.bean.Writer;

import pagera.view.wizard.ExamProgress;
import pagera.view.wizard.ProgressPanel;
import pagera.view.wizard.ProgressExamWindow;


public class XMLWriter extends Thread
{

    private Document document;
    private Element root;
    private Exam exam;
    private ExamProgress progress1;
    private ExamProgress progress2;
    private int count1;
    private int count2;
    private ProgressPanel progPanel;
    private ProgressExamWindow window;
   
    public XMLWriter(Exam exam) 
    {
    
        progPanel = new ProgressPanel();
        progress1 = progPanel.jProgressBar1;
        progress2 = progPanel.jProgressBar2;
        this.exam = exam;
        count1 = 100 / exam.getQuestionsCount();
        
      window = new ProgressExamWindow(progPanel);
        
    }///////////
 

    public void run()
    {
       
        
        
        
        File xmlFile = new File("Exams"+
        System.getProperty("file.separator")+exam.getName()+".xml");
        
        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();

        try
        {

            DocumentBuilder builder = factory.newDocumentBuilder();


            document = builder.newDocument();

            root = document.createElement("exam");
            document.appendChild(root);
            buildExam(root , exam);
             
             //////////////
             ///////////////
             /////////
             
            Source xmlSource = new DOMSource( document );

            Result result = new StreamResult( new FileOutputStream(xmlFile) );

            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer =
            transformerFactory.newTransformer();
           
            progPanel.question.setText("Building Exam File .. ");
            progPanel.answer.setText("...............");
            print();
            transformer.transform( xmlSource, result );
            progPanel.question.setText("Exam File Was Saved Successfully.. ");
            progPanel.answer.setText(".......");
        
            window.setVisible(false);
            
            JOptionPane.showMessageDialog(null, "Exam Was Saved " +
            "this window will be closed");
            
            System.exit(0);

        }

        catch(TransformerFactoryConfigurationError factoryError )
        {
            factoryError.printStackTrace();
        }
        catch (ParserConfigurationException pc)
        {
            pc.printStackTrace();
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
        catch(Exception excep )
        {
            excep.printStackTrace();
        }
       
        
    }///////////
    
    private void buildExam(Element root , Exam exam)
    {
       
       root.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
       root.setAttribute("xsi:schemaLocation","http://www.pagera.i8.com ExamSchema.xsd");
       root.setAttribute("xmlns","http://www.pagera.i8.com");
       
       Element name = document.createElement("name");
       name.appendChild(document.createTextNode(exam.getName()));
       
       Element time = document.createElement("time");
       time.appendChild(document.createTextNode(""+exam.getTime()));
       
       Element questionsCount = document.createElement("questionscount");
       questionsCount.appendChild(document.createTextNode(""+exam.getQuestionsCount()));
        
       Element rate = document.createElement("average");
       rate.appendChild(document.createTextNode(""+exam.getAverage())); 
       
       
    root.appendChild(name);
    root.appendChild(time);
    root.appendChild(questionsCount);
    root.appendChild(rate);
       
    
    buildQuestions(root , exam);
    buildWriter(root , exam.getWriter());
    
        
}////////
    
    
    private void buildQuestions(Element root , Exam exam)
    {
        int coun =0;
        for (int i = 0 ; i < exam.getQuestionsCount() ; i++ )
        {
        
        progPanel.question.setText("Building Question .. "+(++coun));
        Question currentQuestion = exam.getQuestionsList().get(i);
        Element question = document.createElement("question");
        
        Element questionString = document.createElement("questionstring");
        questionString.appendChild(document.createTextNode(currentQuestion.getQuestion()));
            
        Element mode = document.createElement("mode");
        mode.appendChild(document.createTextNode(currentQuestion.getMode()));
        
        Element answersCount = document.createElement("answerscount");
        answersCount.appendChild(document.createTextNode(""+currentQuestion.getAnswers().size()));
        
        Element note = document.createElement("note");
        note.appendChild(document.createTextNode(currentQuestion.getNote()));
         
         
        //add Question Properties 
        question.appendChild(questionString);
        question.appendChild(mode);
        question.appendChild(answersCount);
        question.appendChild(note);
        
        buildAnswers(question , currentQuestion);
        root.appendChild(question);
       
     
         progress1.setValue( (i * count1) );        
        
        
     }//end for
    
    }////////
    
    
    private void buildAnswers(Element question , Question current)
    {
        
      int coun = 0;
      count2 = 100 / current.getAnswers().size();
      
      for(int i = 0; i < current.getAnswers().size() ; i++)
      {
       
       progPanel.answer.setText("Building Answer .. "+(++coun));
       
       Answer currentAnswer = current.getAnswers().get(i);
       
       Element answer = document.createElement("answer");
       
       Element state = document.createElement("state");
       state.appendChild(document.createTextNode(""+currentAnswer.isRight()));
       
       Element answerString = document.createElement("answerstring");
       answerString.appendChild(document.createTextNode(currentAnswer.getAnswer()));
       
      
       answer.appendChild(state);
       answer.appendChild(answerString);
       
       question.appendChild(answer);

        progress2.setValue( (i * count2 ) );        
           
      }//end for
        
}///////////
    
    
    private void buildWriter(Element root , Writer wrt)
    {
       
      Element writer = document.createElement("writer");  
      Element name = document.createElement("wname");
      name.appendChild(document.createTextNode(wrt.getName()));
      
      Element mail = document.createElement("mail");
      mail.appendChild(document.createTextNode(wrt.getMail()));  
      
      Element webAddress = document.createElement("webaddress");
      webAddress.appendChild(document.createTextNode(wrt.getWebAddress()));
      
       
     Element description = document.createElement("description");
     description.appendChild(document.createTextNode(wrt.getDescription()));
       
       
      writer.appendChild(name);
      writer.appendChild(mail);
      writer.appendChild(webAddress);
      writer.appendChild(description);
      
      root.appendChild(writer);
        
    }///////////////

    private void print()
    {
     
       for (int i = 0 ; i <  exam.getQuestionsList().size(); i++)
       {
           Question dd = exam.getQuestionsList().get(i);
          System.out.println("Question "+i+" :"+dd.getQuestion());
          System.out.println("Question Mode : "+dd.getMode());
          for (int y = 0 ; y < dd.getAnswers().size() ; y++ )
          {
              Answer a =   dd.getAnswers().get(y); 
              System.out.println("Answer "+y+" :"+a.getAnswer());
              System.out.println("Answer state : "+a.isRight());
                   
          }
          
             
       }
       
    }
}//////
