package pagera.info;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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

import pagera.bean.Writer;

    /**
     * the Old way to store Writer Info 
     * @deprecated you should not use this class
     */
public class InfoWriter
        {

            private   Writer writer;
            
            public InfoWriter()
            {
            }


            public void store(Writer wr , String folderPath)
            {

            writer = fillWriter(wr);
            
            File xmlFile = new File(folderPath+System.getProperty("file.separator")+"Info.xml");

            DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();

            try
            {

             DocumentBuilder builder = factory.newDocumentBuilder();


             Document document = builder.newDocument();

             Element root = document.createElement("writer");

            

             Element name = document.createElement("name");
             name.appendChild(document.createTextNode(writer.getName()));


             Element mail = document.createElement("mail");
             mail.appendChild(document.createTextNode(writer.getMail()));
             
             Element webAddress = document.createElement("webAddress");
             webAddress.appendChild(document.createTextNode(writer.getWebAddress()));

             Element description = document.createElement("description");
             description.appendChild(document.createTextNode(writer.getDescription()));
        



             root.appendChild(name);
             root.appendChild(mail);
             root.appendChild(webAddress);
             root.appendChild(description);

             document.appendChild(root);

             Source xmlSource = new DOMSource( document );


             Result result = new StreamResult( new FileOutputStream(xmlFile) );


            TransformerFactory transformerFactory = TransformerFactory.newInstance();


            Transformer transformer =
            transformerFactory.newTransformer();
            //transformer.setOutputProperty( "indent", "yes" );


             transformer.transform( xmlSource, result );

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

        }
        
        private static Writer fillWriter(Writer wr)
        {
            Writer returned = new Writer();
            
            if(!wr.getName().trim().equals(""))
              returned.setName(wr.getName());
            
            if(!wr.getMail().trim().equals(""))
              returned.setMail(wr.getMail());
            
            if(!wr.getWebAddress().trim().equals(""))
              returned.setWebAddress(wr.getWebAddress());
            
            if(!wr.getDescription().trim().equals(""))
              returned.setDescription(wr.getDescription());  
            
            
          return returned;
          
        }//
        
    }//