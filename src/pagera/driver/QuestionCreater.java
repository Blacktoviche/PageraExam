package pagera.driver;

import pagera.bean.Question;

    /**
     * the Old way to create Questions 
     * @deprecated you should not use this interface
     */
public interface QuestionCreater 
{
  
  
   Question createQuestion(int id);
   
  
}
