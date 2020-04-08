package pagera.logic.tables;

public class AnswerColumns {

    private int question;
    private boolean result;


    

    public AnswerColumns(int question, boolean result )
     {
  
       this.question = question;
       this.result = result;

    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int getQuestion() {
        return question;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }

}
