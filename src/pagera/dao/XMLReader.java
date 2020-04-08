package pagera.dao;

import java.io.File;

import javax.swing.JOptionPane;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import pagera.bean.Exam;

import pagera.view.wizard.ProgressExamWindow;
import pagera.view.wizard.ProgressPanel;

public class XMLReader 
{
 
    private MyXMLDefaultHandler handler;    
   
    
    public XMLReader(String fileName)
    {
        
        handler = new MyXMLDefaultHandler();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        
        try {
           
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse( new File("Exams"+
            System.getProperty("file.separator")+fileName), handler);
        

        } 
        catch (Throwable t)
        {
              t.printStackTrace();
            JOptionPane.showMessageDialog(null,"The Message is : \n" +
             t.getMessage(),"Error While Reading Exam File",JOptionPane.ERROR_MESSAGE);
        }
    }////////////

    
    public Exam getExam()
    {
        return handler.getExam();
    }/////
}
