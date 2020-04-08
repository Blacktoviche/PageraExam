package pagera.driver;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import pagera.dao.ManageQuery;

import pagera.bean.Answer;
import pagera.bean.Question;

import pagera.dao.ReadAll;


public class DataQuestionCreater implements QuestionCreater 
{
    
    private ManageQuery manageQuery;
    private Question question;
    private ReadAll readall = new ReadAll();
    private Vector answerTable;
    
    
    /**
     * the Old way to create Questions 
     * @deprecated you should not use this class
     */
    public DataQuestionCreater()
    {
        
        manageQuery = new ManageQuery();
        question = new Question();
        
    }
    
    public Question createQuestion(int id)
    {
    
        String qu[] = getQuestionText(id);
        
        question.setQuestion(qu[0]);
        question.setAnswers(getAnswers(id));
        
        if(qu[1].equals(Question.MULTI))
            question.setMode(Question.MULTI);
        else
            question.setMode(Question.SINGLE);
        
        question.setNote(qu[2]);  
        
        return question; 
         
    }//
    
    
    private String[] getQuestionText(int i)
    {
        
          String qu[] = new String[3];
          
          Vector result0 = readall.getResultSetAsVector("SELECT QText , state  , NOTE FROM Question where id = "+i);
          Vector result = (Vector) result0.get(0);
          
           qu[0]  = result.get(0).toString(); 
           qu[1] = result.get(1).toString(); 
           qu[2] = result.get(2).toString(); 
  
      
         return qu; 
      
    }//
    
    private List<Answer> getAnswers(int i)
    {  
    
    List<Answer> answers = new LinkedList<Answer>();
     
    Vector result = readall.getResultSetAsVector
    ("SELECT AText , right FROM Answer where Question_ID = "+i);
         
         
         for(int u = 0; u < result.size(); u++)
         {
           
             
               Answer answer = new Answer();
               answerTable = (Vector) result.get(u);
               answer.setAnswer(answerTable.get(0).toString());
               answer.setState( Boolean.parseBoolean(
               answerTable.get(1).toString()));
       
               answers.add(answer);
        
         }//
        
        return  answers;
    }//
}
