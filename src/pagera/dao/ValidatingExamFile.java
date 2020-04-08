package pagera.dao;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class ValidatingExamFile
{

     static final String schemaSource = "ExamSchema"+
    System.getProperty("file.separator")
    +"ExamSchema.xsd";
    
    static final String JAXP_SCHEMA_SOURCE =
    "http://java.sun.com/xml/jaxp/properties/schemaSource";
  
    private String errorMessage;
    
   
    public ValidatingExamFile() 
    {
        
    }
    
    public boolean isValide(String fileName)
    { 
        try{
        
        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse( new File("Exams"+System.getProperty("file.separator")+fileName) );

        Node root = document.getDocumentElement();
        
        DOMSource ds = new DOMSource(root);
        
        
        SchemaFactory fac = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        
        //Schema sc = fac.newSchema(new File(schemaSource));

        //Validator  val = sc.newValidator();
        
        //val.validate(ds);
        
        }
        catch(Exception ex)
        {
        System.out.println("nnnnnnn"+ex.getMessage());
            ex.printStackTrace();
         errorMessage = ex.getMessage();
         return false;
        }
       
        return true;
    }////
    
    public String getErrorMessage() 
    {
        return errorMessage;
    }/////
}   
