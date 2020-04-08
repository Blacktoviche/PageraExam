package pagera.driver;

import java.util.List;

import pagera.bean.Question;
import pagera.logic.wizard.QuestionStore;

public class SerializQuestionCreater implements QuestionCreater
{
   
    private QuestionStore qs ;
    
    /**
     * the Old way to create Questions 
     * @deprecated you should not use this class
     */
    public SerializQuestionCreater()
    {
    
      qs = new QuestionStore();
    
    }
    
   
    public List<Question> getQuestions(String questionFolder)
    {    
        
     return qs.getQuestions(questionFolder);
    
    }//
    
    
    public Question createQuestion(int id)
    {
    
     return new Question();
     
    }
}
