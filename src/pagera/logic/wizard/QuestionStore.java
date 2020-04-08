package pagera.logic.wizard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import pagera.info.InfoReader;

import pagera.bean.Question;

    /**
     * the Old way to Store Questions 
     * @deprecated you should not use this class
     */
public class QuestionStore
{
    
    private ObjectOutputStream output ;
    private ObjectInputStream input;
    private List<Question> lista;
    private String w = null;
    private InfoReader inforeader = new InfoReader();
    
    
   
    public QuestionStore()
    {
    
        
    }
    
    public void put(Question que , File dis)
    {
     
     try{   
       
        File disO = new File(dis.getAbsolutePath()+".PageraExam");
        output = new ObjectOutputStream( new FileOutputStream(disO));
        output.writeObject(que);
     }
     catch(Exception ex)
     {
         JOptionPane.showMessageDialog(null ,ex.getMessage());
     }
        
    }//
    
   
    public List<Question> getQuestions(String qFolder)
    {
       lista = new LinkedList<Question>();
       File que = new File("Exams"+System.getProperty("file.separator")+qFolder); 
      
      for (int i = 0 ; i < que.listFiles().length ; i++ )
      {
          
          if(que.listFiles()[i].getName().equals("Info.xml"))
            {
            inforeader.read(que.listFiles()[i]);
            }
        else
          lista.add(get(que.listFiles()[i])); 
          
     
      }
        
      return lista;
    }//
    
    
    public Question get(File dist)
    {
        Question qw = new Question();
        
        try{
     
          input = new ObjectInputStream(new FileInputStream(dist));
         
         qw = (Question) input.readObject();
        
        

        }
        catch(Exception ex)
        {
        JOptionPane.showMessageDialog(null , "Error reading file : "+dist.getName() +" please make sure this is question file or delete it the program will terminate"
        ,"Fatal Error",JOptionPane.ERROR_MESSAGE); 
          System.exit(0);
        }
        
        return qw;
    }//
}
