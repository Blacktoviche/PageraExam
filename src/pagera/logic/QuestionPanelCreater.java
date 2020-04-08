package pagera.logic;


import javax.swing.JLabel;

import pagera.bean.Question;

import pagera.view.MultiAnswerPanel;
import pagera.view.QuestionPanel;
import pagera.view.SingleAnswerPanel;


public class QuestionPanelCreater 
{
    

    
    public QuestionPanelCreater()
    {
      
    }
    
    public QuestionPanel getQPanel(Question q , int num )
    {
  
     if(q.getMode().equals(Question.MULTI))
       {
        
       QuestionPanel qPanel1 = new QuestionPanel(multiPanel(q));
       qPanel1.setQuestionText(q.getQuestion());
       qPanel1.setQN(++num);
       qPanel1.validate();
       
       return qPanel1;
       
       }
     else
        {
          
        QuestionPanel qPanel2 = new QuestionPanel(singlePanel(q));
        qPanel2.setQuestionText(q.getQuestion());
        qPanel2.setQN(++num);
        qPanel2.validate();
        
        return qPanel2;  
        
        }
     
     
     
    }
     
    private MultiAnswerPanel multiPanel(Question q) 
    {
        
        MultiAnswerPanel map = new MultiAnswerPanel();
        map.setBoxs(q.getAnswers());
        map.validate();
        
        return map;
        
    }//
    
    private SingleAnswerPanel singlePanel(Question q) 
    {
        
        SingleAnswerPanel sap = new SingleAnswerPanel();
        
        sap.setRadios(q.getAnswers());
        sap.validate();
      
        return sap;
    }//
}
