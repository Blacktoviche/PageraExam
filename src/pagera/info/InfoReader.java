package pagera.info;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

import pagera.bean.Writer;

import pagera.view.PageraExam;


    /**
     * the Old way to read Writer Info 
     * @deprecated you should not use this class
     */
public class InfoReader
    {


       private  Writer writer = new Writer();
       
       public  void read(File infoFile)
       {
          try {

        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse( infoFile );

        Node allNodes = document.getDocumentElement();


        NodeList  rootNode = allNodes.getChildNodes();



         for(int i = 0; i < rootNode.getLength(); i++)
           {


            if(!rootNode.item(i).getNodeName().equals("#text") )
             {

              String elementName =  rootNode.item(i).getNodeName() ;

                
              if(elementName.equals("name"))
               {
               writer.setName(rootNode.item(i).getFirstChild().getNodeValue() );
                continue;
               }
              if(elementName.equals("mail"))
              {
               writer.setMail(rootNode.item(i).getFirstChild().getNodeValue() );
                continue;
              }
            
              if(elementName.equals("webAddress"))
              {
               writer.setWebAddress(rootNode.item(i).getFirstChild().getNodeValue() );
                continue;
              }
                  
              if(elementName.equals("description"))
              {
               writer.setDescription(rootNode.item(i).getFirstChild().getNodeValue() );
                continue;
              }

             }

           }
  
            PageraExam.writer = writer;
              
          }

         catch ( ParserConfigurationException parserError ) {

               parserError.printStackTrace();
             }

         catch ( IOException io ) {

               io.printStackTrace();
             }

         catch ( SAXException parseException ) {

                 parseException.printStackTrace();
               }

       }
       
    }