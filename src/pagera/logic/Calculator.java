package pagera.logic;

import java.awt.Color;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JViewport;


import pagera.bean.Answer;
import pagera.bean.Question;

import pagera.view.AnswerPanel;
import pagera.view.MultiAnswerPanel;
import pagera.view.QuestionPanel;
import pagera.view.SingleAnswerPanel;

public class Calculator 
{
    private List<Answer> answersList;
    private List<Question> questionsList; 
    private List<Boolean> finalResult;
    private List<Boolean> markResult;
    private int rate = 0;
    public Calculator(List<Question> questionsList) 
    {
    
     
        answersList = new LinkedList<Answer>();
        this.questionsList = questionsList;
        
        finalResult  = new LinkedList<Boolean>();
        markResult   = new LinkedList<Boolean>();
        
    }
    
    public void extract(List<Answer> lista)
    {
 
        
    }//
    
     public void extractAnswers(List<QuestionPanel> lista)
     {
         
         for (int i = 0 ; i < lista.size() ; i++ )
         {
                
                
                QuestionPanel qPanel = lista.get(i);
                JViewport view = ( (JScrollPane) qPanel.getComponents()[0] ).getViewport();
                AnswerPanel ap = (AnswerPanel) view.getView();
             
                if(ap instanceof MultiAnswerPanel)
                {
                
                  extractMulti( ap , i); 
                    
                }
               
               else{
                   
                  extractSingle( ap , i);
               }
                
         }
         
     }//
     
   
     private void extractMulti(AnswerPanel mult , int num)
     {
          
          MultiAnswerPanel multi = (MultiAnswerPanel) mult;   
          
          List<String> answers = getMultiRightAnswer(questionsList.get(num));
          
          List<Boolean> resultLista  = new LinkedList<Boolean>();
   
              for (int f = 0 ; f <  multi.getBoxs().length ; f++)
              {
                
                if(isRight( answers , multi.getBoxs()[f].getText()))
                    multi.getBoxs()[f].setBackground(Color.GREEN);
         
                   
                    
            ///////////////////////////     
               if(multi.getBoxs()[f].isSelected()) 
               {
          
                           
                if(isRight( answers , multi.getBoxs()[f].getText())) 
                {
                    resultLista.add(true);
                    rate++;
                }   
                else
                    multi.getBoxs()[f].setBackground(Color.RED);
                
               }  
               
            }

           finalResult.add((answers.size() == resultLista.size()));
         
     }//
     
     
     
      private void extractSingle(AnswerPanel sing , int nu)
      {
 
          SingleAnswerPanel single = (SingleAnswerPanel) sing;
          
          String answer = getSingleRightAnswer(questionsList.get(nu));
          
           for (int u = 0 ; u < single.getRadios().length ; u++ )
            {
              
                if(single.getRadios()[u].getText() == answer)
                    single.getRadios()[u].setBackground(Color.GREEN);
                
                if(single.getRadios()[u].isSelected()) 
                {

                if (single.getRadios()[u].getText() == answer)
                 {
                      
                     finalResult.add(true);
                      rate++;
                       return;
                 }
                    single.getRadios()[u].setBackground(Color.RED);        
                }
                   
            }//
            
          finalResult.add(false);
           
      }//
      
      
      private String getSingleRightAnswer(Question q) 
      {
          
         
          List<String> rigthAnswers = new LinkedList<String>();
          
          for (int h = 0 ; h < q.getAnswers().size() ; h++ )
          {
           
            if(q.getAnswers().get(h).isRight()) 
              {
          
               rigthAnswers.add(q.getAnswers().get(h).getAnswer());
          
              }   
          }
          
          return rigthAnswers.get(0);     
          
      }//
      
      
      private List<String> getMultiRightAnswer(Question q)
      {
          List<String> rigthAnswers = new LinkedList<String>();
          
          for (int h = 0 ; h < q.getAnswers().size() ; h++ )
          {
           
            if(q.getAnswers().get(h).isRight()) 
              {
     
               rigthAnswers.add(q.getAnswers().get(h).getAnswer());
    
              }   
          }
          
          return rigthAnswers;
    
      }//
      

     private boolean isRight(List<String> answs , String answe)
     {
         
         for (int i = 0 ; i < answs.size() ; i++ )
         {
          
          if(answs.get(i).equals(answe))
            return true;
             
         }
         
        return false; 
         
     }//
     
     public void extractMark(List<QuestionPanel> lista)
     {
         for (int i = 0 ; i < lista.size() ; i++ )
         {
            
             markResult.add(lista.get(i).getBox().isSelected());   
             
         }
         
     }//
    
    public void setFinalResult(List<Boolean> finalResult) {
        this.finalResult = finalResult;
    }

    public List<Boolean> getFinalResult()
    {
        return finalResult;
    }

    public void setMarkResult(List<Boolean> markResult) {
        this.markResult = markResult;
    }

    public List<Boolean> getMarkResult() {
        return markResult;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}//
